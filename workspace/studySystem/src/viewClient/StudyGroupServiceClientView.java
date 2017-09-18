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


public class StudyGroupServiceClientView extends BorderPane implements ExceptionAndEventHandler{

	private ConnectionMaster 		 connection;
	private ExceptionAndEventHandler parent;	
	private StudyGroupServiceView 		 		 service;

	/**
	 * This is the default constructor
	 */
	public StudyGroupServiceClientView( ExceptionAndEventHandler parent, StudyGroupServiceView service) {
		super();
		this.parent = parent;
		this.service = service;
		this.initialize();
	}
	@SuppressWarnings("unused")
	private StudyGroupServiceView getService(){
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
			this.mainSplitPane.getItems().addAll( this.getNavigationSplitPane());	
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
		if (object == null && this.getConnection() != null) object = this.getConnection().getStudyGroupServiceView();
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
	public StudyGroupServiceConnection getConnection(){
        	return (StudyGroupServiceConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		Platform.runLater(new Runnable() {
			public void run(){
				try {
					getNavigationTree().refreshTree();
					java.util.Vector<?> errors = getConnection().getStudyGroupServiceView().getErrors();
					if (errors.size() >0 )setErrors( new ListRoot(errors));
					else setNoErrors();
				} catch (ModelException e) {
					handleException(e);
				}			
			}
		});
	}
	/** Is called only once after the connection has been established
	**/
	public void initializeConnection(){
		Platform.runLater( new  Runnable() {
			public void run() {
				getNavigationTree().setModel((TreeModel) getConnection().getStudyGroupServiceView());	
				getNavigationTree().getRoot().setExpanded(true);
				getNavigationTree().getSelectionModel().select( getNavigationTree().getRoot());
			}
		});
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
        ImageView handle(UpdateMePRMTRMenuItem menuItem);
        ImageView handle(SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(RemoveErrorPRMTRErrorDisplayPRMTRMenuItem menuItem);
        ImageView handle(CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem menuItem);
        ImageView handle(RemoveStudentFromGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem menuItem);
        ImageView handle(AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem menuItem);
        ImageView handle(EndStudyGroupPRMTRStudyGroupPRMTRMenuItem menuItem);
        ImageView handle(DeleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRMenuItem menuItem);
    }
    private abstract class StudyGroupServiceMenuItem extends MenuItem{
        private StudyGroupServiceMenuItem(){
            this.setGraphic(getIconForMenuItem(this));
        }
        abstract protected ImageView accept(MenuItemVisitor visitor);
    }
    private class UpdateMePRMTRMenuItem extends StudyGroupServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem extends StudyGroupServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveErrorPRMTRErrorDisplayPRMTRMenuItem extends StudyGroupServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem extends StudyGroupServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveStudentFromGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem extends StudyGroupServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem extends StudyGroupServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class EndStudyGroupPRMTRStudyGroupPRMTRMenuItem extends StudyGroupServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class DeleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRMenuItem extends StudyGroupServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private java.util.Vector<javafx.scene.control.Button> getToolButtonsForStaticOperations() {
        java.util.Vector<javafx.scene.control.Button> result = new java.util.Vector<javafx.scene.control.Button>();
        javafx.scene.control.Button currentButton = null;
        currentButton = new javafx.scene.control.Button("Aktualisieren");
        currentButton.setGraphic(new UpdateMePRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                Alert confirm = new Alert(AlertType.CONFIRMATION);
                confirm.setTitle(GUIConstants.ConfirmButtonText);
                confirm.setHeaderText(null);
                confirm.setContentText("Aktualisieren" + GUIConstants.ConfirmQuestionMark);
                confirm.setX( getPointForView().getX() );
                confirm.setY( getPointForView().getY() );
                Optional<ButtonType> buttonResult = confirm.showAndWait();
                if (buttonResult.get() == ButtonType.OK) {
                    try {
                        getConnection().updateMe();
                        getConnection().setEagerRefresh();
                        
                    }catch(ModelException me){
                        handleException(me);
                    }
                }
            }
        });
        result.add(currentButton);
        return result;
    }
    private ContextMenu getContextMenu(final ViewRoot selected, final boolean withStaticOperations, final Point2D menuPos) {
        final ContextMenu result = new ContextMenu();
        MenuItem item = null;
        item = new UpdateMePRMTRMenuItem();
        item.setText("(S) Aktualisieren");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                Alert confirm = new Alert(AlertType.CONFIRMATION);
                confirm.setTitle(GUIConstants.ConfirmButtonText);
                confirm.setHeaderText(null);
                confirm.setContentText("Aktualisieren" + GUIConstants.ConfirmQuestionMark);
                confirm.setX( getPointForView().getX() );
                confirm.setY( getPointForView().getY() );
                Optional<ButtonType> buttonResult = confirm.showAndWait();
                if (buttonResult.get() == ButtonType.OK) {
                    try {
                        getConnection().updateMe();
                        getConnection().setEagerRefresh();
                        
                    }catch(ModelException me){
                        handleException(me);
                    }
                }
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        if (selected != null){
            try {
                this.setPreCalculatedFilters(this.getConnection().studyGroupService_Menu_Filter((Anything)selected));
            } catch (ModelException me){
                this.handleException(me);
                return result;
            }
            if (selected instanceof StudyGroupManagerView){
                item = new DeleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRMenuItem();
                item.setText("Studiengruppen löschen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final StudyGroupServiceDeleteStudyGroupsStudyGroupManagerStudyGroupLSTMssgWizard wizard = new StudyGroupServiceDeleteStudyGroupsStudyGroupManagerStudyGroupLSTMssgWizard("Studiengruppen löschen");
                        wizard.setFirstArgument((StudyGroupManagerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof StudyGroupView){
                item = new CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem();
                item.setText("Student erstellen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final StudyGroupServiceCreateStudentStudyGroupStringStringDateMssgWizard wizard = new StudyGroupServiceCreateStudentStudyGroupStringStringDateMssgWizard("Student erstellen");
                        wizard.setFirstArgument((StudyGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new RemoveStudentFromGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem();
                item.setText("Studenten entfernen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final StudyGroupServiceRemoveStudentFromGroupStudyGroupStudentLSTMssgWizard wizard = new StudyGroupServiceRemoveStudentFromGroupStudyGroupStudentLSTMssgWizard("Studenten entfernen");
                        wizard.setFirstArgument((StudyGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem();
                item.setText("Studenten hinzufügen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final StudyGroupServiceAddStudentToGroupStudyGroupStudentLSTMssgWizard wizard = new StudyGroupServiceAddStudentToGroupStudyGroupStudentLSTMssgWizard("Studenten hinzufügen");
                        wizard.setFirstArgument((StudyGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new EndStudyGroupPRMTRStudyGroupPRMTRMenuItem();
                item.setText("Studiengruppe abschließen");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("Studiengruppe abschließen" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().endStudyGroup((StudyGroupView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ErrorDisplayView){
                item = new RemoveErrorPRMTRErrorDisplayPRMTRMenuItem();
                item.setText("Error entfernen");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("Error entfernen" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().removeError((ErrorDisplayView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ModuleWithUnitsSGroupView){
                item = new SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem();
                item.setText("CP Gewichtung ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final StudyGroupServiceSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard wizard = new StudyGroupServiceSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard("CP Gewichtung ändern");
                        wizard.setFirstArgument((ModuleWithUnitsSGroupView)selected);
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
    
	class StudyGroupServiceAddStudentToGroupStudyGroupStudentLSTMssgWizard extends Wizard {

		protected StudyGroupServiceAddStudentToGroupStudyGroupStudentLSTMssgWizard(String operationName){
			super(StudyGroupServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "StudyGroupServiceAddStudentToGroupStudyGroupStudentLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addStudentToGroup(firstArgument, (java.util.Vector<StudentView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			try{
				final ObjectCollectionSelectionPanel panel1 = new ObjectCollectionSelectionPanel("Studenten", "view.StudentView", null, this, getMultiSelectionFor("addStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRstudents"));
				getParametersPanel().getChildren().add(panel1);
				panel1.setBrowserRoot(new ListRoot(getConnection().students_Path_In_AddStudentToGroup()));
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private StudyGroupView firstArgument; 
	
		public void setFirstArgument(StudyGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset((java.util.Vector<?>)firstArgument.getStudents());
				if (!selectionPanel0.check()) selectionPanel0.preset(new java.util.Vector<Object>());
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class StudyGroupServiceCreateStudentStudyGroupStringStringDateMssgWizard extends Wizard {

		protected StudyGroupServiceCreateStudentStudyGroupStringStringDateMssgWizard(String operationName){
			super(StudyGroupServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "StudyGroupServiceCreateStudentStudyGroupStringStringDateMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createStudent(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(1)).getResult(),
									((DateSelectionPanel)getParametersPanel().getChildren().get(2)).getResult());
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("Vorname", this));
			getParametersPanel().getChildren().add(new StringSelectionPanel("Nachname", this));
			getParametersPanel().getChildren().add(new DateSelectionPanel("Geburtsdatum", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private StudyGroupView firstArgument; 
	
		public void setFirstArgument(StudyGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class StudyGroupServiceDeleteStudyGroupsStudyGroupManagerStudyGroupLSTMssgWizard extends Wizard {

		protected StudyGroupServiceDeleteStudyGroupsStudyGroupManagerStudyGroupLSTMssgWizard(String operationName){
			super(StudyGroupServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new DeleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "StudyGroupServiceDeleteStudyGroupsStudyGroupManagerStudyGroupLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().deleteStudyGroups(firstArgument, (java.util.Vector<StudyGroupView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			final ObjectCollectionSelectionPanel panel2 = new ObjectCollectionSelectionPanel("Studiengruppen", "view.StudyGroupView", null, this, getMultiSelectionFor("deleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRgroups"))
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().groups_Path_In_DeleteStudyGroups((StudyGroupManagerView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel2);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private StudyGroupManagerView firstArgument; 
	
		public void setFirstArgument(StudyGroupManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset((java.util.Vector<?>)firstArgument.getGroups());
				if (!selectionPanel0.check()) selectionPanel0.preset(new java.util.Vector<Object>());
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class StudyGroupServiceRemoveStudentFromGroupStudyGroupStudentLSTMssgWizard extends Wizard {

		protected StudyGroupServiceRemoveStudentFromGroupStudyGroupStudentLSTMssgWizard(String operationName){
			super(StudyGroupServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new RemoveStudentFromGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "StudyGroupServiceRemoveStudentFromGroupStudyGroupStudentLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().removeStudentFromGroup(firstArgument, (java.util.Vector<StudentView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			final ObjectCollectionSelectionPanel panel3 = new ObjectCollectionSelectionPanel("Studenten", "view.StudentView", null, this, getMultiSelectionFor("removeStudentFromGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRstudents"))
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().students_Path_In_RemoveStudentFromGroup((StudyGroupView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel3);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private StudyGroupView firstArgument; 
	
		public void setFirstArgument(StudyGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset((java.util.Vector<?>)firstArgument.getStudents());
				if (!selectionPanel0.check()) selectionPanel0.preset(new java.util.Vector<Object>());
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class StudyGroupServiceSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard extends Wizard {

		protected StudyGroupServiceSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard(String operationName){
			super(StudyGroupServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "StudyGroupServiceSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().swapCPonModuleWithUnits(firstArgument, (UnitSGroupView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									(UnitSGroupView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(1)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(2)).getResult());
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
			final ObjectSelectionPanel panel4 = new ObjectSelectionPanel("Von Unit", "view.UnitSGroupView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().fromUnit_Path_In_SwapCPonModuleWithUnits((ModuleWithUnitsSGroupView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel4);
			final ObjectSelectionPanel panel5 = new ObjectSelectionPanel("Zu Unit", "view.UnitSGroupView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().ToUnit_Path_In_SwapCPonModuleWithUnits((ModuleWithUnitsSGroupView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel5);
			getParametersPanel().getChildren().add(new FractionSelectionPanel("Credit Points", this));		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
			if(i == 1){
				((ObjectSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private ModuleWithUnitsSGroupView firstArgument; 
	
		public void setFirstArgument(ModuleWithUnitsSGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel2 = (SelectionPanel)getParametersPanel().getChildren().get(2);
				selectionPanel2.preset(firstArgument.getCreditPoints());
				if (!selectionPanel2.check()) selectionPanel2.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	/* Menu and wizard section end */
	
	private ImageView getIconForMenuItem(StudyGroupServiceMenuItem menuItem){
		return menuItem.accept(new MenuItemVisitor() {
			
			@Override
			public ImageView handle(DeleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(8));
			}
			
			@Override
			public ImageView handle(EndStudyGroupPRMTRStudyGroupPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(18));
			}
			
			@Override
			public ImageView handle(AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(9));
			}
			
			@Override
			public ImageView handle(RemoveStudentFromGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(10));
			}
			
			@Override
			public ImageView handle(CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(9));
			}
			
			@Override
			public ImageView handle(RemoveErrorPRMTRErrorDisplayPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(8));
			}
			
			@Override
			public ImageView handle(
					SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(11));
			}
			
			@Override
			public ImageView handle(UpdateMePRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(16));
			}
		});
	}	
	private void addNotGeneratedItems(ContextMenu result, ViewRoot selected) {
	}
	protected boolean getMultiSelectionFor(String parameterInBrowser){
		return false;
	}
	public int getPartsPerHour(String parameterInBrowser) {
		// divides 60 minutes into the returned number of parts
		return 59;
	}
	
}