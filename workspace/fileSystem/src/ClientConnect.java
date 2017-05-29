

import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import view.ModelException;

import viewClient.MainViewApplication;
import viewClient.ServerConnection;


public class ClientConnect extends Application {	
	
	private String url ="";

	public static void main(String[] args) {
		// FX: set font size on start
		launch( args ); 		  //start fx thread			  
	}
	
	private Image logoFHDW = null;
	private Image logoApp = null;
	private BorderPane rootPane = null;
	public void init(){
		List<String> parlist = this.getParameters().getRaw();
		this.url = ( parlist.size() >= 3 ? parlist.get(2) : "http://localhost");
		// TODO provide your own application icons		
		logoFHDW = new Image( this.getClass().getResourceAsStream("/viewResources/applicationLogo.jpg"));
		logoApp = new Image( this.getClass().getResourceAsStream("/viewResources/generatorLogo.jpg"));
		this.rootPane = new BorderPane();
        this.rootPane.setCenter( this.getLoginPanel() );
		this.getConnectButton().setDefaultButton( true);
	}

	private Scene loginScene = null;
	private Stage stage = null;
	public void start( Stage primaryStage ) throws Exception {
		this.stage = primaryStage;
		this.loginScene = new Scene( this.rootPane, 750, 200);	
		this.stage.setScene( this.loginScene );		
		this.getNameTextField().requestFocus();
		this.stage.setTitle("GOJA Client Connect");
		this.stage.getIcons().add( logoApp );
		this.stage.setOnCloseRequest( new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				Platform.exit();
			    System.exit(0);				
			}
		} );
		this.stage.sizeToScene();
		this.stage.centerOnScreen();
		this.stage.show();			
	}
	private GridPane loginPanel = null;
	private GridPane getLoginPanel() {
		if( this.loginPanel == null ) {
			this.loginPanel = new GridPane();
			this.loginPanel.setVgap( 10 );
			this.loginPanel.setHgap( 10 );
			this.loginPanel.setPadding( new Insets( 20, 10, 30, 20 ));
			this.loginPanel.getColumnConstraints().add( new ColumnConstraints(180) );
			this.loginPanel.getColumnConstraints().add( new ColumnConstraints(100) );
			this.loginPanel.getColumnConstraints().add( new ColumnConstraints(400) );
			this.loginPanel.add(new ImageView(logoFHDW), 0, 0, 1, 2);
			this.loginPanel.addColumn( 1, new Label( "Benutzername:"));
			this.loginPanel.addColumn( 2, this.getNameTextField());
			this.loginPanel.addColumn( 1, new Label( "Passwort:"));
			this.loginPanel.addColumn( 2, this.getPasswordTextField());
			this.loginPanel.addColumn( 2, this.getConnectButton() );
			this.loginPanel.add( this.getStatusLabel(), 1, 4, 2, 2 );
		}
		return this.loginPanel;
	}
	private TextField nameTextField = null;
	private TextField getNameTextField() {
		if( this.nameTextField == null) {
			this.nameTextField = new TextField();
		}
		return this.nameTextField;
	}
	private PasswordField passwordTextField = null;
	private PasswordField getPasswordTextField() {
		if( this.passwordTextField == null) {
			this.passwordTextField = new PasswordField();
		}
		return this.passwordTextField;
	}
	private Label statusLabel = null;
	private Label getStatusLabel(){
		if( this.statusLabel == null ){
			this.statusLabel = new Label("    ");
		}
		return this.statusLabel;
	}
	private Button connectButton = null;
	private Button getConnectButton() {
		if( this.connectButton == null) {
			this.connectButton = new Button( "Login" );
			this.connectButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle( ActionEvent event) {
					ClientConnect.this.connectClient();					
				}
			});
		}
		return this.connectButton;
	}
	
	protected void connectClient() {
		MainViewApplication view = new MainViewApplication();
		ServerConnection connection;
		try {
			connection = new ServerConnection( this.url, view, null );
			connection.connect( this.getNameTextField().getText(), 
								this.getPasswordTextField().getText(),
								false );
		}catch( ModelException me ){
			this.getStatusLabel().setText( me.getMessage());
			this.getStatusLabel().setTextFill( Color.RED );
			return;
		} catch ( java.net.MalformedURLException me ) {
			this.getStatusLabel().setText( me.getMessage());
			this.getStatusLabel().setTextFill( Color.RED );
			return;
		}
		view.setConnection( connection );
		view.setTitle( view.getTitle() + connection.getServerView().toString() );
		view.getIcons().add( logoApp);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		if (view.getWidth()  > bounds.getWidth())  view.setWidth(bounds.getWidth() - 20);
		if (view.getHeight() > bounds.getHeight()) view.setHeight(bounds.getHeight() - 20);
		view.sizeToScene();
		view.centerOnScreen();
		view.show();
		this.stage.hide();
		view.initializeConnection();
	}	
}