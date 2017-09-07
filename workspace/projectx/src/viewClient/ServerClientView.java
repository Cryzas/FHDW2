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


@SuppressWarnings("unused")
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
        ImageView handle(SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(ChangeCPOnModulePRMTRModuleAtomarPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(ChangeCPOnUnitPRMTRUnitPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(RemoveErrorPRMTRErrorDisplayPRMTRMenuItem menuItem);
        ImageView handle(CreateModulePRMTRModuleAbstractSUBTYPENamePRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(AddModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem menuItem);
        ImageView handle(AddModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem menuItem);
        ImageView handle(ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRMenuItem menuItem);
        ImageView handle(ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRMenuItem menuItem);
        ImageView handle(ChangeGradeSystemPRMTRModuleAtomarPRMTRMenuItem menuItem);
        ImageView handle(CreateProgramPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem menuItem);
        ImageView handle(AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem menuItem);
        ImageView handle(StartStudyGroupPRMTRProgramPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(AddUnitPRMTRModuleWithUnitsPRMTRStringPRMTRFractionPRMTRMenuItem menuItem);
    }
    private abstract class ServerMenuItem extends MenuItem{
        private ServerMenuItem(){
            this.setGraphic(getIconForMenuItem(this));
        }
        abstract protected ImageView accept(MenuItemVisitor visitor);
    }
    private class SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeCPOnModulePRMTRModuleAtomarPRMTRFractionPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeCPOnUnitPRMTRUnitPRMTRFractionPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveErrorPRMTRErrorDisplayPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateModulePRMTRModuleAbstractSUBTYPENamePRMTRStringPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeGradeSystemPRMTRModuleAtomarPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateProgramPRMTRStringPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class StartStudyGroupPRMTRProgramPRMTRStringPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddUnitPRMTRModuleWithUnitsPRMTRStringPRMTRFractionPRMTRMenuItem extends ServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private java.util.Vector<javafx.scene.control.Button> getToolButtonsForStaticOperations() {
        java.util.Vector<javafx.scene.control.Button> result = new java.util.Vector<javafx.scene.control.Button>();
        javafx.scene.control.Button currentButton = null;
        currentButton = new javafx.scene.control.Button("Modul erstellen ... ");
        currentButton.setGraphic(new CreateModulePRMTRModuleAbstractSUBTYPENamePRMTRStringPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final ServerCreateModuleModuleAbstractSUBTYPENameStringMssgWizard wizard = new ServerCreateModuleModuleAbstractSUBTYPENameStringMssgWizard("Modul erstellen");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        result.add(currentButton);
        currentButton = new javafx.scene.control.Button("Programm erstellen ... ");
        currentButton.setGraphic(new CreateProgramPRMTRStringPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final ServerCreateProgramStringMssgWizard wizard = new ServerCreateProgramStringMssgWizard("Programm erstellen");
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
        item = new CreateModulePRMTRModuleAbstractSUBTYPENamePRMTRStringPRMTRMenuItem();
        item.setText("(S) Modul erstellen ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final ServerCreateModuleModuleAbstractSUBTYPENameStringMssgWizard wizard = new ServerCreateModuleModuleAbstractSUBTYPENameStringMssgWizard("Modul erstellen");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        item = new CreateProgramPRMTRStringPRMTRMenuItem();
        item.setText("(S) Programm erstellen ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final ServerCreateProgramStringMssgWizard wizard = new ServerCreateProgramStringMssgWizard("Programm erstellen");
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
            if (selected instanceof ProgramView){
                item = new AddModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem();
                item.setText("Module hinzufügen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerAddModuleToProgProgramModuleAbstractLSTMssgWizard wizard = new ServerAddModuleToProgProgramModuleAbstractLSTMssgWizard("Module hinzufügen");
                        wizard.setFirstArgument((ProgramView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new StartStudyGroupPRMTRProgramPRMTRStringPRMTRMenuItem();
                item.setText("Studiengruppe eröffnen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerStartStudyGroupProgramStringMssgWizard wizard = new ServerStartStudyGroupProgramStringMssgWizard("Studiengruppe eröffnen");
                        wizard.setFirstArgument((ProgramView)selected);
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
                        final ServerCreateStudentStudyGroupStringStringDateMssgWizard wizard = new ServerCreateStudentStudyGroupStringStringDateMssgWizard("Student erstellen");
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
                        final ServerAddStudentToGroupStudyGroupStudentLSTMssgWizard wizard = new ServerAddStudentToGroupStudyGroupStudentLSTMssgWizard("Studenten hinzufügen");
                        wizard.setFirstArgument((StudyGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
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
            if (selected instanceof ModuleAtomarStudentView){
                item = new ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRMenuItem();
                item.setText("Note ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameMssgWizard wizard = new ServerChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameMssgWizard("Note ändern");
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
                item = new ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRMenuItem();
                item.setText("Note ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameMssgWizard wizard = new ServerChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameMssgWizard("Note ändern");
                        wizard.setFirstArgument((UnitStudentView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ModuleAtomarView){
                item = new ChangeCPOnModulePRMTRModuleAtomarPRMTRFractionPRMTRMenuItem();
                item.setText("CP ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerChangeCPOnModuleModuleAtomarFractionMssgWizard wizard = new ServerChangeCPOnModuleModuleAtomarFractionMssgWizard("CP ändern");
                        wizard.setFirstArgument((ModuleAtomarView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new ChangeGradeSystemPRMTRModuleAtomarPRMTRMenuItem();
                item.setText("Notensystem ändern");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("Notensystem ändern" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().changeGradeSystem((ModuleAtomarView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ModuleWithUnitsView){
                item = new AddUnitPRMTRModuleWithUnitsPRMTRStringPRMTRFractionPRMTRMenuItem();
                item.setText("Unit hinzufügen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerAddUnitModuleWithUnitsStringFractionMssgWizard wizard = new ServerAddUnitModuleWithUnitsStringFractionMssgWizard("Unit hinzufügen");
                        wizard.setFirstArgument((ModuleWithUnitsView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof UnitView){
                item = new ChangeCPOnUnitPRMTRUnitPRMTRFractionPRMTRMenuItem();
                item.setText("CP ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerChangeCPOnUnitUnitFractionMssgWizard wizard = new ServerChangeCPOnUnitUnitFractionMssgWizard("CP ändern");
                        wizard.setFirstArgument((UnitView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ModuleGroupView){
                item = new AddModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem();
                item.setText("Module hinzufügen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerAddModuleToGroupModuleGroupModuleAbstractLSTMssgWizard wizard = new ServerAddModuleToGroupModuleGroupModuleAbstractLSTMssgWizard("Module hinzufügen");
                        wizard.setFirstArgument((ModuleGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ModuleWithUnitsSGroupView){
                item = new SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem();
                item.setText("CP der Units ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final ServerSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard wizard = new ServerSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard("CP der Units ändern");
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
    
	class ServerAddModuleToGroupModuleGroupModuleAbstractLSTMssgWizard extends Wizard {

		protected ServerAddModuleToGroupModuleGroupModuleAbstractLSTMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerAddModuleToGroupModuleGroupModuleAbstractLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addModuleToGroup(firstArgument, (java.util.Vector<ModuleAbstractView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
				final ObjectCollectionSelectionPanel panel1 = new ObjectCollectionSelectionPanel("modules", "view.ModuleAbstractView", null, this, getMultiSelectionFor("addModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRmodules"));
				getParametersPanel().getChildren().add(panel1);
				panel1.setBrowserRoot(new ListRoot(getConnection().modules_Path_In_AddModuleToGroup()));
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
		
		
		private ModuleGroupView firstArgument; 
	
		public void setFirstArgument(ModuleGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset((java.util.Vector<?>)firstArgument.getModules());
				if (!selectionPanel0.check()) selectionPanel0.preset(new java.util.Vector<Object>());
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerAddModuleToProgProgramModuleAbstractLSTMssgWizard extends Wizard {

		protected ServerAddModuleToProgProgramModuleAbstractLSTMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerAddModuleToProgProgramModuleAbstractLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addModuleToProg(firstArgument, (java.util.Vector<ModuleAbstractView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
				final ObjectCollectionSelectionPanel panel2 = new ObjectCollectionSelectionPanel("modules", "view.ModuleAbstractView", null, this, getMultiSelectionFor("addModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRmodules"));
				getParametersPanel().getChildren().add(panel2);
				panel2.setBrowserRoot(new ListRoot(getConnection().modules_Path_In_AddModuleToProg()));
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
		
		
		private ProgramView firstArgument; 
	
		public void setFirstArgument(ProgramView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset((java.util.Vector<?>)firstArgument.getModules());
				if (!selectionPanel0.check()) selectionPanel0.preset(new java.util.Vector<Object>());
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerAddStudentToGroupStudyGroupStudentLSTMssgWizard extends Wizard {

		protected ServerAddStudentToGroupStudyGroupStudentLSTMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerAddStudentToGroupStudyGroupStudentLSTMssgWizard.help";
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
				final ObjectCollectionSelectionPanel panel3 = new ObjectCollectionSelectionPanel("students", "view.StudentView", null, this, getMultiSelectionFor("addStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRstudents"));
				getParametersPanel().getChildren().add(panel3);
				panel3.setBrowserRoot(new ListRoot(getConnection().students_Path_In_AddStudentToGroup()));
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

	class ServerAddUnitModuleWithUnitsStringFractionMssgWizard extends Wizard {

		protected ServerAddUnitModuleWithUnitsStringFractionMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddUnitPRMTRModuleWithUnitsPRMTRStringPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerAddUnitModuleWithUnitsStringFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addUnit(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
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
			getParametersPanel().getChildren().add(new FractionSelectionPanel("creditPoints", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ModuleWithUnitsView firstArgument; 
	
		public void setFirstArgument(ModuleWithUnitsView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getName());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			try{
				final SelectionPanel selectionPanel1 = (SelectionPanel)getParametersPanel().getChildren().get(1);
				selectionPanel1.preset(firstArgument.getCreditPoints());
				if (!selectionPanel1.check()) selectionPanel1.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerChangeCPOnModuleModuleAtomarFractionMssgWizard extends Wizard {

		protected ServerChangeCPOnModuleModuleAtomarFractionMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeCPOnModulePRMTRModuleAtomarPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerChangeCPOnModuleModuleAtomarFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().changeCPOnModule(firstArgument, ((FractionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			getParametersPanel().getChildren().add(new FractionSelectionPanel("creditPoints", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ModuleAtomarView firstArgument; 
	
		public void setFirstArgument(ModuleAtomarView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getCreditPoints());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerChangeCPOnUnitUnitFractionMssgWizard extends Wizard {

		protected ServerChangeCPOnUnitUnitFractionMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeCPOnUnitPRMTRUnitPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerChangeCPOnUnitUnitFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().changeCPOnUnit(firstArgument, ((FractionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			getParametersPanel().getChildren().add(new FractionSelectionPanel("creditPoints", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private UnitView firstArgument; 
	
		public void setFirstArgument(UnitView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getCreditPoints());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameMssgWizard extends Wizard {

		protected ServerChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().changeGradeOfModule(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			getParametersPanel().getChildren().add(new RegExprSelectionPanel("grade", this, common.RegularExpressionManager.gradesInSimpleOrThirdSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ModuleAtomarStudentView firstArgument; 
	
		public void setFirstArgument(ModuleAtomarStudentView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameMssgWizard extends Wizard {

		protected ServerChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().changeGradeOfUnit(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			getParametersPanel().getChildren().add(new RegExprSelectionPanel("grade", this, common.RegularExpressionManager.gradesInThirdSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private UnitStudentView firstArgument; 
	
		public void setFirstArgument(UnitStudentView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateModuleModuleAbstractSUBTYPENameStringMssgWizard extends Wizard {

		protected ServerCreateModuleModuleAbstractSUBTYPENameStringMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateModulePRMTRModuleAbstractSUBTYPENamePRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateModuleModuleAbstractSUBTYPENameStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createModule(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
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
			getParametersPanel().getChildren().add(new RegExprSelectionPanel("type", this, common.RegularExpressionManager.moduleAbstractSUBTYPEName.getRegExpr()));
			getParametersPanel().getChildren().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class ServerCreateProgramStringMssgWizard extends Wizard {

		protected ServerCreateProgramStringMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateProgramPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateProgramStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createProgram(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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

	class ServerCreateStudentStudyGroupStringStringDateMssgWizard extends Wizard {

		protected ServerCreateStudentStudyGroupStringStringDateMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateStudentStudyGroupStringStringDateMssgWizard.help";
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("firstName", this));
			getParametersPanel().getChildren().add(new StringSelectionPanel("lastName", this));
			getParametersPanel().getChildren().add(new DateSelectionPanel("birthDate", this));		
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

	class ServerStartStudyGroupProgramStringMssgWizard extends Wizard {

		protected ServerStartStudyGroupProgramStringMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new StartStudyGroupPRMTRProgramPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerStartStudyGroupProgramStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().startStudyGroup(firstArgument, ((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
		
		
		private ProgramView firstArgument; 
	
		public void setFirstArgument(ProgramView firstArgument){
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

	class ServerSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard extends Wizard {

		protected ServerSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard(String operationName){
			super(ServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "ServerSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard.help";
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
			getParametersPanel().getChildren().add(new FractionSelectionPanel("creditPoints", this));		
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