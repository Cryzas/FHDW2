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


public class ServerClientView extends BorderPane implements ExceptionAndEventHandler{

	private ConnectionMaster 		 connection;
	private ExceptionAndEventHandler parent;	
	private ServerView 		 		 service;

	/**
	 * This is the default constructor
	 */
	public ServerClientView( ExceptionAndEventHandler parent, ServerView service) {
		super();
		this.parent = parent;
		this.service = service;
		this.initialize();
	}
	@SuppressWarnings("unused")
	private ServerView getService(){
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
		if (object == null && this.getConnection() != null) object = this.getConnection().getServerView();
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
	public ServerConnection getConnection(){
        	return (ServerConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		Platform.runLater(new Runnable() {
			public void run(){
				try {
					getNavigationTree().refreshTree();
					java.util.Vector<?> errors = getConnection().getServerView().getErrors();
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
				getNavigationTree().setModel((TreeModel) getConnection().getServerView());	
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
        ImageView handle(AddReceiverPRMTRDraftPRMTRAccountPRMTRMenuItem menuItem);
        ImageView handle(AnswerAllPRMTRMailEntryPRMTRStringPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(AnswerPRMTRMailEntryPRMTRStringPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(CreateAccountPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(CreateDraftPRMTRAccountPRMTRStringPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(CreateFolderPRMTRAccountPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(SendPRMTRDraftPRMTRMenuItem menuItem);
    }
    private abstract class ServerMenuItem extends MenuItem{
        private ServerMenuItem(){
            this.setGraphic(getIconForMenuItem(this));
        }
        abstract protected ImageView accept(MenuItemVisitor visitor);
    }
    private class AddReceiverPRMTRDraftPRMTRAccountPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AnswerAllPRMTRMailEntryPRMTRStringPRMTRStringPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AnswerPRMTRMailEntryPRMTRStringPRMTRStringPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateAccountPRMTRStringPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateDraftPRMTRAccountPRMTRStringPRMTRStringPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateFolderPRMTRAccountPRMTRStringPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class SendPRMTRDraftPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private java.util.Vector<javafx.scene.control.Button> getToolButtonsForStaticOperations() {
        java.util.Vector<javafx.scene.control.Button> result = new java.util.Vector<javafx.scene.control.Button>();
        javafx.scene.control.Button currentButton = null;
        currentButton = new javafx.scene.control.Button("createAccount ... ");
        currentButton.setGraphic(new CreateAccountPRMTRStringPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final ServerCreateAccountStringMssgWizard wizard = new ServerCreateAccountStringMssgWizard("createAccount");
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
        item = new CreateAccountPRMTRStringPRMTRMenuItem();
        item.setText("(S) createAccount ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final ServerCreateAccountStringMssgWizard wizard = new ServerCreateAccountStringMssgWizard("createAccount");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        if (selected != null){
            try {
                this.setPreCalculatedFilters(this.getConnection().server_Menu_Filter((Anything)selected));
            } catch (ModelException me){
                this.handleException(me);
                return result;
            }
            if (selected instanceof AccountView){
                item = new CreateDraftPRMTRAccountPRMTRStringPRMTRStringPRMTRMenuItem();
                item.setText("createDraft ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerCreateDraftAccountStringStringMssgWizard wizard = new ServerCreateDraftAccountStringStringMssgWizard("createDraft");
                        wizard.setFirstArgument((AccountView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new CreateFolderPRMTRAccountPRMTRStringPRMTRMenuItem();
                item.setText("createFolder ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerCreateFolderAccountStringMssgWizard wizard = new ServerCreateFolderAccountStringMssgWizard("createFolder");
                        wizard.setFirstArgument((AccountView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof DraftView){
                item = new AddReceiverPRMTRDraftPRMTRAccountPRMTRMenuItem();
                item.setText("addReceiver ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerAddReceiverDraftAccountMssgWizard wizard = new ServerAddReceiverDraftAccountMssgWizard("addReceiver");
                        wizard.setFirstArgument((DraftView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new SendPRMTRDraftPRMTRMenuItem();
                item.setText("send");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("send" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().send((DraftView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof MailEntryView){
                item = new AnswerAllPRMTRMailEntryPRMTRStringPRMTRStringPRMTRMenuItem();
                item.setText("answerAll ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerAnswerAllMailEntryStringStringMssgWizard wizard = new ServerAnswerAllMailEntryStringStringMssgWizard("answerAll");
                        wizard.setFirstArgument((MailEntryView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new AnswerPRMTRMailEntryPRMTRStringPRMTRStringPRMTRMenuItem();
                item.setText("answer ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerAnswerMailEntryStringStringMssgWizard wizard = new ServerAnswerMailEntryStringStringMssgWizard("answer");
                        wizard.setFirstArgument((MailEntryView)selected);
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
    
	class ServerAddReceiverDraftAccountMssgWizard extends Wizard {

		protected ServerAddReceiverDraftAccountMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddReceiverPRMTRDraftPRMTRAccountPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerAddReceiverDraftAccountMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addReceiver(firstArgument, (AccountView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			final ObjectSelectionPanel panel1 = new ObjectSelectionPanel("account", "view.AccountView", null, this);
			getParametersPanel().getChildren().add(panel1);
			panel1.setBrowserRoot((ViewRoot) getConnection().getServerView());		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private DraftView firstArgument; 
	
		public void setFirstArgument(DraftView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerAnswerAllMailEntryStringStringMssgWizard extends Wizard {

		protected ServerAnswerAllMailEntryStringStringMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AnswerAllPRMTRMailEntryPRMTRStringPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerAnswerAllMailEntryStringStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().answerAll(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("subject", this));
			getParametersPanel().getChildren().add(new StringSelectionPanel("text", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MailEntryView firstArgument; 
	
		public void setFirstArgument(MailEntryView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getSubject());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			try{
				final SelectionPanel selectionPanel1 = (SelectionPanel)getParametersPanel().getChildren().get(1);
				selectionPanel1.preset(firstArgument.getText());
				if (!selectionPanel1.check()) selectionPanel1.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerAnswerMailEntryStringStringMssgWizard extends Wizard {

		protected ServerAnswerMailEntryStringStringMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AnswerPRMTRMailEntryPRMTRStringPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerAnswerMailEntryStringStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().answer(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("subject", this));
			getParametersPanel().getChildren().add(new StringSelectionPanel("text", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MailEntryView firstArgument; 
	
		public void setFirstArgument(MailEntryView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getSubject());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			try{
				final SelectionPanel selectionPanel1 = (SelectionPanel)getParametersPanel().getChildren().get(1);
				selectionPanel1.preset(firstArgument.getText());
				if (!selectionPanel1.check()) selectionPanel1.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerCreateAccountStringMssgWizard extends Wizard {

		protected ServerCreateAccountStringMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateAccountPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateAccountStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createAccount(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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

	class ServerCreateDraftAccountStringStringMssgWizard extends Wizard {

		protected ServerCreateDraftAccountStringStringMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateDraftPRMTRAccountPRMTRStringPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateDraftAccountStringStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createDraft(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("subject", this));
			getParametersPanel().getChildren().add(new StringSelectionPanel("text", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AccountView firstArgument; 
	
		public void setFirstArgument(AccountView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateFolderAccountStringMssgWizard extends Wizard {

		protected ServerCreateFolderAccountStringMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateFolderPRMTRAccountPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateFolderAccountStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createFolder(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
		
		
		private AccountView firstArgument; 
	
		public void setFirstArgument(AccountView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getName());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	/* Menu and wizard section end */
	
	private ImageView getIconForMenuItem(ServerMenuItem menuItem){
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