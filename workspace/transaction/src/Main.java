



import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import model.DBConnectionConstants;

import modelServer.ConnectionServer;
import modelServer.RemoteServerMaster;
import modelServer.ServerReporter;

import persistence.PersistenceException;
import persistence.*;

import view.ModelException;

import viewClient.ClientReporter;
import viewClient.ConnectionMaster;
import viewClient.MainView;
import viewClient.ServerConnection;

public class Main extends Application implements ServerReporter, ClientReporter {

	private String URLInputText = "";
	
	private ObservableList<ConnectionMaster>   clients = FXCollections.observableArrayList();
	private ObservableList<RemoteServerMaster> servers = FXCollections.observableArrayList();	
	private Thread statusbarResetter = new Thread();
	
	public static void main(String[] args) {
		try {
		  if( args.length >= 1) DBConnectionConstants.DataBaseName = args[0];
		  if( args.length >= 2) {
			  DBConnectionConstants.UserName = args[1];
			  DBConnectionConstants.SchemaName = args[1];
		  }
		  launch( args ); 		  //fx thread 
		} catch( Exception e ) {
		  e.printStackTrace();
		}
	}	
	private BorderPane rootPane = null;
	public void init(){
		Cache.setReporter( this );	
		Parameters pars = getParameters();
		List<String> parlist = pars.getRaw();
		this.URLInputText = (parlist.size() >= 3 ? parlist.get(2) : "http://localhost");
		this.rootPane = new BorderPane();
		this.rootPane.setCenter( this.getMainSplitPane());
		this.rootPane.setBottom( this.getMainToolBar() );
		this.startServerCommand.setDefaultButton( true );
	}

