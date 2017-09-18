

import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class DatabaseMonitor extends Stage implements Runnable{

	public DatabaseMonitor() {
		super( StageStyle.DECORATED);
		this.initialize();
	}
	public void startThread(){
		new Thread(this, "Database Monitor").start();
	}
	private BorderPane rootPane = null;
	private void initialize(){
		this.rootPane = new BorderPane();
		this.rootPane.setCenter( this.getScrollPane());
		this.setTitle("Database Monitor");
		Scene rootScene = new Scene( this.rootPane, 300, 200);		
		this.setScene( rootScene );
		this.sizeToScene();
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		double x = bounds.getWidth()  - 325;
		double y = bounds.getHeight() - 250;
		this.setX( x );
		this.setY( y );
	}		
	private ScrollPane scrollPane = null;
	private ScrollPane getScrollPane() {
		if( this.scrollPane == null) {
			this.scrollPane = new ScrollPane();
			this.scrollPane.setContent( this.getConnectionList());
			this.scrollPane.setFitToHeight(true);
			this.scrollPane.setFitToWidth( true);
		}
		return this.scrollPane;
	}
	private ListView<Object> connectionList = null;
	private ListView<Object> getConnectionList() {
		if( this.connectionList == null) {
			this.connectionList = new ListView<Object>();
		}
		return connectionList;
	}
	public void run() {
		synchronized(this){
			try {
				this.wait(5000);
			} catch (InterruptedException e) {
				Platform.runLater(new Runnable() {
					public void run() {
						hide();
					}
				});
				return;
			}
		}
		Platform.runLater(new Runnable() {			
			public void run() {
				hide();
			}
		});
		return;
	}
}
