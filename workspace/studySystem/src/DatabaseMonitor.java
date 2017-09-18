

import java.util.Iterator;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import persistence.Connection;
import persistence.ConnectionHandler;

public class DatabaseMonitor extends Stage implements Runnable{

	protected ConnectionManagerWrapper selectedConnection;

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
		this.rootPane.setCenter( this.getConnectionList());
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
	private ListView<Object> connectionList = null;
	private ListView<Object> getConnectionList() {
		if( this.connectionList == null) {
			this.connectionList = new ListView<Object>(this.getConnectionListModel());
			this.connectionList.setOnMouseReleased(new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent event) {
					showDetails();
				}});
		}
		return connectionList;
	}
	protected void showDetails() {
		Platform.runLater(new Runnable() {
			public void run() {
				selectedConnection = (ConnectionManagerWrapper) getConnectionList().getSelectionModel().getSelectedItem();
				rootPane.setCenter(getDetailPanel(selectedConnection));
			}
		});
	}
	private BorderPane detailPanel = null;
	private BorderPane getDetailPanel(ConnectionManagerWrapper wrapper){
		if (this.detailPanel == null){
			this.detailPanel = new BorderPane();
			this.detailPanel.setCenter(this.getDetailList());
			this.detailPanel.setTop(this.getDetailToolPanel());
		}
		this.setInfo(wrapper.manager.getConnection());
		return this.detailPanel;
	}
	private ToolBar detailToolPanel = null;
	private ToolBar getDetailToolPanel() {
		if (this.detailToolPanel == null) {
			this.detailToolPanel = new ToolBar();
			this.detailToolPanel.getItems().add(this.getCloseButton());
			this.detailToolPanel.getItems().add(this.getClearButton());
		}
		return this.detailToolPanel;
	}
	private Button clearButton = null;
	private Button getClearButton(){
		if (this.clearButton == null){
			this.clearButton = new Button("Clear");
			this.clearButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					selectedConnection.manager.getConnection().clearOperationCallCounters();
					Platform.runLater(new Runnable() {
						public void run() {
							closeDetails();
						}
					});
				}
			});
		}
		return this.clearButton;
	}
	private void closeDetails() {
		this.rootPane.setCenter(getConnectionList());		
	}
	private void setInfo(Connection connection) {
		ObservableList<String> infos = FXCollections.observableArrayList();
		for (String currentInfo : connection.getOperationCounterInfos()) {
			infos.add(currentInfo);
		}
		this.getDetailList().setItems(infos);
	}
	private Button closeButton = null;
	private Button getCloseButton(){
		if (this.closeButton == null){
			this.closeButton = new Button("Close");
			this.closeButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Platform.runLater(new Runnable() {
						public void run() {
							closeDetails();
						}
					});
				}
			});
		}
		return this.closeButton;
	}
	private ListView<String> detailList = null;
	private ListView<String> getDetailList(){
		if (this.detailList == null){
			this.detailList = new ListView<String>();
		}
		return this.detailList;
	}
	
	private ObservableList<Object> connectionListModel = null;
	private ObservableList<Object> getConnectionListModel() {
		if (this.connectionListModel == null) {
			this.connectionListModel = FXCollections.observableArrayList();
		}
		return this.connectionListModel;
	}
	final Object waiter = new Object();
	public void run() {
		while (this.isShowing()){
			Platform.runLater(new Runnable() {
				public void run() {
					getConnectionListModel().clear();
					Iterator<ConnectionHandler> cons = ConnectionHandler.getConnections().iterator();
					if(!cons.hasNext()){
						hide();
						return;
					}
					while (cons.hasNext()){
						ConnectionHandler current = cons.next();
						getConnectionListModel().add(new ConnectionManagerWrapper(current));
					}
				}
			});
			synchronized(waiter){
				try {
					waiter.wait(3000);
				} catch (InterruptedException e) {
					hide();
					return;
				}
			}
		}
	}
	class ConnectionManagerWrapper {

		private ConnectionHandler manager;

		public ConnectionManagerWrapper(ConnectionHandler manager) {
			this.manager = manager;
		}
		public String toString(){
			return this.manager.getName() + ": " + new Long(this.manager.getConnection().getCommandCounter()).toString();
		}
	}

}