	private Stage stage = null;
	@Override
	public void start( final Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		this.stage.setTitle("Test Application Panel FX");
		Scene rootScene = new Scene( this.rootPane, 1000, 400);	
		this.stage.setScene( rootScene );
		this.stage.sizeToScene();
		this.stage.setX(5);
		this.stage.setY(5);
		this.stage.setOnCloseRequest( new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				ConnectionServer.stopTheConnectionServer();	
				Platform.exit();
			    System.exit(0);				
			}
		} );
		this.stage.show();
		this.getDBPasswordInput().requestFocus();
	}
	public void reportNewConnection(final RemoteServerMaster server){
		Platform.runLater( new Runnable() {
			public void run() {
				Main.this.servers.add( server);
			}
		});
	}
	public void reportCancelledConnection(final RemoteServerMaster server) {
		Platform.runLater( new Runnable() {
			public void run() {
				Main.this.servers.remove( server);				
			}
		});
	}
	public void reportNewClient(final ConnectionMaster master) {
		Platform.runLater( new Runnable() {
			public void run() {
				Main.this.clients.add( master);
			}
		});
	}
	public void reportLostClient(final ConnectionMaster master) {
		Platform.runLater( new Runnable() {
			public void run() {
				Main.this.clients.remove( master);			
			}
		});
	}
	private void startServerAction(){
		try {
			DBConnectionConstants.Password = getDBPasswordInput().getText().toCharArray();
			ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
			connection.connect(DBConnectionConstants.DataBaseName,
				DBConnectionConstants.SchemaName,
				DBConnectionConstants.UserName,
				DBConnectionConstants.Password,
				true);
			ConnectionHandler.initializeMapsForMappedFields();
			ConnectionServer.startTheConnectionServer(this);
			this.getPasswordToolBar().setVisible(false);
			this.getClientConnectCommand().setDefaultButton(true);
			this.monitorStartAction();
			this.getUserInput().requestFocus();			
		}catch( PersistenceException pe){
			this.setStatusbar(pe);
			this.getDBPasswordInput().setText("");
			this.getDBPasswordInput().requestFocus();
		}
	}
	private void monitorStartAction() {
		DatabaseMonitor monitor = new DatabaseMonitor();
		monitor.setOnShowing( new EventHandler<WindowEvent>() {
			public void handle( WindowEvent event) {
				Platform.runLater( new Runnable(){
					public void run() {
						stage.requestFocus();
					}
				});
			}
		});
		monitor.startThread();
		monitor.show();
	}
	private void connectClientAction() {
		ServerConnection connection;
		MainView view = new MainView();
		try {
			connection = new ServerConnection( this.getURLInput().getText(), view, this);
			connection.connect( this.getUserInput().getText(), 
								this.getASPasswordInput().getText(),
								this.getCreateUserCheckBox().isSelected());
		}catch( ModelException me){
			this.setStatusbar(me);
			return;
		}catch( java.net.MalformedURLException me){
			this.setStatusbar( me.getMessage());
			return;
		}
		view.setConnection( connection );
		try {
			view.setTitle( view.getTitle() + connection.getServerView().getUser());
		} catch (ModelException me) {
			this.setStatusbar (me.getMessage());
			return;
		}
		view.centerOnScreen();
		view.show();
		view.initializeConnection();
	}
	protected void setStatusbar(ModelException exception) {
		this.setStatusbar(Long.toString(exception.getErrorNumber()) + ": " + exception.getMessage());
	}
	protected void setStatusbar(PersistenceException exception) {
		this.setStatusbar(Long.toString(exception.getErrorNumber()) + ": " + exception.getMessage());
	}
	protected void setStatusbar(String message) {
		this.statusBar.setText(message);
		if( this.statusbarResetter.isAlive()) this.statusbarResetter.interrupt();
		this.statusbarResetter = new Thread( new StatusBarResetterFX( this.statusBar));
		this.statusbarResetter.start();
	}
	private HBox mainToolBar = null;	
	private HBox getMainToolBar() {
		if( this.mainToolBar == null) {
			this.mainToolBar = new HBox( 10);
			this.mainToolBar.getChildren().add( new Label(" Cache Size:"));
			this.mainToolBar.getChildren().add( this.getCacheSizeLabel());
			HBox.setMargin( this.getCacheSizeLabel(), new Insets(0,50,0,0));
			this.mainToolBar.getChildren().add( new Label("Recycled:"));
			this.mainToolBar.getChildren().add( getRecycledLabel());
			this.mainToolBar.getChildren().add( getStatusBar());
			HBox.setMargin( this.getStatusBar(), new Insets(0,10,0,50));
		}
		return this.mainToolBar;
	}
	private SplitPane mainSplitPane = null;
	private SplitPane getMainSplitPane() {
		if( this.mainSplitPane == null) {
			this.mainSplitPane = new SplitPane();
			this.mainSplitPane.setOrientation( Orientation.VERTICAL );
// TODO FX Java 8u60: bug RT-40166 default button handling corrupt with usage of TitledPane
//			this.mainSplitPane.getItems().addAll( this.getTitledClientPanel(), this.getTitledServerPanel() );
			this.mainSplitPane.getItems().addAll( this.getClientPanel(),  this.getServerPanel() );
			this.mainSplitPane.setDividerPositions(0.5);
	   }
	   return mainSplitPane;
	}
//	private TitledPane titledClientPanel = null;
//	private TitledPane getTitledClientPanel() {
//		if( this.titledClientPanel == null) {			
//			this.titledClientPanel = new TitledPane("Clients", this.getClientPanelFX());
//			this.titledClientPanel.setCollapsible(false);
//		}
//		return titledClientPanelFX;
//	}
	private BorderPane clientPanel = null;	
	private BorderPane getClientPanel() {
		if( this.clientPanel == null) {
			this.clientPanel = new BorderPane();
			this.clientPanel.setTop(    this.getClientLabelBar() );
			this.clientPanel.setBottom( this.getClientToolBar() );
			this.clientPanel.setCenter( this.getClientList());
			BorderPane.setMargin(this.clientPanel.getBottom(), new Insets(5,0,5,0));
		}
		return clientPanel;
	}
	private ToolBar clientLabelBar = null;
	private ToolBar getClientLabelBar() {
		if( this.clientLabelBar == null){
			this.clientLabelBar = new ToolBar();
			this.clientLabelBar.getItems().add( new Label("  Client  "));
		}
		return this.clientLabelBar;
	}
