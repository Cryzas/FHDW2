package viewClient;

import view.*;
import view.objects.ViewRoot;
import view.objects.ViewObjectInTree;

import view.visitor.AnythingStandardVisitor;

import java.util.Optional;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;


import com.sun.javafx.geom.Point2D;

import javax.swing.tree.TreeModel;


public class UserManagerClientView extends BorderPane implements ExceptionAndEventHandler{

	private ConnectionMaster 		 connection;
	private ExceptionAndEventHandler parent;	
	private UserManagerView 		 		 service;

	/**
	 * This is the default constructor
	 */
	public UserManagerClientView( ExceptionAndEventHandler parent, UserManagerView service) {
		super();
		this.parent = parent;
		this.service = service;
		this.initialize();
	}
	@SuppressWarnings("unused")
	private UserManagerView getService(){
		return this.service;
	}
	private void initialize() {
        this.setCenter( this.getMainSplitPane());
        if( !WithStaticOperations && this.getMainToolBar().getItems().size() > 0){
        	this.setTop( this.getMainToolBar() );
        }
	}
	private ToolBar mainToolBar = null;
	private ToolBar getMainToolBar() {
		if( this.mainToolBar == null){
			this.mainToolBar = new ToolBar();
			for( Button current : this.getToolButtonsForStaticOperations()) {
				this.mainToolBar.getItems().add( current );
			}
		}
		return this.mainToolBar;
	}
	private SplitPane mainSplitPane = null;
	private SplitPane getMainSplitPane() {
		if( this.mainSplitPane == null) {
			this.mainSplitPane = new SplitPane();
			this.mainSplitPane.setOrientation( Orientation.HORIZONTAL);
			this.mainSplitPane.getItems().addAll( this.getNavigationSplitPane(), this.getTitledDetailsPane() );	
			this.mainSplitPane.setDividerPosition( 0, 0.5);
			this.mainSplitPane.prefHeightProperty().bind( this.heightProperty());
			this.mainSplitPane.prefWidthProperty().bind( this.widthProperty());
		}
		return this.mainSplitPane;
	}
	private SplitPane navigationSplitPane = null;
	private SplitPane getNavigationSplitPane(){
		if( this.navigationSplitPane == null ){
			this.navigationSplitPane = new SplitPane();
			this.navigationSplitPane.setOrientation( Orientation.VERTICAL);
			this.navigationSplitPane.getItems().addAll( this.getNavigationPanel(), this.getErrorPanel());
			this.navigationSplitPane.prefHeightProperty().bind( this.getMainSplitPane().heightProperty());
			this.navigationSplitPane.setDividerPosition( 0, 1.0);
			this.navigationSplitPane.heightProperty().addListener(new ChangeListener<Number>() {
				public void changed(
						ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if(! getErrorPanel().isVisible()) {						
						navigationSplitPane.setDividerPosition(0, 1.0);
					} else {						
						navigationSplitPane.setDividerPosition(0, 0.7);
					}
				}
			});
			this.getErrorPanel().setMinHeight(0);
		}
		return this.navigationSplitPane;
	}
	private TitledPane treePanel = null;
	private TitledPane getNavigationPanel() {
		if( this.treePanel == null) {
			this.treePanel = new TitledPane( GUIConstants.NaviationTitle, this.getNavigationTree() );
			this.treePanel.setCollapsible( false );
			this.treePanel.prefHeightProperty().bind( this.getNavigationSplitPane().heightProperty());
		}
		return treePanel;
	}
	private TitledPane errorPanel = null;
	private TitledPane getErrorPanel(){
		if( this.errorPanel == null){
			this.errorPanel = new TitledPane( GUIConstants.ErrorTitle, this.getErrorTree());
			this.errorPanel.setCollapsible( false );
			this.errorPanel.setVisible( false );
		}
		return this.errorPanel;
	}

