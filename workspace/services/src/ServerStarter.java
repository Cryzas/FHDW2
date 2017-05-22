


import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import persistence.Cache;
import persistence.ConnectionHandler;
import persistence.PersistenceException;

import model.DBConnectionConstants;

import modelServer.ConnectionServer;
import modelServer.RemoteServerMaster;
import modelServer.ServerReporter;

public class ServerStarter extends Application implements ServerReporter {
	
	private ObservableList<RemoteServerMaster> servers = FXCollections.observableArrayList();	
	private ObservableList<String> 	      cacheEntries = FXCollections.observableArrayList();	
	private java.util.Vector<Object>            backup = new java.util.Vector<Object>();

	private Insets prefMargin = new Insets(20,20,20,20);
    	
	public static void main(String[] args) {
		try {
			if (args.length >= 1)
				DBConnectionConstants.DataBaseName = args[0];
			if (args.length >= 2) {
				DBConnectionConstants.UserName = args[1];
				DBConnectionConstants.SchemaName = args[1];
			}
			  launch( args ); 		  //start fx thread
		} catch (Exception e) {	e.printStackTrace();}
	}
	private BorderPane rootPane = null;
	public void init(){
		this.rootPane = new BorderPane();
        this.rootPane.setCenter( this.getMainTabPane());
        this.getStartButton().setDefaultButton(true);
	}
	private Scene startScene = null;	
	private Stage stage;
	public void start( Stage primaryStage ) throws Exception {
		this.stage = primaryStage;
		this.startScene = new Scene( this.rootPane, 1100, 600);	
		this.stage.setTitle( "GOJA Server");
		this.stage.setScene( this.startScene );		
        this.getMainTabPane().getSelectionModel().selectLast();
        this.getMainTabPane().getSelectionModel().selectFirst();
        this.getPasswordField().setText("");
		Image logo = new Image( this.getClass().getResourceAsStream("/viewResources/generatorLogo.jpg"));
		this.stage.getIcons().add( logo );
		this.stage.setOnCloseRequest( new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				ServerStarter.this.stopServer();
			    Platform.exit();
			    System.exit(0);				
			}
		} );
		this.stage.sizeToScene();
		this.stage.centerOnScreen();		
		this.stage.show();			
	    this.getPasswordField().requestFocus();
	}
	private TabPane mainTabPane = null;
	private TabPane getMainTabPane() {
		if( this.mainTabPane == null){
			final Tab tab1 = new Tab();
			tab1.setText( " Connection ");
			tab1.setClosable( false);
			tab1.setContent( this.getCompletePanel());
			final Tab tab2 = new Tab();
			tab2.setText( " Cache      ");	
			tab2.setClosable( false);
			tab2.setContent( this.getCachePanel());
			this.mainTabPane = new TabPane( tab1, tab2 );
			this.mainTabPane.autosize();
			this.mainTabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
				public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, final Tab newValue) {
					Platform.runLater(new Runnable() {
						public void run() {
							if( mainTabPane.getTabs().size() > 0 ){
								if( newValue.equals( tab1 ) ){	
									tab1.getContent().requestFocus();
									ServerStarter.this.getPasswordField().requestFocus();	
								} else 
								if( newValue.equals( tab2 ) ){
									ServerStarter.this.getFilterTextPane().requestFocus();						
								}										
							}
							
						}
					});
				}
			});
			this.mainTabPane.getSelectionModel().selectFirst();
		}
		return this.mainTabPane;
	}
	private BorderPane cachePanel = null;
	private BorderPane getCachePanel() {
		if( this.cachePanel == null){
			this.cachePanel = new BorderPane();
			this.cachePanel.setTop(    this.getCacheFilterPanel());
			this.cachePanel.setCenter( this.getCacheEntryList());
			this.cachePanel.setBottom( this.getCacheReportButton());
			BorderPane.setMargin( this.getCacheFilterPanel(),  this.prefMargin );
			BorderPane.setMargin( this.getCacheReportButton(), this.prefMargin);
		}
		return this.cachePanel;
	}
	private HBox cacheFilterPanel = null;
	private HBox getCacheFilterPanel() {
		if( this.cacheFilterPanel == null){
			this.cacheFilterPanel = new HBox( 10 );
			Label label = new Label("Filter:");
			label.setMinWidth( Region.USE_PREF_SIZE);
			label.setMaxWidth( Region.USE_PREF_SIZE);
			this.cacheFilterPanel.getChildren().add( label);
			this.cacheFilterPanel.getChildren().add( this.getFilterTextPane());
			HBox.setHgrow(this.cacheFilterPanel, Priority.ALWAYS);
		}
		return this.cacheFilterPanel;
	}
	private TextField filterTextPane = null;
	private TextField getFilterTextPane() {
		if( this.filterTextPane == null){
			this.filterTextPane = new TextField();			
			this.filterTextPane.setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					ServerStarter.this.filter();				
				}
			});
		}	
		return this.filterTextPane;
	}
	private Button cacheReportButton = null;
	private Button getCacheReportButton() {
		if( this.cacheReportButton == null){
			this.cacheReportButton = new Button("Show cache report");
			this.cacheReportButton.setMinWidth( Region.USE_PREF_SIZE);
			this.cacheReportButton.setMaxWidth( Region.USE_PREF_SIZE);
			this.cacheReportButton.setOnAction( new EventHandler<ActionEvent>(){
				@SuppressWarnings("unchecked")
				public void handle(ActionEvent event) {
					backup = Cache.getTheCache().getCacheReportList();
					ServerStarter.this.filter();
				}
			});
		}
		return this.cacheReportButton;
	}
	protected void filter() {
		this.cacheEntries.clear();
		for( Object current : this.backup) {
			if( current.toString().contains( this.getFilterTextPane().getText() ))
				this.cacheEntries.add( current.toString());
		}
		this.getCacheEntryList().setItems( this.cacheEntries );
	}