//	private TitledPane titledServerPanel = null;
//	private TitledPane getTitledServerPanel() {
//		if( this.titledServerPanel == null) {			
//			this.titledServerPanel = new TitledPane("Servers", this.getServerPanelFX());
//			this.titledServerPanel.setCollapsible(false);
//		}
//		return titledServerPanelFX;
//	}
	private BorderPane serverPanel = null;	
	private BorderPane getServerPanel() {
		if( this.serverPanel == null) {
			this.serverPanel = new BorderPane();
			this.serverPanel.setTop(    this.getServerLabelBar());
			this.serverPanel.setBottom( this.getPasswordToolBar() );
			this.serverPanel.setCenter( this.getServerList() );
			BorderPane.setMargin(this.serverPanel.getBottom(), new Insets(5,0,5,0));
		}
		return serverPanel;
	}
	private ToolBar serverLabelBar = null;
	private ToolBar getServerLabelBar() {
		if( this.serverLabelBar == null){
			this.serverLabelBar = new ToolBar();
			this.serverLabelBar.getItems().add( new Label("  Server  "));
		}
		return this.serverLabelBar;
	}	
	private HBox passwordToolBar = null;
	private HBox getPasswordToolBar() {
		if( this.passwordToolBar == null) {
			this.passwordToolBar = new HBox(10);
			this.passwordToolBar.setAlignment( Pos.BASELINE_LEFT);
			this.passwordToolBar.getChildren().add( this.getPasswordLabel());
			this.passwordToolBar.getChildren().add( this.getDBPasswordInput());
			this.passwordToolBar.getChildren().add( this.getStartServerCommand());
		}
		return this.passwordToolBar;
	}
	private PasswordField DBPasswordInput = null;
	private PasswordField getDBPasswordInput() {
		if( this.DBPasswordInput == null) {
			this.DBPasswordInput = new PasswordField();
//			this.DBPasswordInput.setPrefWidth(100);
			this.DBPasswordInput.setText("pg");
		}
		return DBPasswordInput;
	}
	private Label passwordLabel = null;
	private Label getPasswordLabel() {
		if( this.passwordLabel == null) {
			this.passwordLabel = new Label(" Password: ");
			this.passwordLabel.setMinWidth( Region.USE_PREF_SIZE);
			this.passwordLabel.setMaxWidth( Region.USE_PREF_SIZE);
		}
		return this.passwordLabel;
	}
	private Button startServerCommand = null;
	private Button getStartServerCommand() {
		if( this.startServerCommand == null) {
			this.startServerCommand = new Button("Start");
			this.startServerCommand.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
					Main.this.startServerAction();
				}});
		}
		return this.startServerCommand;
	}
	private HBox clientToolBar = null;
	private HBox getClientToolBar() {
		if( this.clientToolBar == null) {
			this.clientToolBar = new HBox(10);
			this.clientToolBar.setAlignment( Pos.BASELINE_LEFT);
			this.clientToolBar.getChildren().add( this.getConnectionURLLabel());
			this.clientToolBar.getChildren().add( this.getURLInput());
			this.clientToolBar.getChildren().add( this.getConnectionNumberLabel());
			this.clientToolBar.getChildren().add( this.getUserInput());
			this.clientToolBar.getChildren().add( this.getPWLabel());
			this.clientToolBar.getChildren().add( this.getASPasswordInput()); 			
			this.clientToolBar.getChildren().add( this.getCreateUserCheckBox());
			this.clientToolBar.getChildren().add( this.getClientConnectCommand() );
			HBox.setMargin( this.getConnectionNumberLabel(), new Insets(0,0,0,10));
			HBox.setMargin( this.getCreateUserCheckBox(),   new Insets(0,10,0,20));
			HBox.setMargin( this.getClientConnectCommand(), new Insets(0,10,0,0));
			HBox.setHgrow(this.getURLInput(), Priority.ALWAYS);
			HBox.setHgrow(this.getUserInput(), Priority.ALWAYS);
			HBox.setHgrow(this.getASPasswordInput(), Priority.ALWAYS);
		}
		return clientToolBar;
	}
	private CheckBox createUserBox = null;
	private CheckBox getCreateUserCheckBox() {
		if( this.createUserBox == null){
			this.createUserBox = new CheckBox("Create User");
			this.createUserBox.setSelected(true);
		}
		return this.createUserBox;
	}
	private Label connectionURLLabel = null;
	private Label getConnectionURLLabel() {
		if( this.connectionURLLabel == null) {
			this.connectionURLLabel = new Label("URL:");
		}
		return this.connectionURLLabel;
	}	
	private Label connectionNumberLabel = null;
	private Label getConnectionNumberLabel() {
		if( this.connectionNumberLabel == null) {
			this.connectionNumberLabel = new Label("User:");
		}
		return this.connectionNumberLabel;
	}
	private TextField userInput = null;
	private TextField getUserInput() {
		if( this.userInput == null) {
			this.userInput = new TextField("hugo");
		}
		return this.userInput;
	}
	private TextField URLInput = null;
	private TextField getURLInput() {
		if( this.URLInput == null) {
			this.URLInput = new TextField( this.URLInputText );
		}
		return this.URLInput;
	}
	private Button clientConnectCommand = null;
	private Button getClientConnectCommand() {
		if( this.clientConnectCommand == null) {
			this.clientConnectCommand = new Button("Connect");
			this.clientConnectCommand.setMinWidth(Region.USE_PREF_SIZE);
			this.clientConnectCommand.setMaxWidth(Region.USE_PREF_SIZE);
			this.clientConnectCommand.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Main.this.connectClientAction();					
				}
			});
		}
		return clientConnectCommand;
	}
	private ListView<ConnectionMaster> clientList = null;
	private ListView<ConnectionMaster> getClientList() {
		if( this.clientList == null) {
			this.clientList = new ListView<ConnectionMaster>();
			this.clientList.setItems( this.clients );
			this.clientList.setFocusTraversable(false);
		}
		return this.clientList;
	}
	private ListView<RemoteServerMaster> serverList;
	private ListView<RemoteServerMaster> getServerList() {
		if( this.serverList == null) {
			this.serverList = new ListView<RemoteServerMaster>();
			this.serverList.setItems( this.servers );
			this.serverList.setFocusTraversable(false);
		}
		return serverList;
	}
	private Label statusBar = null;
	private Label getStatusBar() {
		if( this.statusBar == null) {
			this.statusBar = new Label("   ");
		}
		return this.statusBar;
	}
	private Label pwLabel = null;	
	private Label getPWLabel() {
		if( this.pwLabel == null) {
			this.pwLabel = new Label("Password:");
		}
		return this.pwLabel;
	}
	private PasswordField ASPasswordInput = null;
	private PasswordField getASPasswordInput() {
		if( this.ASPasswordInput == null) {
			this.ASPasswordInput = new PasswordField();			
			this.ASPasswordInput.setText("hugo");
		}
		return this.ASPasswordInput;
	}
	@Override
	public void reportCurrentCacheSize(final int size, final long recycledICProxies) {
		Platform.runLater( new Runnable() {
			@Override
			public void run() {
				Main.this.getCacheSizeLabel().setText(new Integer(size).toString());
				Main.this.getRecycledLabel().setText( new Long(recycledICProxies).toString());
			}
		});
	}
	private Label recycledLabel = null;
	private Label getRecycledLabel() {
		if( this.recycledLabel == null) this.recycledLabel = new Label("0");
		return this.recycledLabel;
	}
	private Label cacheSizeLabel = null;
	private Label getCacheSizeLabel() {
		if( this.cacheSizeLabel == null) this.cacheSizeLabel = new Label("0");
		return this.cacheSizeLabel;
	}
} 


class StatusBarResetterFX implements Runnable{

  private static final long Delay = 10000;
  private Label statusBar;

  public StatusBarResetterFX(Label statusBar) {
	this.statusBar = statusBar;
  }

  public void run() {
	synchronized(this){
	  try{
		this.wait(Delay);
		Platform.runLater( new Runnable() {
			public void run() {
				StatusBarResetterFX.this.statusBar.setText("   ");
			}	
		});
	  }catch(InterruptedException ie){
		return;
	  }
	}
  }
}
