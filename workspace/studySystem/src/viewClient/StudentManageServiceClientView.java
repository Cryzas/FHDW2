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


public class StudentManageServiceClientView extends BorderPane implements ExceptionAndEventHandler{

	private ConnectionMaster 		 connection;
	private ExceptionAndEventHandler parent;	
	private StudentManageServiceView 		 		 service;

	/**
	 * This is the default constructor
	 */
	public StudentManageServiceClientView( ExceptionAndEventHandler parent, StudentManageServiceView service) {
		super();
		this.parent = parent;
		this.service = service;
		this.initialize();
	}
	@SuppressWarnings("unused")
	private StudentManageServiceView getService(){
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
	private TreeRefresh treePanel = null;
	private TreeRefresh getNavigationPanel() {
		if( this.treePanel == null) {
			this.treePanel = this.getNavigationTree();
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
		if (object == null && this.getConnection() != null) object = this.getConnection().getStudentManageServiceView();
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
	public StudentManageServiceConnection getConnection(){
        	return (StudentManageServiceConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		Platform.runLater(new Runnable() {
			public void run(){
				try {
					getNavigationTree().refreshTree();
					java.util.Vector<?> errors = getConnection().getStudentManageServiceView().getErrors();
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
				getNavigationTree().setModel((TreeModel) getConnection().getStudentManageServiceView());	
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
        ImageView handle(RemoveErrorPRMTRErrorDisplayPRMTRMenuItem menuItem);
        ImageView handle(ChangeGradeforStudentPRMTRStudentPRMTRLectureWithGradePRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(DeleteStudentsPRMTRStudentLSTPRMTRMenuItem menuItem);
    }
    private abstract class StudentManageServiceMenuItem extends MenuItem{
        private StudentManageServiceMenuItem(){
            this.setGraphic(getIconForMenuItem(this));
        }
        abstract protected ImageView accept(MenuItemVisitor visitor);
    }
    private class UpdateMePRMTRMenuItem extends StudentManageServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveErrorPRMTRErrorDisplayPRMTRMenuItem extends StudentManageServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeGradeforStudentPRMTRStudentPRMTRLectureWithGradePRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem extends StudentManageServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem extends StudentManageServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRStringPRMTRMenuItem extends StudentManageServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class DeleteStudentsPRMTRStudentLSTPRMTRMenuItem extends StudentManageServiceMenuItem{
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
        currentButton = new javafx.scene.control.Button("Studenten löschen ... ");
        currentButton.setGraphic(new DeleteStudentsPRMTRStudentLSTPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final StudentManageServiceDeleteStudentsStudentLSTMssgWizard wizard = new StudentManageServiceDeleteStudentsStudentLSTMssgWizard("Studenten löschen");
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
        item = new DeleteStudentsPRMTRStudentLSTPRMTRMenuItem();
        item.setText("(S) Studenten löschen ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final StudentManageServiceDeleteStudentsStudentLSTMssgWizard wizard = new StudentManageServiceDeleteStudentsStudentLSTMssgWizard("Studenten löschen");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        if (selected != null){
            try {
                this.setPreCalculatedFilters(this.getConnection().studentManageService_Menu_Filter((Anything)selected));
            } catch (ModelException me){
                this.handleException(me);
                return result;
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
            if (selected instanceof ModuleAtomarStudentView){
                item = new ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem();
                item.setText("Note ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final StudentManageServiceChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameStringMssgWizard wizard = new StudentManageServiceChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameStringMssgWizard("Note ändern");
                        wizard.setFirstArgument((ModuleAtomarStudentView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof UnitStudentView){
                item = new ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRStringPRMTRMenuItem();
                item.setText("Note ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final StudentManageServiceChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameStringMssgWizard wizard = new StudentManageServiceChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameStringMssgWizard("Note ändern");
                        wizard.setFirstArgument((UnitStudentView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof StudentView){
                item = new ChangeGradeforStudentPRMTRStudentPRMTRLectureWithGradePRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem();
                item.setText("Note eintragen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final StudentManageServiceChangeGradeforStudentStudentLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssgWizard wizard = new StudentManageServiceChangeGradeforStudentStudentLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssgWizard("Note eintragen");
                        wizard.setFirstArgument((StudentView)selected);
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
    @SuppressWarnings("unused")
	private String getPreCalculatedFilters() {
        return this.preCalculatedFilters;
    }
    private void setPreCalculatedFilters(String switchOff) {
        this.preCalculatedFilters = switchOff;
    }
    
	class StudentManageServiceChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameStringMssgWizard extends Wizard {

		protected StudentManageServiceChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameStringMssgWizard(String operationName){
			super(StudentManageServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "StudentManageServiceChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().changeGradeOfModule(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
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
			getParametersPanel().getChildren().add(new RegExprSelectionPanel("Note", this, common.RegularExpressionManager.gradesInSimpleOrThirdSUBTYPEName.getRegExpr()));
			getParametersPanel().getChildren().add(new StringSelectionPanel("Kommentar", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ModuleAtomarStudentView firstArgument; 
	
		public void setFirstArgument(ModuleAtomarStudentView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.getIcons().add(IconManager.getImage(11));
			this.check();
		}
		
		
	}

	class StudentManageServiceChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameStringMssgWizard extends Wizard {

		protected StudentManageServiceChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameStringMssgWizard(String operationName){
			super(StudentManageServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "StudentManageServiceChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().changeGradeOfUnit(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
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
			getParametersPanel().getChildren().add(new RegExprSelectionPanel("Note", this, common.RegularExpressionManager.gradesInThirdSUBTYPEName.getRegExpr()));
			getParametersPanel().getChildren().add(new StringSelectionPanel("Kommentar", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private UnitStudentView firstArgument; 
	
		public void setFirstArgument(UnitStudentView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.getIcons().add(IconManager.getImage(11));
			this.check();
		}
		
		
	}

	class StudentManageServiceChangeGradeforStudentStudentLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssgWizard extends Wizard {

		protected StudentManageServiceChangeGradeforStudentStudentLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssgWizard(String operationName){
			super(StudentManageServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeGradeforStudentPRMTRStudentPRMTRLectureWithGradePRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "StudentManageServiceChangeGradeforStudentStudentLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().changeGradeforStudent(firstArgument, (LectureWithGrade)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(1)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(2)).getResult());
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
			final ObjectSelectionPanel panel1 = new ObjectSelectionPanel("Vorlesung", "view.LectureWithGrade", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().lecture_Path_In_ChangeGradeforStudent((StudentView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel1);
			getParametersPanel().getChildren().add(new RegExprSelectionPanel("Grade", this, common.RegularExpressionManager.gradesInSimpleOrThirdSUBTYPEName.getRegExpr()));
			getParametersPanel().getChildren().add(new StringSelectionPanel("Kommentar", this));		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private StudentView firstArgument; 
	
		public void setFirstArgument(StudentView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.getIcons().add(IconManager.getImage(11));
			this.check();
		}
		
		
	}

	class StudentManageServiceDeleteStudentsStudentLSTMssgWizard extends Wizard {

		protected StudentManageServiceDeleteStudentsStudentLSTMssgWizard(String operationName){
			super(StudentManageServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new DeleteStudentsPRMTRStudentLSTPRMTRMenuItem ().getGraphic());
			this.getIcons().add(IconManager.getImage(8));
			this.setTitle(operationName);
		}
		protected void initialize(){
			this.helpFileName = "StudentManageServiceDeleteStudentsStudentLSTMssgWizard.help";
			super.initialize();		
		}
				
		@SuppressWarnings("unchecked")
		protected void perform() {
			try {
				getConnection().deleteStudents((java.util.Vector<StudentView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
				final ObjectCollectionSelectionPanel panel2 = new ObjectCollectionSelectionPanel("Studenten", "view.StudentView", null, this, getMultiSelectionFor("deleteStudentsPRMTRStudentLSTPRMTRstudents"));
				getParametersPanel().getChildren().add(panel2);
				panel2.setBrowserRoot(new ListRoot(getConnection().students_Path_In_DeleteStudents()));
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
		
		
	}

	/* Menu and wizard section end */
	
	private ImageView getIconForMenuItem(StudentManageServiceMenuItem menuItem){
		return menuItem.accept(new MenuItemVisitor() {
			
			@Override
			public ImageView handle(
					ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRStringPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(11));
			}
			
			@Override
			public ImageView handle(
					ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(11));
			}
			
			@Override
			public ImageView handle(
					ChangeGradeforStudentPRMTRStudentPRMTRLectureWithGradePRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(11));
			}
			
			@Override
			public ImageView handle(RemoveErrorPRMTRErrorDisplayPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(8));
			}
			
			@Override
			public ImageView handle(UpdateMePRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(16));
			}

			@Override
			public ImageView handle(DeleteStudentsPRMTRStudentLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(8));
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