//	private ScrollPane cacheEntryListScrollPane = null;
//	private ScrollPane getCacheEntryListScrollPane() {
//		if (this.cacheEntryListScrollPane == null){
//			this.cacheEntryListScrollPane = new ScrollPane();
//			this.cacheEntryListScrollPane.setContent( this.getCacheEntryList());
//			this.cacheEntryListScrollPane.setFitToHeight(true);
//			this.cacheEntryListScrollPane.setFitToWidth( true);
//		}
//		return this.cacheEntryListScrollPane;
//	}
	private ListView<String> cacheEntryList = null;
	private ListView<String> getCacheEntryList() {
		if( this.cacheEntryList == null) {
			this.cacheEntryList = new ListView<String>();
			this.cacheEntryList.setItems( this.cacheEntries);
		}
		return this.cacheEntryList;
	}
	private BorderPane completePanel = null;
	private BorderPane getCompletePanel() {
		if( this.completePanel == null){
			this.completePanel = new BorderPane();
			this.completePanel.setTop(    this.getStarterPanel() );
			this.completePanel.setCenter( this.getConnectionPanel());
			this.completePanel.setBottom( this.getCacheSizePanel());
		}
		return this.completePanel;
	}
	private VBox starterPanel = null;
	private VBox getStarterPanel() {
		if( this.starterPanel == null ){
			this.starterPanel = new VBox( 10);
			this.starterPanel.getChildren().add( this.getPasswordPanel());
			this.starterPanel.getChildren().add( this.getStatusLabel() );
			VBox.setMargin( this.getPasswordPanel(), new Insets( 10,20,10,20));			
			VBox.setMargin( this.getStatusLabel(),   new Insets(  0,20,10,20));
		}
		return this.starterPanel;
	}
	private TitledPane connectionPanel = null;
	private TitledPane getConnectionPanel() {
		if( this.connectionPanel == null){
			this.connectionPanel = new TitledPane("Connections:", this.getConnectionList());
			this.connectionPanel.setPrefSize( 700, 700 );
			this.connectionPanel.setCollapsible( false);
		}
		return this.connectionPanel;
	}
	private HBox cacheSizePanel = null;
	private HBox getCacheSizePanel() {
		if( this.cacheSizePanel == null){
			this.cacheSizePanel = new HBox( 10);
			this.cacheSizePanel.getChildren().add( this.getCurrentCacheSizePanel()  );
			this.cacheSizePanel.getChildren().add( this.getMaximalCacheSizePanel());
			this.cacheSizePanel.getChildren().add( this.getRecycledPanel() );
			this.cacheSizePanel.getChildren().add( this.getToolBarGC());
//			this.getCurrentCacheSizePanel().setPrefWidth( 180 );
//			this.getMaximalCacheSizePanel().setPrefWidth( 180 );
//			this.getRecycledPanel().setPrefWidth(         150);
			HBox.setMargin( this.getCurrentCacheSizePanel(), new Insets(20,10,20,20));
			HBox.setMargin( this.getMaximalCacheSizePanel(), new Insets(20,10,20,10));
			HBox.setMargin( this.getRecycledPanel(),         new Insets(20,10,20,10));
			HBox.setMargin( this.getToolBarGC(),             new Insets(15,20,20,90));
		}
		return this.cacheSizePanel;
	}	
	private HBox toolBarGC = null;
	private HBox getToolBarGC() {
		if( this.toolBarGC == null){
			this.toolBarGC = new HBox( 8 );
			this.toolBarGC.getChildren().add( this.getGCButton());
			this.toolBarGC.getChildren().add( this.getCGCButton());
		}	
		return this.toolBarGC;
	}
	private HBox recycledPanel = null;
	private HBox getRecycledPanel() {
		if( this.recycledPanel == null){
			this.recycledPanel = new HBox( 10);
			this.recycledPanel.getChildren().add( new Label("Recycled:") );
			this.recycledPanel.getChildren().add( this.getRecycledLabel());
		}	
		return this.recycledPanel;
	}
	private HBox maximalCacheSizePanel = null;
	private HBox getMaximalCacheSizePanel() {
		if( this.maximalCacheSizePanel == null){
			this.maximalCacheSizePanel = new HBox( 10);
			this.maximalCacheSizePanel.getChildren().add( new Label("Maximal Cache Size:") );
			this.maximalCacheSizePanel.getChildren().add( this.getMaximalCacheSizeLabel());
		}	
		return this.maximalCacheSizePanel;
	}
	private HBox currentCacheSizePanel = null;
	private HBox getCurrentCacheSizePanel() {
		if( this.currentCacheSizePanel == null){
			this.currentCacheSizePanel = new HBox( 10);
			this.currentCacheSizePanel.getChildren().add( new Label("Current Cache Size:") );
			this.currentCacheSizePanel.getChildren().add( this.getCacheSizeLabel());
		}	
		return this.currentCacheSizePanel;
	}
	private Button cGCButton = null;
	private Button getCGCButton(){
		if( this.cGCButton == null) {
			this.cGCButton = new Button("Cache-GC");
			this.cGCButton.setMinWidth( Region.USE_PREF_SIZE);
			this.cGCButton.setMaxWidth( Region.USE_PREF_SIZE);
			this.cGCButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Cache.getTheCache().forced = true;
				}
			});
		}
		return this.cGCButton;
	}
	private Button gCButton = null;
	private Button getGCButton(){
		if( this.gCButton == null) {
			this.gCButton = new Button("GC");
			this.gCButton.setMinWidth( Region.USE_PREF_SIZE);
			this.gCButton.setMaxWidth( Region.USE_PREF_SIZE);
			this.gCButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.gc();
				}
			});
		}
		return this.gCButton;
	}
	private Label recycledLabel = null;
	private Label getRecycledLabel() {
		if( this.recycledLabel == null ) this.recycledLabel = new Label("0");
		return this.recycledLabel;
	} 
	private Label cacheSizeLabel = null;
	private Label getCacheSizeLabel() {
		if( this.cacheSizeLabel == null) this.cacheSizeLabel = new Label("0");
		return this.cacheSizeLabel;
	}
	private Label maximalCacheSizeLabel = null;
	private Label getMaximalCacheSizeLabel() {
		if( this.maximalCacheSizeLabel == null ) this.maximalCacheSizeLabel = new Label("0");
		return this.maximalCacheSizeLabel;
	}
