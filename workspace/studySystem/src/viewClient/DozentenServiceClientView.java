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


public class DozentenServiceClientView extends BorderPane implements ExceptionAndEventHandler{

	private ConnectionMaster 		 connection;
	private ExceptionAndEventHandler parent;	
	private DozentenServiceView 		 		 service;

	/**
	 * This is the default constructor
	 */
	public DozentenServiceClientView( ExceptionAndEventHandler parent, DozentenServiceView service) {
		super();
		this.parent = parent;
		this.service = service;
		this.initialize();
	}
	@SuppressWarnings("unused")
	private DozentenServiceView getService(){
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
			this.mainSplitPane.setDividerPosition( 0, 0.7);
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
		if (object == null && this.getConnection() != null) object = this.getConnection().getDozentenServiceView();
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
	public DozentenServiceConnection getConnection(){
        	return (DozentenServiceConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		Platform.runLater(new Runnable() {
			public void run(){
				try {
					getNavigationTree().refreshTree();
					java.util.Vector<?> errors = getConnection().getDozentenServiceView().getErrors();
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
				getNavigationTree().setModel((TreeModel) getConnection().getDozentenServiceView());	
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
        ImageView handle(RemoveModuleFromGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem menuItem);
        ImageView handle(RemoveModuleFromProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem menuItem);
        ImageView handle(AddModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem menuItem);
        ImageView handle(AddModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem menuItem);
        ImageView handle(DeleteModulesPRMTRModuleManagerPRMTRModuleAbstractLSTPRMTRMenuItem menuItem);
        ImageView handle(ChangeGradeforStudentPRMTRStudentPRMTRLectureWithGradePRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(ChangeGradeSystemPRMTRModuleAtomarPRMTRMenuItem menuItem);
        ImageView handle(CreateProgramPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(DeleteProgramsPRMTRProgramManagerPRMTRProgramLSTPRMTRMenuItem menuItem);
        ImageView handle(CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem menuItem);
        ImageView handle(RemoveStudentFromGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem menuItem);
        ImageView handle(AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem menuItem);
        ImageView handle(DeleteStudentsPRMTRStudentManagerPRMTRStudentLSTPRMTRMenuItem menuItem);
        ImageView handle(EndStudyGroupPRMTRStudyGroupPRMTRMenuItem menuItem);
        ImageView handle(StartStudyGroupPRMTRProgramPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(DeleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRMenuItem menuItem);
        ImageView handle(AddUnitPRMTRModuleWithUnitsPRMTRStringPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(RemoveUnitPRMTRModuleWithUnitsPRMTRUnitLSTPRMTRMenuItem menuItem);
    }
    private abstract class DozentenServiceMenuItem extends MenuItem{
        private DozentenServiceMenuItem(){
            this.setGraphic(getIconForMenuItem(this));
        }
        abstract protected ImageView accept(MenuItemVisitor visitor);
    }
    private class SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeCPOnModulePRMTRModuleAtomarPRMTRFractionPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeCPOnUnitPRMTRUnitPRMTRFractionPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveErrorPRMTRErrorDisplayPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateModulePRMTRModuleAbstractSUBTYPENamePRMTRStringPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveModuleFromGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveModuleFromProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class DeleteModulesPRMTRModuleManagerPRMTRModuleAbstractLSTPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeGradeforStudentPRMTRStudentPRMTRLectureWithGradePRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRStringPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeGradeSystemPRMTRModuleAtomarPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateProgramPRMTRStringPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class DeleteProgramsPRMTRProgramManagerPRMTRProgramLSTPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveStudentFromGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class DeleteStudentsPRMTRStudentManagerPRMTRStudentLSTPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class EndStudyGroupPRMTRStudyGroupPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class StartStudyGroupPRMTRProgramPRMTRStringPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class DeleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddUnitPRMTRModuleWithUnitsPRMTRStringPRMTRFractionPRMTRMenuItem extends DozentenServiceMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveUnitPRMTRModuleWithUnitsPRMTRUnitLSTPRMTRMenuItem extends DozentenServiceMenuItem{
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
                final DozentenServiceCreateModuleModuleAbstractSUBTYPENameStringMssgWizard wizard = new DozentenServiceCreateModuleModuleAbstractSUBTYPENameStringMssgWizard("Modul erstellen");
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
                final DozentenServiceCreateProgramStringMssgWizard wizard = new DozentenServiceCreateProgramStringMssgWizard("Programm erstellen");
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
                final DozentenServiceCreateModuleModuleAbstractSUBTYPENameStringMssgWizard wizard = new DozentenServiceCreateModuleModuleAbstractSUBTYPENameStringMssgWizard("Modul erstellen");
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
                final DozentenServiceCreateProgramStringMssgWizard wizard = new DozentenServiceCreateProgramStringMssgWizard("Programm erstellen");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        if (selected != null){
            try {
                this.setPreCalculatedFilters(this.getConnection().dozentenService_Menu_Filter((Anything)selected));
            } catch (ModelException me){
                this.handleException(me);
                return result;
            }
            if (selected instanceof ProgramView){
                item = new RemoveModuleFromProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem();
                item.setText("Module entfernen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceRemoveModuleFromProgProgramModuleAbstractLSTMssgWizard wizard = new DozentenServiceRemoveModuleFromProgProgramModuleAbstractLSTMssgWizard("Module entfernen");
                        wizard.setFirstArgument((ProgramView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new AddModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem();
                item.setText("Module hinzufügen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceAddModuleToProgProgramModuleAbstractLSTMssgWizard wizard = new DozentenServiceAddModuleToProgProgramModuleAbstractLSTMssgWizard("Module hinzufügen");
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
                        final DozentenServiceStartStudyGroupProgramStringMssgWizard wizard = new DozentenServiceStartStudyGroupProgramStringMssgWizard("Studiengruppe eröffnen");
                        wizard.setFirstArgument((ProgramView)selected);
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
            if (selected instanceof ModuleAtomarView){
                item = new ChangeCPOnModulePRMTRModuleAtomarPRMTRFractionPRMTRMenuItem();
                item.setText("CP ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceChangeCPOnModuleModuleAtomarFractionMssgWizard wizard = new DozentenServiceChangeCPOnModuleModuleAtomarFractionMssgWizard("CP ändern");
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
            if (selected instanceof StudentManagerView){
                item = new DeleteStudentsPRMTRStudentManagerPRMTRStudentLSTPRMTRMenuItem();
                item.setText("Studenten löschen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceDeleteStudentsStudentManagerStudentLSTMssgWizard wizard = new DozentenServiceDeleteStudentsStudentManagerStudentLSTMssgWizard("Studenten löschen");
                        wizard.setFirstArgument((StudentManagerView)selected);
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
                        final DozentenServiceChangeCPOnUnitUnitFractionMssgWizard wizard = new DozentenServiceChangeCPOnUnitUnitFractionMssgWizard("CP ändern");
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
                item = new RemoveModuleFromGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem();
                item.setText("Module entfernen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceRemoveModuleFromGroupModuleGroupModuleAbstractLSTMssgWizard wizard = new DozentenServiceRemoveModuleFromGroupModuleGroupModuleAbstractLSTMssgWizard("Module entfernen");
                        wizard.setFirstArgument((ModuleGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new AddModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem();
                item.setText("Module hinzufügen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceAddModuleToGroupModuleGroupModuleAbstractLSTMssgWizard wizard = new DozentenServiceAddModuleToGroupModuleGroupModuleAbstractLSTMssgWizard("Module hinzufügen");
                        wizard.setFirstArgument((ModuleGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ModuleManagerView){
                item = new DeleteModulesPRMTRModuleManagerPRMTRModuleAbstractLSTPRMTRMenuItem();
                item.setText("Module löschen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceDeleteModulesModuleManagerModuleAbstractLSTMssgWizard wizard = new DozentenServiceDeleteModulesModuleManagerModuleAbstractLSTMssgWizard("Module löschen");
                        wizard.setFirstArgument((ModuleManagerView)selected);
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
                        final DozentenServiceChangeGradeforStudentStudentLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssgWizard wizard = new DozentenServiceChangeGradeforStudentStudentLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssgWizard("Note eintragen");
                        wizard.setFirstArgument((StudentView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof StudyGroupManagerView){
                item = new DeleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRMenuItem();
                item.setText("Studiengruppen löschen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceDeleteStudyGroupsStudyGroupManagerStudyGroupLSTMssgWizard wizard = new DozentenServiceDeleteStudyGroupsStudyGroupManagerStudyGroupLSTMssgWizard("Studiengruppen löschen");
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
                        final DozentenServiceCreateStudentStudyGroupStringStringDateMssgWizard wizard = new DozentenServiceCreateStudentStudyGroupStringStringDateMssgWizard("Student erstellen");
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
                        final DozentenServiceRemoveStudentFromGroupStudyGroupStudentLSTMssgWizard wizard = new DozentenServiceRemoveStudentFromGroupStudyGroupStudentLSTMssgWizard("Studenten entfernen");
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
                        final DozentenServiceAddStudentToGroupStudyGroupStudentLSTMssgWizard wizard = new DozentenServiceAddStudentToGroupStudyGroupStudentLSTMssgWizard("Studenten hinzufügen");
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
            if (selected instanceof ModuleAtomarStudentView){
                item = new ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem();
                item.setText("Note ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameStringMssgWizard wizard = new DozentenServiceChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameStringMssgWizard("Note ändern");
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
                        final DozentenServiceChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameStringMssgWizard wizard = new DozentenServiceChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameStringMssgWizard("Note ändern");
                        wizard.setFirstArgument((UnitStudentView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ModuleWithUnitsView){
                item = new AddUnitPRMTRModuleWithUnitsPRMTRStringPRMTRFractionPRMTRMenuItem();
                item.setText("Unit hinzufügen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceAddUnitModuleWithUnitsStringFractionMssgWizard wizard = new DozentenServiceAddUnitModuleWithUnitsStringFractionMssgWizard("Unit hinzufügen");
                        wizard.setFirstArgument((ModuleWithUnitsView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new RemoveUnitPRMTRModuleWithUnitsPRMTRUnitLSTPRMTRMenuItem();
                item.setText("Units entfernen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceRemoveUnitModuleWithUnitsUnitLSTMssgWizard wizard = new DozentenServiceRemoveUnitModuleWithUnitsUnitLSTMssgWizard("Units entfernen");
                        wizard.setFirstArgument((ModuleWithUnitsView)selected);
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
                item.setText("CP Gewichtung ändern ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard wizard = new DozentenServiceSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard("CP Gewichtung ändern");
                        wizard.setFirstArgument((ModuleWithUnitsSGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ProgramManagerView){
                item = new DeleteProgramsPRMTRProgramManagerPRMTRProgramLSTPRMTRMenuItem();
                item.setText("Programme löschen ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final DozentenServiceDeleteProgramsProgramManagerProgramLSTMssgWizard wizard = new DozentenServiceDeleteProgramsProgramManagerProgramLSTMssgWizard("Programme löschen");
                        wizard.setFirstArgument((ProgramManagerView)selected);
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
    
	class DozentenServiceAddModuleToGroupModuleGroupModuleAbstractLSTMssgWizard extends Wizard {

		protected DozentenServiceAddModuleToGroupModuleGroupModuleAbstractLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceAddModuleToGroupModuleGroupModuleAbstractLSTMssgWizard.help";
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
				final ObjectCollectionSelectionPanel panel1 = new ObjectCollectionSelectionPanel("Module", "view.ModuleAbstractView", null, this, getMultiSelectionFor("addModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRmodules"));
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

	class DozentenServiceAddModuleToProgProgramModuleAbstractLSTMssgWizard extends Wizard {

		protected DozentenServiceAddModuleToProgProgramModuleAbstractLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceAddModuleToProgProgramModuleAbstractLSTMssgWizard.help";
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
				final ObjectCollectionSelectionPanel panel2 = new ObjectCollectionSelectionPanel("Module", "view.ModuleAbstractView", null, this, getMultiSelectionFor("addModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRmodules"));
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

	class DozentenServiceAddStudentToGroupStudyGroupStudentLSTMssgWizard extends Wizard {

		protected DozentenServiceAddStudentToGroupStudyGroupStudentLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceAddStudentToGroupStudyGroupStudentLSTMssgWizard.help";
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
				final ObjectCollectionSelectionPanel panel3 = new ObjectCollectionSelectionPanel("Studenten", "view.StudentView", null, this, getMultiSelectionFor("addStudentToGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRstudents"));
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

	class DozentenServiceAddUnitModuleWithUnitsStringFractionMssgWizard extends Wizard {

		protected DozentenServiceAddUnitModuleWithUnitsStringFractionMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddUnitPRMTRModuleWithUnitsPRMTRStringPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceAddUnitModuleWithUnitsStringFractionMssgWizard.help";
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("Name", this));
			getParametersPanel().getChildren().add(new FractionSelectionPanel("Credit Points", this));		
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

	class DozentenServiceChangeCPOnModuleModuleAtomarFractionMssgWizard extends Wizard {

		protected DozentenServiceChangeCPOnModuleModuleAtomarFractionMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeCPOnModulePRMTRModuleAtomarPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceChangeCPOnModuleModuleAtomarFractionMssgWizard.help";
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
			getParametersPanel().getChildren().add(new FractionSelectionPanel("Credit Points", this));		
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

	class DozentenServiceChangeCPOnUnitUnitFractionMssgWizard extends Wizard {

		protected DozentenServiceChangeCPOnUnitUnitFractionMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeCPOnUnitPRMTRUnitPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceChangeCPOnUnitUnitFractionMssgWizard.help";
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
			getParametersPanel().getChildren().add(new FractionSelectionPanel("Credit Points", this));		
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

	class DozentenServiceChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameStringMssgWizard extends Wizard {

		protected DozentenServiceChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameStringMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeGradeOfModulePRMTRModuleAtomarStudentPRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceChangeGradeOfModuleModuleAtomarStudentGradesInSimpleOrThirdSUBTYPENameStringMssgWizard.help";
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
			this.check();
		}
		
		
	}

	class DozentenServiceChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameStringMssgWizard extends Wizard {

		protected DozentenServiceChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameStringMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeGradeOfUnitPRMTRUnitStudentPRMTRGradesInThirdSUBTYPENamePRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceChangeGradeOfUnitUnitStudentGradesInThirdSUBTYPENameStringMssgWizard.help";
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
			this.check();
		}
		
		
	}

	class DozentenServiceChangeGradeforStudentStudentLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssgWizard extends Wizard {

		protected DozentenServiceChangeGradeforStudentStudentLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeGradeforStudentPRMTRStudentPRMTRLectureWithGradePRMTRGradesInSimpleOrThirdSUBTYPENamePRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceChangeGradeforStudentStudentLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssgWizard.help";
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
			final ObjectSelectionPanel panel4 = new ObjectSelectionPanel("Vorlesung", "view.LectureWithGrade", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().lecture_Path_In_ChangeGradeforStudent((StudentView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel4);
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
			this.check();
		}
		
		
	}

	class DozentenServiceCreateModuleModuleAbstractSUBTYPENameStringMssgWizard extends Wizard {

		protected DozentenServiceCreateModuleModuleAbstractSUBTYPENameStringMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateModulePRMTRModuleAbstractSUBTYPENamePRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceCreateModuleModuleAbstractSUBTYPENameStringMssgWizard.help";
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
			getParametersPanel().getChildren().add(new RegExprSelectionPanel("Typ", this, common.RegularExpressionManager.moduleAbstractSUBTYPEName.getRegExpr()));
			getParametersPanel().getChildren().add(new StringSelectionPanel("Name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class DozentenServiceCreateProgramStringMssgWizard extends Wizard {

		protected DozentenServiceCreateProgramStringMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateProgramPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceCreateProgramStringMssgWizard.help";
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("Name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class DozentenServiceCreateStudentStudyGroupStringStringDateMssgWizard extends Wizard {

		protected DozentenServiceCreateStudentStudyGroupStringStringDateMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateStudentPRMTRStudyGroupPRMTRStringPRMTRStringPRMTRDatePRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceCreateStudentStudyGroupStringStringDateMssgWizard.help";
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

	class DozentenServiceDeleteModulesModuleManagerModuleAbstractLSTMssgWizard extends Wizard {

		protected DozentenServiceDeleteModulesModuleManagerModuleAbstractLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new DeleteModulesPRMTRModuleManagerPRMTRModuleAbstractLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceDeleteModulesModuleManagerModuleAbstractLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().deleteModules(firstArgument, (java.util.Vector<ModuleAbstractView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			final ObjectCollectionSelectionPanel panel5 = new ObjectCollectionSelectionPanel("Module", "view.ModuleAbstractView", null, this, getMultiSelectionFor("deleteModulesPRMTRModuleManagerPRMTRModuleAbstractLSTPRMTRmodules"))
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().modules_Path_In_DeleteModules((ModuleManagerView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel5);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private ModuleManagerView firstArgument; 
	
		public void setFirstArgument(ModuleManagerView firstArgument){
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

	class DozentenServiceDeleteProgramsProgramManagerProgramLSTMssgWizard extends Wizard {

		protected DozentenServiceDeleteProgramsProgramManagerProgramLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new DeleteProgramsPRMTRProgramManagerPRMTRProgramLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceDeleteProgramsProgramManagerProgramLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().deletePrograms(firstArgument, (java.util.Vector<ProgramView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			final ObjectCollectionSelectionPanel panel6 = new ObjectCollectionSelectionPanel("Programme", "view.ProgramView", null, this, getMultiSelectionFor("deleteProgramsPRMTRProgramManagerPRMTRProgramLSTPRMTRprograms"))
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().programs_Path_In_DeletePrograms((ProgramManagerView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel6);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private ProgramManagerView firstArgument; 
	
		public void setFirstArgument(ProgramManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset((java.util.Vector<?>)firstArgument.getPrograms());
				if (!selectionPanel0.check()) selectionPanel0.preset(new java.util.Vector<Object>());
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class DozentenServiceDeleteStudentsStudentManagerStudentLSTMssgWizard extends Wizard {

		protected DozentenServiceDeleteStudentsStudentManagerStudentLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new DeleteStudentsPRMTRStudentManagerPRMTRStudentLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceDeleteStudentsStudentManagerStudentLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().deleteStudents(firstArgument, (java.util.Vector<StudentView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			final ObjectCollectionSelectionPanel panel7 = new ObjectCollectionSelectionPanel("Studenten", "view.StudentView", null, this, getMultiSelectionFor("deleteStudentsPRMTRStudentManagerPRMTRStudentLSTPRMTRstudents"))
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().students_Path_In_DeleteStudents((StudentManagerView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel7);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private StudentManagerView firstArgument; 
	
		public void setFirstArgument(StudentManagerView firstArgument){
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

	class DozentenServiceDeleteStudyGroupsStudyGroupManagerStudyGroupLSTMssgWizard extends Wizard {

		protected DozentenServiceDeleteStudyGroupsStudyGroupManagerStudyGroupLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new DeleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceDeleteStudyGroupsStudyGroupManagerStudyGroupLSTMssgWizard.help";
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
			final ObjectCollectionSelectionPanel panel8 = new ObjectCollectionSelectionPanel("Studiengruppen", "view.StudyGroupView", null, this, getMultiSelectionFor("deleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRgroups"))
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().groups_Path_In_DeleteStudyGroups((StudyGroupManagerView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel8);		
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

	class DozentenServiceRemoveModuleFromGroupModuleGroupModuleAbstractLSTMssgWizard extends Wizard {

		protected DozentenServiceRemoveModuleFromGroupModuleGroupModuleAbstractLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new RemoveModuleFromGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceRemoveModuleFromGroupModuleGroupModuleAbstractLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().removeModuleFromGroup(firstArgument, (java.util.Vector<ModuleAbstractView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			final ObjectCollectionSelectionPanel panel9 = new ObjectCollectionSelectionPanel("Module", "view.ModuleAbstractView", null, this, getMultiSelectionFor("removeModuleFromGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRmodules"))
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().modules_Path_In_RemoveModuleFromGroup((ModuleGroupView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel9);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
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

	class DozentenServiceRemoveModuleFromProgProgramModuleAbstractLSTMssgWizard extends Wizard {

		protected DozentenServiceRemoveModuleFromProgProgramModuleAbstractLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new RemoveModuleFromProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceRemoveModuleFromProgProgramModuleAbstractLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().removeModuleFromProg(firstArgument, (java.util.Vector<ModuleAbstractView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			final ObjectCollectionSelectionPanel panel10 = new ObjectCollectionSelectionPanel("Module", "view.ModuleAbstractView", null, this, getMultiSelectionFor("removeModuleFromProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRmodules"))
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().modules_Path_In_RemoveModuleFromProg((ProgramView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel10);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
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

	class DozentenServiceRemoveStudentFromGroupStudyGroupStudentLSTMssgWizard extends Wizard {

		protected DozentenServiceRemoveStudentFromGroupStudyGroupStudentLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new RemoveStudentFromGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceRemoveStudentFromGroupStudyGroupStudentLSTMssgWizard.help";
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
			final ObjectCollectionSelectionPanel panel11 = new ObjectCollectionSelectionPanel("Studenten", "view.StudentView", null, this, getMultiSelectionFor("removeStudentFromGroupPRMTRStudyGroupPRMTRStudentLSTPRMTRstudents"))
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().students_Path_In_RemoveStudentFromGroup((StudyGroupView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel11);		
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

	class DozentenServiceRemoveUnitModuleWithUnitsUnitLSTMssgWizard extends Wizard {

		protected DozentenServiceRemoveUnitModuleWithUnitsUnitLSTMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new RemoveUnitPRMTRModuleWithUnitsPRMTRUnitLSTPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceRemoveUnitModuleWithUnitsUnitLSTMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().removeUnit(firstArgument, (java.util.Vector<UnitView>)((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
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
			final ObjectCollectionSelectionPanel panel12 = new ObjectCollectionSelectionPanel("Units", "view.UnitView", null, this, getMultiSelectionFor("removeUnitPRMTRModuleWithUnitsPRMTRUnitLSTPRMTRunits"))
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().units_Path_In_RemoveUnit((ModuleWithUnitsView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel12);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectCollectionSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private ModuleWithUnitsView firstArgument; 
	
		public void setFirstArgument(ModuleWithUnitsView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset((java.util.Vector<?>)firstArgument.getUnits());
				if (!selectionPanel0.check()) selectionPanel0.preset(new java.util.Vector<Object>());
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class DozentenServiceStartStudyGroupProgramStringMssgWizard extends Wizard {

		protected DozentenServiceStartStudyGroupProgramStringMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new StartStudyGroupPRMTRProgramPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceStartStudyGroupProgramStringMssgWizard.help";
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
			getParametersPanel().getChildren().add(new StringSelectionPanel("Name", this));		
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

	class DozentenServiceSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard extends Wizard {

		protected DozentenServiceSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard(String operationName){
			super(DozentenServiceClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "DozentenServiceSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssgWizard.help";
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
			final ObjectSelectionPanel panel13 = new ObjectSelectionPanel("Von Unit", "view.UnitSGroupView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().fromUnit_Path_In_SwapCPonModuleWithUnits((ModuleWithUnitsSGroupView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel13);
			final ObjectSelectionPanel panel14 = new ObjectSelectionPanel("Zu Unit", "view.UnitSGroupView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().ToUnit_Path_In_SwapCPonModuleWithUnits((ModuleWithUnitsSGroupView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel14);
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
	
	private ImageView getIconForMenuItem(DozentenServiceMenuItem menuItem){
		return menuItem.accept(new MenuItemVisitor() {
			
			@Override
			public ImageView handle(RemoveUnitPRMTRModuleWithUnitsPRMTRUnitLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(10));
			}
			
			@Override
			public ImageView handle(AddUnitPRMTRModuleWithUnitsPRMTRStringPRMTRFractionPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(9));
			}
			
			@Override
			public ImageView handle(DeleteStudyGroupsPRMTRStudyGroupManagerPRMTRStudyGroupLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(8));
			}
			
			@Override
			public ImageView handle(StartStudyGroupPRMTRProgramPRMTRStringPRMTRMenuItem menuItem) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ImageView handle(EndStudyGroupPRMTRStudyGroupPRMTRMenuItem menuItem) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ImageView handle(DeleteStudentsPRMTRStudentManagerPRMTRStudentLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(8));
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
			public ImageView handle(DeleteProgramsPRMTRProgramManagerPRMTRProgramLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(8));
			}
			
			@Override
			public ImageView handle(CreateProgramPRMTRStringPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(9));
			}
			
			@Override
			public ImageView handle(ChangeGradeSystemPRMTRModuleAtomarPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(11));
			}
			
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
			public ImageView handle(DeleteModulesPRMTRModuleManagerPRMTRModuleAbstractLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(8));
			}
			
			@Override
			public ImageView handle(AddModuleToProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(9));
			}
			
			@Override
			public ImageView handle(AddModuleToGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(9));
			}
			
			@Override
			public ImageView handle(RemoveModuleFromProgPRMTRProgramPRMTRModuleAbstractLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(10));
			}
			
			@Override
			public ImageView handle(RemoveModuleFromGroupPRMTRModuleGroupPRMTRModuleAbstractLSTPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(10));
			}
			
			@Override
			public ImageView handle(CreateModulePRMTRModuleAbstractSUBTYPENamePRMTRStringPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(9));
			}
			
			@Override
			public ImageView handle(RemoveErrorPRMTRErrorDisplayPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(10));
			}
			
			@Override
			public ImageView handle(ChangeCPOnUnitPRMTRUnitPRMTRFractionPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(11));
			}
			
			@Override
			public ImageView handle(ChangeCPOnModulePRMTRModuleAtomarPRMTRFractionPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(11));
			}
			
			@Override
			public ImageView handle(
					SwapCPonModuleWithUnitsPRMTRModuleWithUnitsSGroupPRMTRUnitSGroupPRMTRUnitSGroupPRMTRFractionPRMTRMenuItem menuItem) {
				return new ImageView(IconManager.getImage(11));
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