	private TreeRefresh errorTree = null;
	private TreeRefresh getErrorTree(){
		if( this.errorTree == null){
			this.errorTree = new TreeRefresh(parent);
			this.errorTree.setOnContextMenuRequested( new EventHandler<ContextMenuEvent>() {
				public void handle(ContextMenuEvent e) {
					tryShowContextMenu( e, errorTree, false);					
				}
			});
		}
		return this.errorTree;
	}
	private void setErrors( TreeModel errors){
		this.getErrorPanel().setVisible(true);
		this.getErrorTree().setModel( errors );
		this.getNavigationSplitPane().setDividerPosition(0, 0.7);
	}
	private void setNoErrors(){
		this.getErrorPanel().setVisible(false);
        this.getNavigationSplitPane().setDividerPosition(0, 1.0);
	}
	private TitledPane titledDetailsPane = null;
	private TitledPane getTitledDetailsPane() {
		if( this.titledDetailsPane == null ){
			this.titledDetailsPane = new TitledPane();
			this.titledDetailsPane.setText( GUIConstants.DetailsTitle);
			this.titledDetailsPane.setCollapsible(false);			
			this.titledDetailsPane.prefHeightProperty().bind(this.getMainSplitPane().heightProperty());
		}
		return this.titledDetailsPane;		
	}	
	private TreeRefresh navigationTree = null;
	private TreeRefresh getNavigationTree() {
		if( this.navigationTree == null) {
			this.navigationTree = new TreeRefresh( parent );
			this.navigationTree.getSelectionModel().setSelectionMode( SelectionMode.SINGLE);
			this.navigationTree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<ViewObjectInTree>>() {
				public void changed(
					ObservableValue<? extends TreeItem<ViewObjectInTree>> observable,
					TreeItem<ViewObjectInTree> oldValue,
					TreeItem<ViewObjectInTree> newValue) {
					if( menu !=null) menu.hide();
					if( newValue != null ){						
						setDetailsTable( (Anything) newValue.getValue().getWrappedObject());				
					}
				}
			});
			this.navigationTree.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
				public void handle(ContextMenuEvent e) {
					tryShowContextMenu( e, navigationTree, WithStaticOperations);					
				}
			});
			navigationTree.setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if( event.getCode() == KeyCode.F5 ){
						Platform.runLater( new Runnable() {
							public void run() {								
								try {
									getNavigationTree().refreshTree();
								} catch (ModelException e) {
									handleException(e);
								}			
							}
						});
					}
				}
			});
		}
		return this.navigationTree;
	}
	private DetailPanel currentDetails = null;
	protected void setDetailsTable( Anything object) {
		this.getTitledDetailsPane().setVisible( false );
		if (object == null && this.getConnection() != null) object = this.getConnection().getUserManagerView();
		if (object == null){
			this.currentDetails = getNoDetailsPanel();
		}else{
			try {
				this.currentDetails = this.getDetailView(object);
			} catch (ModelException e) {
				this.handleException(e);
				this.currentDetails = null;
			}
			if(this.currentDetails == null) this.currentDetails = getStandardDetailsTable(object);
		}
		this.getTitledDetailsPane().setContent( this.currentDetails );
		this.getTitledDetailsPane().setVisible( true );
		this.currentDetails.prefWidthProperty().bind( this.getTitledDetailsPane().widthProperty() );
	}

	private DetailPanel getDetailView(final Anything anything) throws ModelException {
		class PanelDecider extends AnythingStandardVisitor {

			private DetailPanel result;
			
			public DetailPanel getResult() {
				return this.result;
			}
			protected void standardHandling(Anything Anything) throws ModelException {
				this.result = null;
			}
			//TODO Overwrite all handle methods for the types for which you intend to provide a special panel!
		}
		PanelDecider decider = new PanelDecider();
		anything.accept(decider);
		return decider.getResult();
	}
	private NoDetailPanel noDetailPanel = null;
	public DetailPanel getNoDetailsPanel() {
		if( this.noDetailPanel == null) this.noDetailPanel = new NoDetailPanel(this);
		return noDetailPanel;
	}
	private ContextMenu menu = null;
	protected void tryShowContextMenu( ContextMenuEvent e, TreeRefresh tree, boolean withStaticOperations) {
		if( this.menu !=null ) this.menu.hide();
		SelectionModel<TreeItem<ViewObjectInTree>> selMod = tree.getSelectionModel();
		ViewObjectInTree selVal = selMod.getSelectedItem().getValue();
		ViewRoot selected = selVal.getWrappedObject();
		this.menu = this.getContextMenu( selected, withStaticOperations , new Point2D((float)e.getScreenX(), (float)e.getScreenY() ) );
		if( this.menu.getItems().size() > 0) {
			this.menu.show( this.getNavigationPanel(),  e.getScreenX(), e.getScreenY() );
		}
	}
	
	private DetailPanel getStandardDetailsTable(Anything object) {
		try {
			return DefaultDetailPanel.getStandardDetailPanel(object,this);
		} catch (ModelException e) {
			this.handleException(e);
			return new NoDetailPanel(this);
		}
	}

	public void setConnection(ConnectionMaster connection){
		this.connection = connection;
	}
	public UserManagerConnection getConnection(){
        	return (UserManagerConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		Platform.runLater(new Runnable() {
			public void run(){
				try {
					getNavigationTree().refreshTree();
					java.util.Vector<?> errors = getConnection().getUserManagerView().getErrors();
					if (errors.size() >0 )setErrors( new ListRoot(errors));
					else setNoErrors();
				} catch (ModelException e) {
					handleException(e);
				}			
			}
		});
		//TODO adjust implementation: handleRefresh()!
	}
	/** Is called only once after the connection has been established
	**/
	public void initializeConnection(){
		Platform.runLater( new  Runnable() {
			public void run() {
				getNavigationTree().setModel((TreeModel) getConnection().getUserManagerView());	
				getNavigationTree().getRoot().setExpanded(true);
				getNavigationTree().getSelectionModel().select( getNavigationTree().getRoot());
			}
		});
		//TODO adjust implementation: initializeConnection
	}
	public void handleException(ModelException exception) {
		this.parent.handleException(exception);
	}
	public void handleOKMessage(String message) {
		this.parent.handleOKMessage(message);
	}
	public void handleUserException(UserException exception) {
		this.parent.handleUserException(exception);	
	}	
    private javafx.geometry.Point2D getPointForView(){
    	javafx.geometry.Point2D result = getNavigationTree().localToScene( getNavigationTree().getWidth()/18
    				 + getNavigationTree().getScene().getWindow().getX() + getNavigationTree().getScene().getX()
	  																	 , getNavigationTree().getHeight()/18
				     + getNavigationTree().getScene().getWindow().getY() + getNavigationTree().getScene().getY() );
    	return result;    	
    }
	
	/* Menu and wizard section start */

	static boolean WithStaticOperations = false;


    interface MenuItemVisitor{
        ImageView handle(AddRightPRMTRServerPRMTRServiceSUBTYPENamePRMTRMenuItem menuItem);
        ImageView handle(FindServerPRMTRStringPRMTRMenuItem menuItem);
    }
    private abstract class UserManagerMenuItem extends MenuItem{
        private UserManagerMenuItem(){
            this.setGraphic(getIconForMenuItem(this));
        }
        abstract protected ImageView accept(MenuItemVisitor visitor);
    }
    private class AddRightPRMTRServerPRMTRServiceSUBTYPENamePRMTRMenuItem extends UserManagerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class FindServerPRMTRStringPRMTRMenuItem extends UserManagerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private java.util.Vector<javafx.scene.control.Button> getToolButtonsForStaticOperations() {
        java.util.Vector<javafx.scene.control.Button> result = new java.util.Vector<javafx.scene.control.Button>();
        javafx.scene.control.Button currentButton = null;
        currentButton = new javafx.scene.control.Button("findServer ... ");
        currentButton.setGraphic(new FindServerPRMTRStringPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final UserManagerFindServerStringMssgWizard wizard = new UserManagerFindServerStringMssgWizard("findServer");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        result.add(currentButton);
        return result;
    }
    private ContextMenu getContextMenu(final ViewRoot selected, final boolean withStaticOperations, final Point2D menuPos) {
        final ContextMenu result = new ContextMenu();
        MenuItem item = null;
        item = new FindServerPRMTRStringPRMTRMenuItem();
        item.setText("(S) findServer ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final UserManagerFindServerStringMssgWizard wizard = new UserManagerFindServerStringMssgWizard("findServer");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        if (selected != null){
            try {
                this.setPreCalculatedFilters(this.getConnection().userManager_Menu_Filter((Anything)selected));
            } catch (ModelException me){
                this.handleException(me);
                return result;
            }
            if (selected instanceof ServerView){
                item = new AddRightPRMTRServerPRMTRServiceSUBTYPENamePRMTRMenuItem();
                item.setText("addRight ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final UserManagerAddRightServerServiceSUBTYPENameMssgWizard wizard = new UserManagerAddRightServerServiceSUBTYPENameMssgWizard("addRight");
                        wizard.setFirstArgument((ServerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            
        }
        this.addNotGeneratedItems(result,selected);
        return result;
    }
    private String preCalculatedFilters = "";
    private String getPreCalculatedFilters() {
        return this.preCalculatedFilters;
    }
    private void setPreCalculatedFilters(String switchOff) {
        this.preCalculatedFilters = switchOff;
    }
    
	class UserManagerAddRightServerServiceSUBTYPENameMssgWizard extends Wizard {

		protected UserManagerAddRightServerServiceSUBTYPENameMssgWizard(String operationName){
			super(UserManagerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddRightPRMTRServerPRMTRServiceSUBTYPENamePRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "UserManagerAddRightServerServiceSUBTYPENameMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addRight(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(UserHasRightException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new RegExprSelectionPanel("type", this, common.RegularExpressionManager.serviceSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ServerView firstArgument; 
	
		public void setFirstArgument(ServerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class UserManagerFindServerStringMssgWizard extends Wizard {

		protected UserManagerFindServerStringMssgWizard(String operationName){
			super(UserManagerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new FindServerPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "UserManagerFindServerStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().findServer(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	/* Menu and wizard section end */
	
	private ImageView getIconForMenuItem(UserManagerMenuItem menuItem){
		return new ImageView(new javafx.scene.image.Image("/viewResources/default.gif")); //TODO Pimp-up your menu items!
	}	
	private void addNotGeneratedItems(ContextMenu result, ViewRoot selected) {
		// TODO Add items to menue if you have not generated service calls!!!
	}
	protected boolean getMultiSelectionFor(String parameterInBrowser){
		return false;
	}
	public int getPartsPerHour(String parameterInBrowser) {
		// divides 60 minutes into the returned number of parts
		return 59;
	}
	
}