//	private ScrollPane connectionScrollPane = null;
//	private ScrollPane getConnectionScrollPane() {
//		if( this.connectionScrollPane == null){
//			this.connectionScrollPane = new ScrollPane();
//			this.connectionScrollPane.setContent( this.getConnectionList() );
//			this.connectionScrollPane.setFitToHeight(true);
//			this.connectionScrollPane.setFitToWidth( true);
//		}
//		return connectionScrollPane;
//	}
	private ListView<RemoteServerMaster> connectionList = null;
	private ListView<RemoteServerMaster> getConnectionList() {
		if( this.connectionList == null){
			this.connectionList = new ListView<RemoteServerMaster>();
			this.connectionList.setItems( this.servers );
		}
		return this.connectionList;
	}	
	private HBox passwordPanel = null;
	private HBox getPasswordPanel() {
		if( this.passwordPanel == null) {
			this.passwordPanel = new HBox( 10);
			this.passwordPanel.setAlignment( Pos.BASELINE_LEFT);
			this.passwordPanel.getChildren().add( new Label("Password for Database:"));
			this.passwordPanel.getChildren().add( this.getPasswordField());
			this.passwordPanel.getChildren().add( this.getStartButton());
			this.passwordPanel.getChildren().add( new Label("Down until:"));
			this.passwordPanel.getChildren().add( this.getDownTimeTextField());
			this.passwordPanel.getChildren().add( this.getSwitchOffButton());
			this.passwordPanel.getChildren().add( this.getStopButton());
			HBox.setMargin(this.getStartButton(), new Insets(0,30,0,0));
		}
		return this.passwordPanel;
	}
	private Label statusLabel = null;
	private Label getStatusLabel() {
		if( this.statusLabel == null){			
			this.statusLabel = new Label("    ");
		}
		this.statusLabel.setTextFill( Color.BLACK);
		return this.statusLabel;
	}
	private TextField downTimeTextField = null;
	private TextField getDownTimeTextField(){
		if( this.downTimeTextField == null){
			this.downTimeTextField = new TextField();
		}
		return this.downTimeTextField;
	}
	private Button switchOffButton = null;
	private Button getSwitchOffButton(){
		if( this.switchOffButton == null) {
			this.switchOffButton = new Button( "Switch off" );
			this.switchOffButton.setDisable(true);
			this.switchOffButton.setMinWidth( Region.USE_PREF_SIZE);
			this.switchOffButton.setMaxWidth( Region.USE_PREF_SIZE);
			this.switchOffButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle( ActionEvent event) {
					ServerStarter.this.switchOffServer();					
				}
			});			
		}
		return this.switchOffButton;
	}
	private PasswordField passwordField = null;
	private PasswordField getPasswordField() {
		if( this.passwordField == null) {
			this.passwordField = new PasswordField();
		}
		return this.passwordField;
	}
	private Button startButton = null;
	private Button getStartButton() {
		if( this.startButton == null) {
			this.startButton = new Button( "Start");
			this.startButton.setMinWidth( Region.USE_PREF_SIZE);
			this.startButton.setMaxWidth( Region.USE_PREF_SIZE);
			this.startButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle( ActionEvent event) {
					ServerStarter.this.startServer();
				}
			});
		}
		return this.startButton;
	}
	private Button stopButton = null;
	private Button getStopButton() {
		if( this.stopButton == null){
			this.stopButton = new Button("Stop");
			this.stopButton.setMinWidth( Region.USE_PREF_SIZE);
			this.stopButton.setMaxWidth( Region.USE_PREF_SIZE);
			this.stopButton.setDisable( true );
			this.stopButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					stopServer();
				}
			});
		}
		return this.stopButton;
	}
	protected synchronized void startServer() {
		this.getStatusLabel().setText("");
		try {
			DBConnectionConstants.Password = this.getPasswordField().getText().toCharArray();
			ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
			connection.connect(DBConnectionConstants.DataBaseName,
				DBConnectionConstants.SchemaName,
				DBConnectionConstants.UserName,
				DBConnectionConstants.Password,
				true);
			ConnectionHandler.initializeMapsForMappedFields();
			Cache.setReporter(this);
			ConnectionServer.startTheConnectionServer(this);
			this.getStatusLabel().setText( "Server started!");
			this.getStartButton().setDisable( 	 true);
			this.getSwitchOffButton().setDisable(false);
			this.getStopButton().setDisable(	 false);
			this.getGCButton().setDisable(		 false);
			this.getCGCButton().setDisable(		 false);

		}catch(PersistenceException pe){
			this.getStatusLabel().setTextFill( Color.RED);
			this.getStatusLabel().setText(pe.getMessage());
		}
	}
	protected void stopServer() {
		try {
			ConnectionServer.stopTheConnectionServer();
			ConnectionHandler.disconnect();
			this.getStatusLabel().setText("Server terminated!");
			this.getStopButton().setDisable(     true);
			this.getSwitchOffButton().setDisable(true);
			this.getStartButton().setDisable(    false);
			this.getGCButton().setDisable(       true);
			this.getCGCButton().setDisable(      true);
		} catch (PersistenceException e) {
			this.getStatusLabel().setTextFill(Color.RED);
			this.getStatusLabel().setText(e.getMessage());
		}
	}
	protected void switchOffServer() {
		try {
			ConnectionServer.switchOffTheConnectionServer(getDownTimeTextField().getText());
			ConnectionHandler.disconnect();
			this.getStatusLabel().setText( "Server switched off!" );
			this.getStartButton().setDisable(    true);			
			this.getSwitchOffButton().setDisable(true);
			this.getStopButton().setDisable(     false);
			this.getGCButton().setDisable(       true);
			this.getCGCButton().setDisable(      true);
		} catch (PersistenceException e) {
			this.getStatusLabel().setTextFill(Color.RED);
			this.getStatusLabel().setText(e.getMessage());
		}
	}
	public void reportCancelledConnection(final RemoteServerMaster server) {
		Platform.runLater( new Runnable() {
			public void run() {
				ServerStarter.this.servers.remove( server );
			}
		});
	}
	public void reportNewConnection(final RemoteServerMaster server) {
		Platform.runLater( new Runnable() {
			public void run() {
				ServerStarter.this.servers.add( server );
			}
		});
	}
	public void reportCurrentCacheSize( final int size, final long recycledICProxies) {
		Platform.runLater( new Runnable() {
			public void run() {
				int currentMaximum = Integer.parseInt( ServerStarter.this.getMaximalCacheSizeLabel().getText() );
				if( size > currentMaximum ) {
					ServerStarter.this.getMaximalCacheSizeLabel().setText( Integer.toString( size ) );
				}
				ServerStarter.this.getCacheSizeLabel().setText( Integer.toString( size ));
				ServerStarter.this.getRecycledLabel().setText(  Long.toString( recycledICProxies ));
			}			
		});
	}
}