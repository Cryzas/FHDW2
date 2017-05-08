package viewClient;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import view.*;

public class MainView extends Stage implements ExceptionAndEventHandler{

	private Thread statusbarResetter = new Thread();

	public static int currentFontSize = 12;

//	public static void changeFont(final Object component) { //ML: CF
//		//TODO change font size in FX
//	}

	public MainView() {
		super( StageStyle.DECORATED );
		this.initialize();
	}
	private Scene rootScene = null;
	public Scene getRootScene(){
		return rootScene;
	}
	private void initialize(){
		rootScene = new Scene( this.getRootPane(), 1200, 800);		
		this.setScene( rootScene );
		this.sizeToScene();
		this.getRootPane().prefHeightProperty().bind(rootScene.heightProperty());
		this.setTitle( "MainView: ");
		this.setOnCloseRequest( new EventHandler<WindowEvent>() {
			public void handle( WindowEvent event) {
				getConnection().refresherStop();
				performClose();
			}
		});
	}

	/* Shall be overridden, if special close action is needed */
	void performClose() {}

	private BorderPane rootPane = null;
	private BorderPane getRootPane() {
		if( this.rootPane == null ){
			this.rootPane = new BorderPane();
			this.rootPane.setBottom( this.getStatusBar() );   		
		}
		return this.rootPane;    	
	}	
	public void setConnection( ConnectionMaster connection ){
		ServerView server = (ServerView) connection.getServer();
		this.getRootPane().setCenter( this.getServerClientView( server ));
		this.getServerClientView().prefHeightProperty().bind( this.rootPane.heightProperty());
		this.getServerClientView().setConnection( connection );
		ConnectionIndex.getTheConnectionIndex().setConnection( this.getServerClientView(), connection );
		ConnectionIndex.getTheConnectionIndex().setConnection( this, connection);
	}
	public ServerConnection getConnection(){
        return this.getServerClientView().getConnection();
	}
	protected void setStatusbar( ModelException exception) {
System.out.println("setStatusbar e:" +exception.getMessage());		
		this.setStatusbar( Long.toString( exception.getErrorNumber()) + ": " + exception.getMessage());
	}
	protected void setStatusbar(String message) {
		this.getStatusBar().setVisible( true );
		this.getStatusBar().setText( message );
		if( this.statusbarResetter.isAlive()) this.statusbarResetter.interrupt();
		this.statusbarResetter = new Thread(new StatusBarResetterFX(this.statusBar));
		this.statusbarResetter.start();
	}
	public void handleException( ModelException e ){
		this.getStatusBar().setTextFill( Color.RED );		
		this.getStatusBar().setFont( Font.font( null, FontWeight.BOLD, -1));
System.out.println("handleException before setStatusbar e:" +e);		
		this.setStatusbar(e);
	}
	public void handleUserException( UserException exception) {
		this.getStatusBar().setTextFill( Color.RED );
		this.getStatusBar().setFont (Font.font( null, FontWeight.NORMAL, -1));
		this.setStatusbar(exception.getMessage());
	}
	public void handleOKMessage(String message){
		this.getStatusBar().setTextFill( Color.BLACK );
		this.getStatusBar().setFont (Font.font( null, FontWeight.NORMAL, -1));
		this.setStatusbar(message);
	}
	public void handleRefresh(){
		this.getServerClientView().handleRefresh();
	}
	public void initializeConnection(){
		this.getServerClientView().initializeConnection();
	}	
	private ServerClientView serverClientView = null;
	private ServerClientView getServerClientView( ServerView server) {
		if( this.serverClientView == null){
			this.serverClientView = new ServerClientView( this, server );
		}
		return this.serverClientView;
	}
	private ServerClientView getServerClientView(){
		return this.serverClientView;
	}	
	private Label statusBar = null;
	private Label getStatusBar() {
		if( this.statusBar == null) {
			this.statusBar = new Label("   ");
			this.statusBar.setVisible(false);
		}
		this.statusBar.setFont(Font.font( this.statusBar.getFont().getName(), FontWeight.NORMAL, -1)); 
		return this.statusBar;
	}
}

class StatusBarResetterFX implements Runnable{

  private static final long Delay = 10000;
  private Label statusBar = null;

  public StatusBarResetterFX( Label statusBar) {
	  this.statusBar = statusBar;
  }

  public void run() {
	synchronized(this){
	  try{
		this.wait(Delay);
		Platform.runLater( new Runnable() {
			public void run() {
				if( StatusBarResetterFX.this.statusBar != null ) StatusBarResetterFX.this.statusBar.setText("   ");
			}
		});
	  }catch(InterruptedException ie){
		return;
	  }
	}
  }
}
