package viewClient;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import view.FX.AbstractRegExpPanel;
import view.FX.RegExprPanel2;


import view.Anything;
import view.ModelException;
import view.objects.ViewObject;
import view.objects.ViewObjectInTree;
import view.objects.ViewRoot;
import common.DateAndTime;
import common.Fraction;
import common.RPCConstantsAndServices;

public abstract class Wizard extends Stage implements ValueTimestampMaster {
	private ExceptionAndEventHandler exceptionHandler;
	public Wizard( ExceptionAndEventHandler exceptionHandler) {
		super();
		if( exceptionHandler != null ) this.exceptionHandler = exceptionHandler;
		this.initialize();
	}
	public boolean isUpdatable(){
		return true;
	}

	public boolean checkAndSetOk(String value) throws ModelException{
		return this.check();
	}

	public ExceptionAndEventHandler getExceptionHandler() {
		return this.exceptionHandler;
	}
	public void showAndWait(){
		Platform.runLater(new Runnable() {
			public void run() {
				Wizard.super.showAndWait();
			}
		});
		Platform.runLater(new Runnable() {
			public void run() {
	            adjustSizes();
				if( getParametersPanel().getChildren().size() > 0 ){					
					((SelectionPanel)getParametersPanel().getChildren().get(0)).handleFocusGained();
					currentSelectionPanel = getParametersPanel().getChildren().get(0);
				}
			}
		});
	}
	protected void initialize() {
		this.initModality(Modality.APPLICATION_MODAL);
		this.setTitle( GUIConstants.NoTitle );
		Scene rootScene = new Scene( this.getRootPane() );
		this.setScene( rootScene);
		this.sizeToScene();
		this.getRootPane().prefWidthProperty().bind( rootScene.widthProperty());
		this.getOkButton().setDisable( true );
		this.check();
	}
	protected void adjustSizes() {
		Iterator<Node> parameterPanels =  getParametersPanel().getChildren().iterator();
		while( parameterPanels.hasNext()){
			SelectionPanel current = (SelectionPanel) parameterPanels.next();
			current.adjustPanelSize();
		}
	}
	private BorderPane rootPane = null;
	protected BorderPane getRootPane() {
		if( this.rootPane == null ){
			this.rootPane = new BorderPane();
			this.rootPane.setBottom( this.getToolBar() );   		
			this.rootPane.setCenter( this.getParametersPanel());
			Insets insets = new Insets(10);
			BorderPane.setMargin( this.getParametersPanel(), insets);			
			BorderPane.setMargin( this.getToolBar(), insets);	
		}
		return this.rootPane;    	
	}	
	private ToolBar toolBar = null;
	private ToolBar getToolBar() {
		if( this.toolBar == null) {
			this.toolBar = new ToolBar( this.getOkButton(), this.getMainCancelButton());
			if ( this.hasHelp() ) this.toolBar.getItems().add( this.getHelpButton() );
			this.toolBar.getItems().add( this.getStatusBar());
			HBox.setMargin( this.getStatusBar(), new Insets( 0, 10, 0, 30));
		}
		return this.toolBar;
	}
	private Button mainCancelButton = null;
	Button getMainCancelButton() {
		if( this.mainCancelButton == null){
			this.mainCancelButton = new Button( GUIConstants.CancelButtonText );
			this.mainCancelButton.setCancelButton( true );
			this.mainCancelButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					close();				
				}
			});
		}
		return mainCancelButton;
	}	
	protected abstract String checkCompleteParameterSet();
	
	protected abstract void handleDependencies(int i);

	protected abstract void addParameters();

	protected abstract void perform();

	private Node currentSelectionPanel;
	
	private AbstractBrowserPanel browserPanel;

	public void setPanel( AbstractBrowserPanel browserPanel ) {
		this.getStatusBar().setText("");
		this.browserPanel = browserPanel;
		this.getRootPane().setCenter( this.browserPanel );		
		this.sizeToScene();
		this.getOkButton().setDefaultButton(false);
		this.browserPanel.getDefaultButton().setDefaultButton(true);
		this.getMainCancelButton().setCancelButton(false);
		this.browserPanel.getCancelButton().setCancelButton(true);
		this.browserPanel.determineFirstFocus();	
	}

	public void resetPanel() {
		this.getRootPane().setCenter( this.getParametersPanel() );
		this.sizeToScene();
		this.getMainCancelButton().setCancelButton(true);
		this.setFocusTraversable(true);
        if( ! this.check() ) return;
		for (int i = 0; i < this.getParametersPanel().getChildren().size(); i++) {
			if( this.getParametersPanel().getChildren().get(i).equals(this.currentSelectionPanel) ){
				this.getOkButton().setDefaultButton(true);
				if( i == (this.getParametersPanel().getChildren().size() - 1)){
					this.getOkButton().requestFocus();
				} else {
					((SelectionPanel)this.getParametersPanel().getChildren().get(i+1)).handleFocusGained();
					this.currentSelectionPanel = this.getParametersPanel().getChildren().get(i+1);
				}
				break;
			}		
		}
//		focusOwner.impl_traverse(Direction.NEXT));		
//	    this.getFocusTraversalPolicy().getComponentAfter(this, this.focusOwner).requestFocusInWindow();
	}

	public void setFocusTraversable(boolean b) {
		this.getOkButton().setFocusTraversable(b);
		this.getMainCancelButton().setFocusTraversable(b);
	}

	protected boolean hasHelp(){
		java.net.URL in = this.getClass().getClassLoader().getResource(this.helpFileName);
		return in != null;
	};	
	private Button helpButton = null;
	private Button getHelpButton() {
		if (this.helpButton == null){
			this.helpButton = new Button();
			this.helpButton.setText( GUIConstants.HelpButtonText );
			this.helpButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					showHelp();
				}
			});
		}
		return this.helpButton;
	}
	protected String helpFileName = "helpText.help";
	protected void showHelp(){
		String contentString = "No help available";
		java.net.URL in = this.getClass().getClassLoader().getResource( this.helpFileName);
		java.net.URLConnection con;
		try {
			con = in.openConnection();
			InputStream content = (InputStream) con.getContent();
			DataInputStream reader = new DataInputStream(content);
			StringBuffer stringResult = new StringBuffer();
			try {
				while (true){
					byte next = reader.readByte();
					stringResult.append((char) next);
				}
			}catch(EOFException eof){}
			contentString = stringResult.toString();
		} catch (IOException e) {}
		this.getHelpTextArea().setText(contentString);		
		this.getHelpWindow().setX( this.getX());
		this.getHelpWindow().setY( this.getY());
        this.getHelpWindow().setMinHeight( this.getHeight());
        this.getHelpWindow().setMinWidth(  this.getWidth());
		this.getHelpWindow().show();
	}
	private Stage helpWindow = null;
	private Scene helpScene = null;
	private Stage getHelpWindow() {
		if( this.helpWindow == null){
			this.helpWindow = new Stage();
			this.helpScene = new Scene(this.getHelpWindowContentPane());
			this.helpWindow.setScene( this.helpScene );
			this.helpWindow.initModality( Modality.APPLICATION_MODAL);
			this.helpWindow.setTitle( GUIConstants.HelpTitle);
			this.helpWindow.focusedProperty().addListener(new ChangeListener<Boolean>() {
				public void changed( ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if( ! newValue.booleanValue()){
						helpWindow.hide();	
					}	
				}
			});
		}
		return this.helpWindow;
	}
	private BorderPane helpWindowContentPane = null;
	private BorderPane getHelpWindowContentPane() {
		if(this.helpWindowContentPane == null){
			this.helpWindowContentPane = new BorderPane();
			this.helpWindowContentPane.setCenter(this.getHelpTextArea());
		}
		return this.helpWindowContentPane;
	}
	private TextArea helpTextArea = null;
	private TextArea getHelpTextArea() {
		if(this.helpTextArea == null){
			this.helpTextArea = new TextArea();
			this.helpTextArea.setEditable(false);
			this.helpTextArea.setWrapText(true);
//			this.helpTextArea.setWrapStyleWord(true);
//			this.helpTextArea.setFont( this.getFont());
		}
		return this.helpTextArea;
	}
	private Label statusBar = null;
	protected Label getStatusBar() {
		if( this.statusBar == null){
			this.statusBar = new Label();
			this.statusBar.setTextFill( Color.RED );
			this.statusBar.setText(" ");
		}
		return this.statusBar;
	}
	private Button okButton = null;
	protected Button getOkButton() {
		if( this.okButton == null) {
			this.okButton = new Button();
			this.okButton.setDisable( true );
			this.okButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					perform();
					okButton.requestFocus();
				}
			});
		}
		return this.okButton;
	}

	private VBox parametersPanel = null;
	protected VBox getParametersPanel() {
		if( this.parametersPanel == null) {
			this.parametersPanel = new VBox( 6 );
			this.parametersPanel.prefWidthProperty().bind( this.getRootPane().widthProperty());
			this.addParameters();
		}
		return this.parametersPanel;
	}

	protected boolean check() {
		this.getStatusBar().setText("");
		boolean result = true;
		for( int i = 0; i < this.getParametersPanel().getChildren().size(); i++) {
			SelectionPanel current = (SelectionPanel) this.getParametersPanel().getChildren().get(i);
			if (!current.check()){
				result = false;
			}
			this.handleDependencies(i);
		}
		if (result) {
			String checkComment = this.checkCompleteParameterSet();
			result = checkComment == null || checkComment.equals("");
			if (! result){
				this.getStatusBar().setText(checkComment);
			}
		}
		this.getOkButton().setDisable(!result);
		this.getOkButton().setDefaultButton(result);
		return result;
	}
	public ExceptionAndEventHandler getParent() {
		return this.getParent();
	}
}

abstract class SelectionPanel extends HBox {

	protected Wizard main;
	protected String parameterName;

	private SelectionPanel() {
		super(10);
		this.setAlignment(Pos.BASELINE_LEFT);
	}
	
	abstract public void handleFocusGained();

	abstract protected void adjustNettoPanelSize( double width );
	
	protected void adjustPanelSize(){
		double widthLabel = this.getParameterNameLabel().getWidth();
	    double widthWithoutLabel = this.getWidth() - widthLabel;	
	    this.getParameterNameLabel().setPrefWidth( widthLabel);
	    this.adjustNettoPanelSize( widthWithoutLabel );	
	}
	SelectionPanel( String parameterName, Wizard main) {
		this();
		this.main = main;
		this.parameterName = parameterName;
		this.prefWidthProperty().bind( main.getParametersPanel().widthProperty() );
		this.getChildren().add( this.getParameterNameLabel());
	}
	private Label parameterNameLabel = null;
	private Label getParameterNameLabel() {
		if( this.parameterNameLabel == null) {
			this.parameterNameLabel = new Label( this.parameterName + ":");
			this.parameterNameLabel.setMinWidth(USE_PREF_SIZE);
			this.parameterNameLabel.setMaxWidth(USE_PREF_SIZE);	
			this.parameterNameLabel.setFocusTraversable(false);
		}
		return this.parameterNameLabel;
	}
	abstract protected Object getResult();
	abstract boolean check();
	abstract protected void browse();
	void preset( Fraction value ){}
	void preset( long value ){}
	void preset( java.util.Date value ){}
	void preset( String value ){}
	void preset( java.util.Vector<?> value ){}
	void preset( Anything value ){}
	
	protected void setOk( final boolean b) {
		Platform.runLater(new Runnable() {
			public void run() {
				getParameterNameLabel().setTextFill(b ? Color.BLACK : Color.RED );				
			}
		});
	}
}

abstract class SimpleSelectionPanel extends SelectionPanel {

	SimpleSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}

	@Override
	protected void adjustNettoPanelSize( double width) {
		// simple panels do not need adjustments
	}
	
}

class IntegerSelectionPanel extends SimpleSelectionPanel {

	private Long result;
	
	IntegerSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.getChildren().add( this.getIntegerInputTextField());
	}

	private TextField integerInputTextField = null;
	protected TextField getIntegerInputTextField() {
		if( this.integerInputTextField == null) {
			this.integerInputTextField = new TextField("0");
			HBox.setHgrow( this.integerInputTextField, Priority.ALWAYS);
			this.integerInputTextField.setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					main.check();
				}
			});
		}
		return integerInputTextField;
	}

	boolean check() {
		boolean resultValue = false;
		try {
			result = Long.parseLong(getIntegerInputTextField().getText());
			resultValue = true;
		} catch (NumberFormatException nfe) {}
		this.setOk(resultValue);
		return resultValue;
	}

	protected Long getResult() {
		return result;
	}
	void preset(long value){
		this.getIntegerInputTextField().setText(new Long(value).toString());
	}
	void preset(String value){
		this.getIntegerInputTextField().setText(value);
	}
	protected void browse() {}

	@Override
	public void handleFocusGained() {
		this.getIntegerInputTextField().requestFocus();
	}


}

abstract class UserIntegerSelectionPanel extends IntegerSelectionPanel {
	UserIntegerSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}
	abstract boolean userCheck();
}


class FractionSelectionPanel extends SimpleSelectionPanel {

	private Fraction result;
	
	FractionSelectionPanel(String parameterName, Wizard main) {
		super( parameterName, main );
		this.getChildren().add( this.getFractionInputTextField());
	}

	private TextField fractionInputTextField = null;
	protected TextField getFractionInputTextField() {
		if( this.fractionInputTextField == null) {
			this.fractionInputTextField = new TextField("0" );
			HBox.setHgrow(this.fractionInputTextField, Priority.ALWAYS);
			this.fractionInputTextField.setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					main.check();
				}
			});
		}
		return fractionInputTextField;
	}

	boolean check() {
		boolean resultValue = false;
		try {
			result = Fraction.parse(getFractionInputTextField().getText());
			resultValue = true;
		} catch (NumberFormatException nfe) {}
		this.setOk(resultValue);
		return resultValue;
	}

	protected Fraction getResult() {
		return result;
	}
	void preset( String value){
		this.getFractionInputTextField().setText(value);
	}
	void preset(Fraction value){
		this.getFractionInputTextField().setText( value.toString());
	}
	protected void browse() {}

	@Override
	public void handleFocusGained() {
		this.getFractionInputTextField().requestFocus();
	}

}

abstract class UserFractionSelectionPanel extends FractionSelectionPanel {
	UserFractionSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}
	abstract boolean userCheck();
}


class StringSelectionPanel extends SimpleSelectionPanel {

	StringSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.getChildren().add(getStringInputTextField());
	}

	private TextField stringInputTextField = null;
	protected TextField getStringInputTextField() {
		if( this.stringInputTextField == null) {
			this.stringInputTextField = new TextField("");
			HBox.setHgrow(this.stringInputTextField, Priority.ALWAYS);
			this.stringInputTextField.setOnKeyReleased(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					main.check();					
				}
			});
		}
		return this.stringInputTextField;
	}
	
	boolean check() {
		this.setOk(true);
		return true;
	}

	protected String getResult() {
		return getStringInputTextField().getText();
	}
	void preset(String value){
		this.getStringInputTextField().setText(value);
	}
	protected void browse() {}

	@Override
	public void handleFocusGained() {
		this.getStringInputTextField().requestFocus();
	}

}


abstract class UserStringSelectionPanel extends StringSelectionPanel {
	UserStringSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}

	boolean standardCheck(){
		return super.check();
	}

	abstract boolean userCheck();
}

class PasswordSelectionPanel extends SimpleSelectionPanel {

	PasswordSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.getChildren().add(getPasswordInputTextField());
	}

	private PasswordField passwordInputTextField = null;
	private PasswordField getPasswordInputTextField() {
		if( this.passwordInputTextField == null) {
			this.passwordInputTextField = new PasswordField();
			this.passwordInputTextField.setText("");
			HBox.setHgrow(this.passwordInputTextField, Priority.ALWAYS);
			this.passwordInputTextField.setOnKeyReleased(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					main.check();					
				}
			});
		}	
		return this.passwordInputTextField;
	}

	boolean check() {
		this.setOk(true);
		return true;
	}

	protected String getResult() {
		return this.getPasswordInputTextField().getText();
	}
	void preset(String value){
		this.getPasswordInputTextField().setText(value);
	}
	protected void browse() {}

	@Override
	public void handleFocusGained() {
		this.getPasswordInputTextField().requestFocus();
	}

}

abstract class UserPasswordSelectionPanel extends PasswordSelectionPanel {
	UserPasswordSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}

	abstract boolean userCheck();
}

class DateSelectionPanel extends SimpleSelectionPanel {

	private java.util.Date result;
	
	DateSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.getChildren().add(this.getDateInputTextField());
	}
	private DatePicker datePickerField = null;
	protected DatePicker getDateInputTextField(){
		if( this.datePickerField == null) {
			this.datePickerField = new DatePicker( LocalDate.now());
			this.datePickerField.getEditor().setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					main.check();					
				}
			});
			this.datePickerField.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					main.check();					
				}
			});
		}
		return this.datePickerField;
	}

	boolean check() {
		boolean isResultOk = false;
		try {
			String dateInputAsText = this.getDateInputTextField().getEditor().getText();
			if( dateInputAsText.length() > 0){				
				result = DateAndTime.parseDate(dateInputAsText);
				isResultOk = true;
			} else if( this.getDateInputTextField().getValue() != null){
				result = java.util.Date.from(this.getDateInputTextField().getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());								
				isResultOk = true;
			}			
		} catch (java.text.ParseException pe) {}
		this.setOk(isResultOk);
		return isResultOk;
	}
	protected java.util.Date getResult() {
		return this.result;
	}
	void preset(java.util.Date value){
		Instant instant = value.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		LocalDate preset = zdt.toLocalDate();
		this.getDateInputTextField().setValue( preset);
	}
	void preset(String value){
		this.getDateInputTextField().getEditor().setText(value);
	}

	protected void browse() {}

	@Override
	public void handleFocusGained() {
		this.getDateInputTextField().requestFocus();
	}
}

abstract class UserDateSelectionPanel extends DateSelectionPanel {
	UserDateSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}

	abstract boolean userCheck();
}

class TimestampSelectionPanel extends SimpleSelectionPanel{
	
	private int partsPerHour;
	private int startHour;
	private int endHour;

	TimestampSelectionPanel( String parameterName, Wizard main) {
		this(parameterName, main, DateAndTime.PARTS_PER_HOUR, DateAndTime.HOUR_START, DateAndTime.HOUR_END);
	}

	TimestampSelectionPanel(String parameterName, Wizard main, int partsPerHour, int startHour, int endHour) {
		super(parameterName, main);
		if(this.parameterName != null){			
			this.partsPerHour = partsPerHour;
			this.startHour = startHour;
			this.endHour = endHour;
		}
		this.getChildren().add( this.getPanel());
		this.getPanel().prefWidthProperty().bind( main.widthProperty());
	}
	
	private ValueTimestampPanel panel;
	protected ValueTimestampPanel getPanel() {
		if( this.panel == null){
			this.panel = new ValueTimestampPanel( this.main, this.partsPerHour, this.startHour, this.endHour );
			this.panel.setComponentEditable();
		}
		return panel;
	}

	@Override
	boolean check() {
		if( this.getPanel().check() ){
			this.setOk( true );
			return true;
		}
		this.setOk(false);
		return false;
	}

	@Override
	protected java.util.Date getResult() {
		return this.getPanel().getResult();
	}
	
	@Override
	void preset( java.util.Date value){
		this.getPanel().setComponentValue( value);
	}

	@Override
	void preset( String value){
		this.getPanel().setComponentValue( value);
	}

	@Override
	protected void browse() {
	}

	@Override
	public void handleFocusGained() {
		this.getPanel().handleFocusGained();
	}
}
class TimestampSelectionPanel2 extends SimpleSelectionPanel {

	private java.util.Date result;
	private LocalDate date = null;
	private LocalTime time = null;

	private int partsPerHour = 12;  // determines delta in seconds if param not correct
	private int delta = 3600/this.partsPerHour;
	private int hourStart = 0;      // inclusive, range 0-24
	private int hourEnd = 24;       // exclusive, range 0-24
	
	TimestampSelectionPanel2(String parameterName, Wizard main, int partsPerHour) {
		super(parameterName, main);
		if( partsPerHour > 0 && partsPerHour <= 3600){			
			this.partsPerHour = partsPerHour;
			this.delta = 3600/partsPerHour;
		}
		this.date = LocalDate.now();
		this.time = LocalTime.now();
		this.getChildren().add( this.getDateInputField());
		this.getChildren().add( this.getTimeInputField());
		this.getChildren().add( this.getTimeSlider());
		this.setTimeInputField( this.time.getHour(), this.time.getMinute(), 0);
	}
	private Slider timeSlider = null;
	protected Slider getTimeSlider() {
		if( this.timeSlider == null){
			this.timeSlider = new Slider(this.hourStart*this.partsPerHour, (this.hourEnd*this.partsPerHour)- 1, 
			this.calcFractions(this.time.getHour(), this.time.getMinute(), this.time.getSecond()));			
			HBox.setHgrow(this.timeSlider, Priority.ALWAYS);
			String tip = "Zeiteinstellung\n auch mit links-/rechts-Navigation";
			this.timeSlider.setTooltip(new Tooltip(tip));
			this.timeSlider.setOnMouseDragged(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					time = LocalTime.ofSecondOfDay(((long) (timeSlider.getValue())*delta));
					setTimeInputField( time.getHour(), time.getMinute(), time.getSecond());
					main.check();
				}
			});
			this.timeSlider.setOnKeyPressed(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if( event.getCode() == KeyCode.RIGHT ) {
						time = time.plusSeconds( delta );
					} else if (event.getCode() == KeyCode.LEFT){
						time = time.minusSeconds( delta );
					}
					Platform.runLater(new Runnable() {
						public void run() {
							timeSlider.setValue( calcFractions( time.getHour(), time.getMinute(), time.getSecond()));
							setTimeInputField( time.getHour(), time.getMinute(), 0);						
							main.check();	
						}
					});
				}
			});
		}
		return this.timeSlider;
	}
	private double calcFractions( int hour, int minute, int second ){
		int totalSeconds = (hour*60+minute)*60 + second;
		return totalSeconds/delta + (totalSeconds%delta > 0 ? 1 : 0);
	}
	
	private DatePicker datePickerField = null;
	protected DatePicker getDateInputField(){
		if( this.datePickerField == null) {
			this.datePickerField = new DatePicker( this.date );
			this.datePickerField.setEditable(true);
			HBox.setHgrow(this.datePickerField, Priority.NEVER);
			this.datePickerField.getEditor().setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					main.check();					
				}
			});
			this.datePickerField.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					main.check();					
				}
			});
		}
		return this.datePickerField;
	}

	private TextField timeInputField = null;
	protected TextField getTimeInputField() {
		if( this.timeInputField == null ) {
			this.timeInputField = new TextField();
			this.timeInputField.setPrefWidth(100);
			this.timeInputField.setOnKeyReleased(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					try{						
						time = LocalTime.parse(timeInputField.getText());
						getTimeSlider().setValue(calcFractions(time.getHour(), time.getMinute(), time.getSecond()));
					} catch (DateTimeParseException e){	}
					main.check();					
				}
			});
		}
		return this.timeInputField;
	}

	protected void setTimeInputField( int hours, int minutes, int seconds) {
		Temporal temporal =  LocalTime.of( hours, minutes, seconds);
		this.getTimeInputField().setText( temporal.toString());							
	}
	
	boolean check() {
		boolean isResultOk = false;
		try {
			String dateInputAsText = this.getDateInputField().getEditor().getText();
			if( dateInputAsText.length() > 0){				
				result = DateAndTime.parseDate(dateInputAsText);
				isResultOk = true;
			} else if( this.getDateInputField().getValue() != null){
				result = java.util.Date.from(this.getDateInputField().getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
				isResultOk = true;
			}			
		} catch (java.text.ParseException pe) {}
		if(isResultOk){
			try{				
				this.time = LocalTime.parse( this.getTimeInputField().getText());
				result.setTime( result.getTime() + this.time.toSecondOfDay()*1000);
			} catch (DateTimeParseException pe) {
				isResultOk = false;
			}			
		}
		this.setOk(isResultOk);
		return isResultOk;
	}
	protected java.util.Date getResult() {
		return this.result;
	}
	void preset( java.util.Date value){
//System.out.println("preset Date " + value);		
		Instant instant = value.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		LocalDate presetDate = zdt.toLocalDate();
		this.getDateInputField().setValue( presetDate);
		LocalTime presetTime = zdt.toLocalTime();
		this.setTimeInputField(presetTime.getHour(), presetTime.getMinute(), presetTime.getSecond());
	}
	void preset( String value){
//System.out.println("preset String " + value);		
		if( value != null ){
			if( value.length() == 0 ){
				this.getDateInputField().getEditor().setText( value);
				this.getTimeInputField().setText( value);
				
			} else {
				LocalDate date = LocalDate.parse(value );
				this.getDateInputField().setValue(date);
				LocalTime time = LocalTime.parse(value);
				this.setTimeInputField(time.getHour(), time.getMinute(), time.getSecond());
			}
		}
	}
	protected void browse() {}
	@Override
	public void handleFocusGained() {
		this.getDateInputField().requestFocus();
	}
}

abstract class UserTimestampSelectionPanel extends TimestampSelectionPanel {
	UserTimestampSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}
	abstract boolean userCheck();
}

class TextSelectionPanel extends SelectionPanel {

	private String originalText = "";
	
	TextSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.getChildren().add( this.getTextViewTextField());
		this.getChildren().add( this.getEditButton());
		this.getChildren().add( this.getOpenFileButton());
		this.getEditButton().requestFocus();
	}
	private Button openFileButton = null;
	private Button getOpenFileButton() {
		if( this.openFileButton == null){
			this.openFileButton = new Button(GUIConstants.OpenTextButtonText);
			this.openFileButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					main.getOkButton().setDefaultButton( false );
					main.getMainCancelButton().setCancelButton( false );				
					FileChooser chooser = new FileChooser();
					chooser.getExtensionFilters().addAll( new ExtensionFilter("Text Files", "*.txt")
													    , new ExtensionFilter("All Files", "*.*"));							
					
					File file = chooser.showOpenDialog(main.getOwner());
					if( file != null ){
						try {
							int size = (int) file.length();
							int chars_read = 0;
							FileReader in = new FileReader(file);
							char[] data = new char[size];
							while (in.ready()) {
								chars_read += in.read(data, chars_read, size - chars_read);
							}
							in.close();
							setText(new String(data, 0, chars_read));
						} catch (FileNotFoundException fnfe) {
							main.getStatusBar().setText( GUIConstants.FileDoesNotExistText + file);
						} catch (IOException ioe) {
							main.getStatusBar().setText( ioe.getMessage());
						}										
					}
					main.resetPanel();
				}
			});
		}
		return this.openFileButton;
	}
	private Button editButton = null;
	private Button getEditButton() {
		if( this.editButton == null){
			this.editButton = new Button( GUIConstants.EditTextButtonText);
			this.editButton.setMinWidth(USE_PREF_SIZE);
			this.editButton.setMaxWidth(USE_PREF_SIZE);
			this.editButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					main.getOkButton().setDefaultButton(false);
					main.getMainCancelButton().setCancelButton(false);
					browse();
				}
			});
		}
		return this.editButton;
	}
	protected AbstractBrowserPanel getTextEditPanel() {
		return new TextEditPanel(this.main, this, this.parameterName, this.originalText);
	}
	private TextField stringInputTextField = null;
	protected TextField getTextViewTextField() {
		if( this.stringInputTextField == null) {
			this.stringInputTextField = new TextField("");
			HBox.setHgrow(this.stringInputTextField, Priority.ALWAYS);
			this.stringInputTextField.setFocusTraversable(false);
			this.stringInputTextField.setDisable(true);
		}
		return stringInputTextField;
	}

	boolean check() {
		boolean ok = false;
		if(this.stringInputTextField.getText().length() > 0) ok = true;
		this.setOk(ok);
		return ok;
	}
	protected String getResult() {
		return this.originalText;
	}
	public void setText(String text) {
		this.originalText = text;
		this.getTextViewTextField().setText(text);
		this.getTextViewTextField().home();
	}
	void preset(String value){
		this.originalText = value;
		this.getTextViewTextField().setText(value);
	}
	protected void browse() {
		this.main.setPanel( this.getTextEditPanel());
	}

	@Override
	protected void adjustNettoPanelSize(double width) {
		this.getEditButton().setPrefWidth(this.getEditButton().getWidth());
	}
	@Override
	public void handleFocusGained() {
		this.getEditButton().requestFocus();
	}
}


abstract class UserTextSelectionPanel extends TextSelectionPanel {
	UserTextSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}

	abstract boolean userCheck();
}

class ObjectSelectionPanel extends SelectionPanel {

	private Anything selected = null;
	private String typeName;
	protected ViewRoot navigationRoot;

	ObjectSelectionPanel(String parameterName, String typeName,
			ViewRoot navigationRoot, Wizard main) {
		super(parameterName, main);
		this.typeName = typeName;
		this.navigationRoot = navigationRoot;
		this.getChildren().add( this.getSelectedObject());
		this.getChildren().add( this.getBrowseButton());
	}
	private Button browseButton = null;
	private Button getBrowseButton() {
		if( this.browseButton == null) {
			this.browseButton = new Button( GUIConstants.BrowseButtonText);
			this.browseButton.setMinWidth( USE_PREF_SIZE);
			this.browseButton.setMaxWidth( USE_PREF_SIZE);
			this.browseButton.setDisable( this.navigationRoot == null);
			this.browseButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					browse();					
				}
			});
		}
		return browseButton;
	}
	protected void browse() {
		this.main.setPanel( this.getBrowserPanel());
		this.main.setFocusTraversable(false);
	}
	private BrowserPanel getBrowserPanel() {
		return new BrowserPanel( this.main, this, this.parameterName, this.typeName, this.getBrowserRoot());
	}
	protected ViewRoot getBrowserRoot() {
		return this.navigationRoot;
	}
	protected void setBrowserRoot(ViewRoot navigationRoot){
		if( this.navigationRoot == null || navigationRoot == null || !this.navigationRoot.equals(navigationRoot)){
			this.setSelectedObject(null);
			this.navigationRoot = navigationRoot;
			this.getBrowseButton().setDisable( this.navigationRoot == null);
		}
	}
	private TextField selectedObject = null;
	private TextField getSelectedObject() {
		if( this.selectedObject == null) {
			this.selectedObject = new TextField();
			this.selectedObject.setText( GUIConstants.NullRepresentation);
			HBox.setHgrow(this.selectedObject, Priority.ALWAYS);
			this.selectedObject.setEditable(false);
			this.selectedObject.setFocusTraversable(false);
		}
		return this.selectedObject;
	}
	
	@Override
	protected void adjustNettoPanelSize( double width) {
		this.getBrowseButton().setPrefWidth( this.browseButton.getWidth());
	}

	boolean check() {
		boolean resultValue = selected != null;
		this.setOk(resultValue);
		return resultValue;
	}
	public void setSelectedObject(Anything selected) {
		this.selected = selected;
		this.getSelectedObject().setText(selected == null ? GUIConstants.NullRepresentation : selected.toString());
		if (selected != null && this.check()){
			this.main.check();
		}
	}
	protected Anything getResult() {
		return this.selected;
	}
	void preset(Anything value){
		this.setSelectedObject(value);
	}
	@Override
	public void handleFocusGained() {
		this.getBrowseButton().requestFocus();
	}
}

abstract class UserObjectSelectionPanel extends ObjectSelectionPanel {
	UserObjectSelectionPanel(String parameterName, String typeName, ViewRoot treeModel, Wizard main) {
		super(parameterName, typeName, treeModel, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	abstract boolean userCheck();
}


class ObjectCollectionSelectionPanel extends SelectionPanel {

	private String typeName;
	protected ViewRoot navigationRoot;
	protected ObservableList<ViewObjectInTree> selectedObjects = FXCollections.observableArrayList();
	private boolean multiSelection = false;

	ObjectCollectionSelectionPanel( String parameterName, String typeName, ViewRoot navigationRoot, Wizard main, boolean multiSelection) {
		super(parameterName, main);
		this.typeName = typeName;
		this.navigationRoot = navigationRoot;
		this.multiSelection = multiSelection;
		this.getChildren().add( this.getSelectedObjects());
		this.getChildren().add( this.getNumberLabel());
		this.getChildren().add( this.getBrowseButton());
	}
	private Label numberLabel = null;
	private Label getNumberLabel(){
		if( this.numberLabel == null){
			this.numberLabel = new Label("0");
			this.numberLabel.setAlignment( Pos.BASELINE_RIGHT);
			this.numberLabel.setMinWidth( USE_PREF_SIZE);
			this.numberLabel.setMaxWidth( USE_PREF_SIZE);
		}
		return this.numberLabel;
	}	
	private ComboBox<ViewObjectInTree> selectedObjectsBox = null;
	private ComboBox<ViewObjectInTree> getSelectedObjects() {
		if( this.selectedObjectsBox == null) {
			this.selectedObjectsBox = new ComboBox<ViewObjectInTree>();
			HBox.setHgrow(this.selectedObjectsBox, Priority.ALWAYS);
			this.selectedObjectsBox.setMaxWidth(Double.MAX_VALUE);
			this.selectedObjectsBox.setItems( this.selectedObjects );
			this.selectedObjects.addListener( new ListChangeListener<ViewObjectInTree>() {
				public void onChanged(
					javafx.collections.ListChangeListener.Change<? extends ViewObjectInTree> c) {
					numberLabel.setText( Integer.toString( selectedObjects.size()));
					if( selectedObjects.size() > 0 )
						selectedObjectsBox.getSelectionModel().select(0);
					else 
						selectedObjectsBox.getSelectionModel().clearSelection();
				}
			});
			this.selectedObjectsBox.setEditable(false);
			this.selectedObjectsBox.setFocusTraversable( false );
		}
		return selectedObjectsBox;
	}
	
	@Override
	protected void adjustNettoPanelSize( double nettoWidth) {
		this.getNumberLabel().setPrefWidth( this.getNumberLabel().getWidth() *4 );
		this.getBrowseButton().setPrefWidth(this.getBrowseButton().getWidth());
	}

	private Button browseButton = null;
	private Button getBrowseButton() {
		if( this.browseButton == null) {
			this.browseButton = new Button( GUIConstants.BrowseButtonText);
			this.browseButton.setDisable( this.navigationRoot == null );
			this.browseButton.setMinWidth( USE_PREF_SIZE);
			this.browseButton.setMaxWidth( USE_PREF_SIZE);
			this.browseButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					browse();
				}
			});
		}
		return this.browseButton;
	}

	protected void browse() {
		this.main.setPanel( this.getBrowserPanel());
	}

	private CollectionBrowserPanel getBrowserPanel() {		
		return new CollectionBrowserPanel( this.main, this, this.parameterName, this.typeName, this.getBrowserRoot(), this.multiSelection);
	}

	protected ViewRoot getBrowserRoot() {
		return this.navigationRoot;
	}

	boolean check() {
		this.setOk(true);
		return true;
	}
	
	boolean check(Anything selected) {
		return true;
	}
	
	protected Vector<?> getResult() {
		Vector<Object> result = new Vector<Object>();
		result.addAll(  this.getSelectedObjects().getItems());
		return result;
	}
	
	void preset(java.util.Vector<?> value){
		java.util.Iterator<?> values = value.iterator();
		while (values.hasNext())
			this.getSelectedObjects().getItems().add((ViewObjectInTree) values.next());
	}
	
	protected void setBrowserRoot(ViewRoot navigationRoot){
		if (this.navigationRoot == null || navigationRoot == null || !this.navigationRoot.equals(navigationRoot)){
			this.getSelectedObjects().getItems().clear();
			this.navigationRoot = navigationRoot;
			this.getBrowseButton().setDisable( this.navigationRoot == null);
		}
	}

	@Override
	public void handleFocusGained() {
		this.getBrowseButton().requestFocus();
	}
}

abstract class UserObjectCollectionSelectionPanel extends ObjectCollectionSelectionPanel {
	UserObjectCollectionSelectionPanel(String parameterName, String typeName, ViewRoot navigationRoot, Wizard main, boolean multiSelection) {
		super(parameterName, typeName, navigationRoot, main, multiSelection);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	/** Check whole collection "this.getResult()" */
	abstract protected boolean userCheck();
	
	boolean check(Anything anything) {
		return this.userCheck(anything);
	}
	/** Check individual object that gets selected in the browser ">>>" */
	abstract protected boolean userCheck(Anything anything);	
}


abstract class AbstractBrowserPanel extends BorderPane{

	protected abstract void determineFirstFocus();
	protected abstract Button getCancelButton();
	protected abstract Button getDefaultButton();
	
};

class CollectionBrowserPanel extends AbstractBrowserPanel {

	private Wizard main;
	private ViewRoot navigationRoot;
	private ObjectCollectionSelectionPanel panel;
	
	private String parameterName;
	private String typeName;
	private boolean multiSelection = false;

	public CollectionBrowserPanel(Wizard main, ObjectCollectionSelectionPanel panel, String parameterName, String typeName, ViewRoot navigationRoot, boolean multiSelection) {
		super();
		this.main = main;
		this.panel = panel;
		this.parameterName = parameterName;
		this.navigationRoot = navigationRoot;
		this.typeName = typeName;
		this.multiSelection = multiSelection;
		this.initialize();
	}

	private void initialize() {
		this.setBottom( this.getToolBar());
		this.setCenter( this.getSplitPane());
		this.setPrefHeight( GUIConstants.StandardBrowserPanelHeight);
	}

	private SplitPane splitPane = null;
	private SplitPane getSplitPane() {
		if( this.splitPane == null) {
			this.splitPane = new SplitPane();
			this.splitPane.setOrientation( Orientation.HORIZONTAL);
			this.splitPane.getItems().addAll( this.getTreePanel(), this.getMoveListPanel() );	
			this.splitPane.setDividerPosition( 0, 0.45);
		}
		return splitPane;
	}
	private BorderPane moveListPanel = null;
	private BorderPane getMoveListPanel() {
		if( this.moveListPanel == null) {
			this.moveListPanel = new BorderPane();
			this.moveListPanel.setLeft( this.getMovePanel());
			this.moveListPanel.setCenter(this.getListPanel());
			this.moveListPanel.prefHeightProperty().bind( this.heightProperty());
		}
		return this.moveListPanel;
	}
	private TitledPane treePanel = null;
	private TitledPane getTreePanel() {
		if( this.treePanel == null) {
			this.treePanel = new TitledPane(GUIConstants.ChooseFromText, this.getTree());
			this.treePanel.setCollapsible(false);
			this.treePanel.prefHeightProperty().bind( this.heightProperty());
		}
		return this.treePanel;
	}
	private TitledPane listPanel = null;
	private TitledPane getListPanel() {
		if( this.listPanel == null) {
			this.listPanel = new TitledPane( this.parameterName, this.getList());
			this.listPanel.setCollapsible(false);
			this.listPanel.prefHeightProperty().bind( this.getMoveListPanel().heightProperty());
		}
		return this.listPanel;
	}
	private TreeRefresh tree = null;
	private TreeRefresh getTree() {
		if( this.tree == null) {
			this.tree = new TreeRefresh( this.main.getExceptionHandler());
			this.tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			this.tree.setModel( this.navigationRoot );
			this.tree.setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if( event.getCharacter().equals(">")) addSelectedItems();
				}
			});
		}
		return tree;
	}
	private ListView<ViewObjectInTree> list = null;
	private ListView<ViewObjectInTree> getList() {
		if( this.list == null) {
			this.list = new ListView<ViewObjectInTree>();
			this.list.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );
			this.list.setItems( this.panel.selectedObjects ); // list model of parent panel
		}
		return list;
	}
	private ToolBar toolBar = null;
	private ToolBar getToolBar() {
		if( this.toolBar == null) {
			this.statusbar = new Label("");
			this.toolBar = new ToolBar( 
					  this.statusbar
					, new Separator()  
					, this.getOKButton());
//			fillup.setPreferredSize(new Dimension(2000,10));
		}
		return this.toolBar;
	}
	private Label statusbar = null;	
	protected void setStatusbar(String wrongTypeMessage) {
		this.statusbar.setText( wrongTypeMessage);
	}

	private Button okButton = null;
	private Button getOKButton() {
		if( this.okButton == null) {
			this.okButton = new Button();
			this.okButton.setText( GUIConstants.OKButtonText);
			this.okButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					main.resetPanel();
				}
			});
		}
		return this.okButton;
	}
	private VBox movePanel = null;
	private VBox getMovePanel() {
		if( this.movePanel == null) {
			this.movePanel = new VBox();
			this.movePanel.setAlignment( Pos.CENTER );
			this.movePanel.getChildren().add( this.getAddButton());
			this.movePanel.getChildren().add( this.getRemoveButton());
		}
		return movePanel;
	}

	private Button addButton = null;
	private Button getAddButton() {
		if( this.addButton == null) {
			this.addButton = new Button();
			this.addButton.setText(">>>");
			this.addButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					addSelectedItems();
					getTree().getSelectionModel().clearSelection();
					getList().getSelectionModel().clearSelection();
				}
			});
		}
		return this.addButton;
	}
	private Button removeButton = null;
	private Button getRemoveButton() {
		if( this.removeButton == null) {
			this.removeButton = new Button();
			this.removeButton.setText("<<<");
			this.removeButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					panel.selectedObjects.removeAll( getList().getSelectionModel().getSelectedItems());
					getDefaultButton().setDefaultButton( true );
					getTree().getSelectionModel().clearSelection();
					getList().getSelectionModel().clearSelection();
				}
			});
		}
		return this.removeButton;
	}

	protected void addSelectedItems() {
		int numberOfErrors = 0;
		if( this.getTree().getSelectionModel().getSelectedItems().size() > 0) {
selectedLoop: for (int i = 0; i < getTree().getSelectionModel().getSelectedItems().size(); i++){
				ViewRoot selected = getTree().getSelectionModel().getSelectedItems().get(i).getValue().getWrappedObject();
				if(selected != null){
					try {
						if (Class.forName(typeName).isInstance(selected) && panel.check((Anything) selected)) {
							if (!this.multiSelection) {
								for (ViewObjectInTree current : panel.selectedObjects) {
									if(current.equals(selected) )
										continue selectedLoop;
								}
							}	
							panel.selectedObjects.add(selected);
						} else {
							numberOfErrors = numberOfErrors + 1;
						}
					} catch (ClassNotFoundException e1) {
						throw new Error("Type not found: " + typeName);
					}
				}
			}
		}
		if (numberOfErrors > 0) setStatusbar(GUIConstants.WrongTypeMessage + " " + numberOfErrors);
		else setStatusbar("");
		this.getDefaultButton().setDefaultButton(true);
	}

	@Override
	public void determineFirstFocus() {
		this.getTree().requestFocus();
	}

	@Override
	protected Button getDefaultButton() {
		return this.getOKButton();
	}

	private Button cancelButton = null;
	@Override
	public Button getCancelButton() {
		if (this.cancelButton == null) {
			this.cancelButton = new Button();
		}
		return this.cancelButton;
	}
}

class TextEditPanel extends AbstractBrowserPanel {
	private Wizard main;
	private TextSelectionPanel panel;
	private String text;

	TextEditPanel(Wizard main, TextSelectionPanel panel, String parameterName, String text){
		this.main = main;
		this.panel = panel;
		this.text = text;
// FX: Java 8u60: bug RT-40166 default button handling corrupt with usage of TitledPane		
//		TitledPane pane = new TitledPane(parameterName, this.getTextArea());
//		pane.setCollapsible(false);
//		this.setCenter( pane);
		this.setTop(    this.getParameterLabelBar(parameterName));
		this.setCenter( this.getTextArea());
		this.setBottom( this.getButtonPanel());
		BorderPane.setMargin( this.getBottom(), new Insets(10));
		this.prefWidthProperty().bind( main.widthProperty());
		this.setPrefHeight( GUIConstants.StandardBrowserPanelHeight);
	}
	private ToolBar parameterLabelBar = null;
	private ToolBar getParameterLabelBar( String parameterName ){
		if( this.parameterLabelBar == null){
			this.parameterLabelBar = new ToolBar( new Label( parameterName ));
		}
		return parameterLabelBar;		
	}	
	private HBox buttonPanel = null;
	private HBox getButtonPanel() {
		if( this.buttonPanel == null){
			this.buttonPanel = new HBox( 10 );
			this.buttonPanel.setAlignment( Pos.BASELINE_RIGHT);
			this.buttonPanel.getChildren().add( this.getOKButton());
			this.buttonPanel.getChildren().add( this.getCancelButton());
		}
		return buttonPanel;
	}
	private Button cancelButton = null;
	protected Button getCancelButton() {
		if( this.cancelButton == null){
			this.cancelButton = new Button();
			this.cancelButton.setText( GUIConstants.CancelButtonText);
			this.cancelButton.setCancelButton(true);
			this.cancelButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					cancelButton.setCancelButton(false);
					getOKButton().setDefaultButton(false);
					main.resetPanel();
				}
			});
		}
		return this.cancelButton;
	}
	private Button okButton = null;
	private Button getOKButton() {
		if( this.okButton == null){
			this.okButton = new Button();
			this.okButton.setText( GUIConstants.OKButtonText);
			this.okButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					panel.setText( getTextArea().getText() );
					okButton.setDefaultButton(false);
					getCancelButton().setCancelButton(false);
					main.resetPanel();
//					setVisible(false);
				}
			});
		}
		return this.okButton;
	}
	private TextArea textArea = null;
	private TextArea getTextArea() {
		if( this.textArea == null){
			this.textArea = new TextArea();
			this.textArea.setWrapText(true);
			this.textArea.setText( this.text);
		}
		this.textArea.home();
		this.textArea.setVisible(true);
		return this.textArea;
	}
	@Override
	public void determineFirstFocus() {
		this.getTextArea().requestFocus();
	}
	@Override
	protected Button getDefaultButton() {
		return this.getOKButton();
	}
}

class BrowserPanel extends AbstractBrowserPanel {

	private String 		typeName;
	private Wizard 		main;
	private ViewRoot 	navigationRoot;
	private ObjectSelectionPanel panel;
	private String		parameterName;

	BrowserPanel(Wizard main, ObjectSelectionPanel panel, String parameterName,
			String typeName, ViewRoot navigationRoot) {
		this.typeName = typeName;
		this.main = main;
		this.panel = panel;
		this.navigationRoot = navigationRoot;
		this.parameterName = parameterName;
		this.setTop(    this.getTitledFindPane());
		this.setCenter( this.getBrowserTree());
		this.setBottom( this.getButtonPanel());
		BorderPane.setMargin( this.getFindPanel(), new Insets(10));
		this.setPrefSize( main.getWidth(), GUIConstants.StandardBrowserPanelHeight);
	}
	private TitledPane titledFindPane = null;
	private TitledPane getTitledFindPane(){
		if( this.titledFindPane == null ){
			this.titledFindPane = new TitledPane(parameterName + " :: " + GUIConstants.ObjectSelectionHint, this.getFindPanel());
			this.titledFindPane.setCollapsible(false);
		}
		return this.titledFindPane;				
	}

	private HBox findPanel = null;
	private HBox getFindPanel() {
		if (this.findPanel == null) {
			this.findPanel = new HBox(8);
			this.findPanel.setAlignment( Pos.BASELINE_LEFT);
			this.findPanel.getChildren().add( new Label("Suchtext: "));
			this.findPanel.getChildren().add( this.getSearchTextInput());
			this.findPanel.getChildren().add( this.getPrevMatch());
			this.findPanel.getChildren().add( this.getNextMatch());
		}
		return this.findPanel;
	}
	private Button prevMatch = null;
	private Button getPrevMatch() {
		if( this.prevMatch == null){
			this.prevMatch = new Button("<<<");
			this.prevMatch.setDisable( true);
			this.prevMatch.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					currentMatchIndex = currentMatchIndex - 1;
					adjustTreeSelectionToMatch();
				}
			});
		}
		return this.prevMatch;
	}
	private Button nextMatch = null;
	private Button getNextMatch() {
		if( this.nextMatch == null){
			this.nextMatch = new Button(">>>");
			this.nextMatch.setDisable(true);
			this.nextMatch.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					currentMatchIndex = currentMatchIndex + 1;
					adjustTreeSelectionToMatch();
				}
			});
		}
		return this.nextMatch;
	}
	private TextField searchTextInput = null;
	private TextField getSearchTextInput() {
		if( this.searchTextInput == null){
			this.searchTextInput = new TextField();
			this.searchTextInput.setOnKeyReleased(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					adjustTreeSelection();					
				}
			});
		}
		return this.searchTextInput;
	}
	private int currentMatchIndex = 0;
	private List<TreeItem<ViewObjectInTree>> searchStringMatches = null;
	private List<TreeItem<ViewObjectInTree>> getSearchStringMatches(){
		if( this.searchStringMatches == null){
			this.searchStringMatches = new ArrayList<TreeItem<ViewObjectInTree>>();
		}
		return this.searchStringMatches;
	}
	protected void adjustTreeSelection() {
		this.clearMatches();
		String searchString = this.getSearchTextInput().getText();
        this.searchStringMatches = this.getBrowserTree().getMatchingItems(searchString);
		this.adjustTreeSelectionToMatch();
	}
	private void clearMatches(){
		this.getSearchStringMatches().clear();
		this.currentMatchIndex = 0;
	}
	private void adjustTreeSelectionToMatch() {
		if( this.getSearchStringMatches().size() > this.currentMatchIndex){
			final TreeItem<ViewObjectInTree> item = this.searchStringMatches.get(this.currentMatchIndex);
			this.getBrowserTree().getSelectionModel().select(item);
			this.getBrowserTree().scrollTo( getBrowserTree().getRow(item));			
		} else {
			this.getBrowserTree().getSelectionModel().clearSelection();
		}
		this.adjustNextPrevEnabling();
	}
	private void adjustNextPrevEnabling() {
		this.getNextMatch().setDisable( this.getSearchStringMatches().size() <= this.currentMatchIndex + 1);
		this.getPrevMatch().setDisable( this.currentMatchIndex == 0);
	}

	private ToolBar buttonPanel = null;
	private ToolBar getButtonPanel() {
		if( this.buttonPanel == null){
			this.buttonPanel = new ToolBar();
			this.buttonPanel.getItems().add( this.getStatusbar());
			this.buttonPanel.getItems().add( this.getOkButton());
			this.buttonPanel.getItems().add( this.getCancelButton());
		}
		return this.buttonPanel;
	}

	private Button okButton = null;
	private Button getOkButton() {
		if( this.okButton == null){
			this.okButton = new Button();
			this.okButton.setText( GUIConstants.OKButtonText);
			this.okButton.setDisable(true);
			this.okButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					trySelect();
				}
			});
		}
		return this.okButton;
	}

	private Button cancelButton = null;
	protected Button getCancelButton() {
		if( this.cancelButton == null){
			this.cancelButton = new Button();
			this.cancelButton.setText(GUIConstants.CancelButtonText);
			this.cancelButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					main.resetPanel();
				}
			});
		}
		return this.cancelButton;
	}

	private TreeRefresh browserTree = null;
	private TreeRefresh getBrowserTree() {
		if( this.browserTree == null) {
			this.browserTree = new TreeRefresh(this.main.getExceptionHandler());
			this.browserTree.prefHeightProperty().bind( main.heightProperty());
			this.browserTree.setModel( this.navigationRoot );
			this.browserTree.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<TreeItem<ViewObjectInTree>>(){
				public void onChanged(
					javafx.collections.ListChangeListener.Change<? extends TreeItem<ViewObjectInTree>> c) {
					tryActivateOkButton();															
				}				
			});
			this.browserTree.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					if (event.isAltDown()) {
						trySelect();
					} else {
						tryActivateOkButton();
						setStatusbar("");
					}				
				}
			});
			this.browserTree.getSelectionModel().select(0);
		}
		return browserTree;
	}

	protected void tryActivateOkButton() {
		SelectionModel<TreeItem<ViewObjectInTree>> sm = this.getBrowserTree().getSelectionModel();
		TreeItem<ViewObjectInTree> selected = sm.getSelectedItem();
		try {
			boolean disable = selected == null || !Class.forName(typeName).isInstance(selected.getValue().getWrappedObject());
			this.getOkButton().setDisable( disable );
			this.getOkButton().setDefaultButton(!disable);
		} catch (ClassNotFoundException e) {
			this.getOkButton().setDisable(true);
		}
	}

	protected void trySelect() {
			ViewRoot selected = this.getBrowserTree().getSelectionModel().getSelectedItem().getValue().getWrappedObject();
			if (selected != null) {
				try {
					if (Class.forName(typeName).isInstance(selected)) {
						panel.setSelectedObject((Anything)selected);
						main.resetPanel();
					} else {
						setStatusbar(GUIConstants.WrongTypeMessage);
					}
				} catch (ClassNotFoundException e1) {
					throw new Error("Type not found: " + typeName);
				}
			}
	}

	protected void setStatusbar(String message) {
		getStatusbar().setText(message);
	}

	private Label statusbar = null;
	private Label getStatusbar() {
		if( this.statusbar == null) {
			this.statusbar = new Label();
			this.statusbar.setTextFill(Color.RED);
		}
		return this.statusbar;
	}

	@Override
	public void determineFirstFocus() {
		this.getBrowserTree().requestFocus();
	}

	@Override
	protected Button getDefaultButton() {
		return this.getOkButton();
	}

}

final class NoDetailPanel extends DetailPanel {

	protected NoDetailPanel(ExceptionAndEventHandler exceptionHandler) {
		super(exceptionHandler);
		this.initialize();
	}

	private void initialize() {
		this.setCenter( this.getNoDetailsCenterHorizontal() );		
	}
	private FlowPane noDetailsCenterHorizontal = null;
	private FlowPane getNoDetailsCenterHorizontal() {
		if( this.noDetailsCenterHorizontal == null){
			this.noDetailsCenterHorizontal = new FlowPane();
			this.noDetailsCenterHorizontal.getChildren().add( new Pane());
			this.noDetailsCenterHorizontal.getChildren().add( this.getNoDetailsCenterVertical());
			this.noDetailsCenterHorizontal.getChildren().add( new Pane());
		}
		return this.noDetailsCenterHorizontal;
	}
	private FlowPane noDetailsCenterVertical = null;
	private FlowPane getNoDetailsCenterVertical() {
		if( this.noDetailsCenterVertical == null){
			this.noDetailsCenterVertical = new FlowPane( Orientation.VERTICAL );
			this.noDetailsCenterVertical.getChildren().add( new Pane());
			this.noDetailsCenterVertical.getChildren().add( new Label("No Details!!!"));
			this.noDetailsCenterVertical.getChildren().add( new Pane());
		}
		return this.noDetailsCenterVertical;
	}
	public void setAnything(Anything anything) {}
}


final class StandardDetailPanel extends DetailPanel {

	protected StandardDetailPanel(ExceptionAndEventHandler exceptionHandler) {
		super(exceptionHandler);
	}
	public void setAnything(Anything anything) {}	
}


class ReturnValueView extends Stage {
	private Scene rootScene = null;	
	private ReturnValueView( Dimension2D size, boolean text){
		super();
		this.initStyle( StageStyle.UNDECORATED);	
		this.getRootPane().setPrefSize( size.getWidth(), size.getHeight());
		this.rootScene = new Scene( this.getRootPane() );
		this.setScene( rootScene );
		this.sizeToScene();
		if( !text){
			this.focusedProperty().addListener(new ChangeListener<Boolean>() {
				public void changed( ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if( ! newValue.booleanValue()){   // window has lost the focus
						Platform.runLater(new Runnable() {
							public void run() {
								ReturnValueView.this.close();	
							}
						});
					}						
				}
			});
		}else{
			this.initModality(Modality.APPLICATION_MODAL);
			this.getRootPane().requestFocus();			
		}
	}
	
	private BorderPane rootPane = null;
	protected BorderPane getRootPane() {
		if( this.rootPane == null ){
			this.rootPane = new BorderPane();
			BorderStroke stroke = new BorderStroke( null, BorderStrokeStyle.SOLID, null, new BorderWidths(1));
			this.rootPane.setBorder( new Border(stroke));
		}
//		if( rootPane.getCenter() != null ){
//			Insets insets = new Insets( 10,30,10,20);
//			BorderPane.setMargin( rootPane.getCenter(), insets);
//		}
		return this.rootPane;    	
	}	

	ReturnValueView( String error, Dimension2D size){
		this( size, false );
		this.getRootPane().setPrefHeight( GUIConstants.ReturnValueSmallHeight );
		TextField tf = new TextField();
		tf.setBackground( new Background( new BackgroundFill( GUIConstants.ReturnValueBackgroundErrorColor, null, null)));
		tf.setFont( Font.font(tf.getFont().getFamily(), FontWeight.BOLD, tf.getFont().getSize() ) );
//		tf.setStyle("-fx-text-inner-color: " + GUIConstants.ReturnValueForegroundErrorColor.toString() + ";");
		tf.setStyle("-fx-text-inner-color: darkgreen;");
		tf.setText(error);
		this.getRootPane().setTop( tf );		
	}

	ReturnValueView( String result, boolean isText, Dimension2D size){
		this( size, isText );
		if( isText){
			final TextArea textArea = new TextArea();
			getRootPane().setBackground(new Background( new BackgroundFill(GUIConstants.ReturnValueBackgroundColorForText, null, null)));
			textArea.setOpacity(0.9);
			textArea.setWrapText( true);
			textArea.setEditable(false);
			textArea.setFocusTraversable(false);			
			this.getRootPane().setCenter(textArea);
			ToolBar textToolBar = new ToolBar();
			final Label statusBar = new Label(" ");
			final Button closeButton = new Button( GUIConstants.CloseTextButtonText );
			closeButton.setCancelButton( true);
			closeButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					close();					
				}
			});
			final Button saveButton = new Button( GUIConstants.SaveTextButtonText);
			saveButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					closeButton.requestFocus();					
					FileChooser chooser = new FileChooser();
					chooser.getExtensionFilters().addAll( new ExtensionFilter("Text", "*.txt")
							                            , new ExtensionFilter("Alle Dateien", "*.*"));
					File file = chooser.showSaveDialog( rootScene.getWindow());
					if( file != null ){
						if( file.exists() ){
							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setContentText(GUIConstants.SaveTextApproveText);
							Optional<ButtonType> result = alert.showAndWait();
							if( result.isPresent() && result.get() == ButtonType.CANCEL) {
								return;
							}
						}	
						try {
							FileWriter writer = new FileWriter(file);
							writer.write( textArea.getText());
							writer.close();
							statusBar.setText( file.toString());
						} catch (IOException ioe) {
							statusBar.setText( ioe.getMessage());							
						}
					}					
				}
			});
			textToolBar.getItems().add( saveButton);
			textToolBar.getItems().add( closeButton);
			textToolBar.getItems().add( statusBar);
			HBox.setMargin(statusBar, new Insets(0,10,0,30));
			this.getRootPane().setBottom( textToolBar);
			textArea.setText( result);
			saveButton.requestFocus();
		}else{
			this.getRootPane().setPrefHeight( GUIConstants.ReturnValueSmallHeight);
			TextField textField = new TextField();
			textField.setBackground( new Background(new BackgroundFill( GUIConstants.ReturnValueBackgroundColor, null, null)));
			textField.setText( result);
			this.getRootPane().setTop( textField );
		}
	}
	ReturnValueView( long result, Dimension2D size){
		this( Long.toString( result), false , new Dimension2D( size.getWidth(), GUIConstants.ReturnValueSmallHeight));
	}
	public ReturnValueView( Fraction result , Dimension2D size) {
		this( result.toString(), false, new Dimension2D( size.getWidth(), GUIConstants.ReturnValueSmallHeight) );
	}		
	ReturnValueView(java.util.Date result, boolean millies, Dimension2D size ){
		this(DateAndTime.toString(result, millies), false, new Dimension2D( size.getWidth(), GUIConstants.ReturnValueSmallHeight));
	}
	public ReturnValueView( ViewRoot result, Dimension2D size, ExceptionAndEventHandler exceptionHandler) {
		this(size, false);
		if( result != null){
			TreeRefresh tree = new TreeRefresh( exceptionHandler); 
			tree.setShowRoot( true );
			tree.setBackground(new Background( new BackgroundFill( GUIConstants.ReturnValueBackgroundColor, null, Insets.EMPTY)));
			tree.setCellFactory( new Callback< TreeView<ViewObjectInTree>,TreeCell<ViewObjectInTree> >(){
				public TreeCell<ViewObjectInTree> call (TreeView<ViewObjectInTree> param) {
					return new NoteCell();
				}
			});
			tree.setModel( result );
			this.getRootPane().setCenter( tree );
		}else{
			Label nullLabel = new Label();
			nullLabel.setText( RPCConstantsAndServices.NullObjectToString );
			nullLabel.setTextFill( Color.RED );
			this.getRootPane().setCenter(nullLabel);
		}
	}	
	ReturnValueView(java.util.Vector<?> result, Dimension2D size, ExceptionAndEventHandler exceptionHandler){
		this( size,  false);
		if( result.size() > 0){
			TreeRefresh tree = new TreeRefresh( exceptionHandler);
			this.rootScene.setFill( GUIConstants.ReturnValueBackgroundColor);
			tree.setShowRoot( false );
			tree.setCellFactory( new Callback< TreeView<ViewObjectInTree>,TreeCell<ViewObjectInTree> >(){
				public TreeCell<ViewObjectInTree> call (TreeView<ViewObjectInTree> param) {
					return new NoteCell();
				}
			});
			tree.setModel( new ListRoot(result) );
			this.getRootPane().setCenter(tree);
		}else{
			Label emptyLabel = new Label( GUIConstants.EmptyCollectionText );
			emptyLabel.setTextFill( Color.RED );
			this.getRootPane().setCenter(emptyLabel);
		}
	}	
}

class NoteCell extends TreeCell<ViewObjectInTree>{

	public NoteCell() {
	}
	
	@Override
	public void updateItem( ViewObjectInTree item, boolean empty){
		super.updateItem( item, empty);
		this.setBackground(new Background( new BackgroundFill( Color.TRANSPARENT, null, Insets.EMPTY)));
		if( item != null ){
			this.setText( item.toString());
			this.setGraphic(new ImageView( item.getImage()));
		}
		if (item == null || empty) {
			this.setText(null);
			this.setGraphic(null);			
		}
	}
    public void updateSelected(boolean selected) {
        super.updateSelected(selected);
        if (this.isEmpty()) return;
        if (selected) {
    		this.setBackground(new Background( new BackgroundFill( Color.BLUE, null, Insets.EMPTY)));
        } else {
    		this.setBackground(new Background( new BackgroundFill( Color.TRANSPARENT, null, Insets.EMPTY)));
        }
    }

}


class ListRoot extends ViewRoot implements TreeModel {
	private Vector<?> list;

	public ListRoot(Vector<?> list) {
		super(0,0);
		this.list = list;
	}
	public Object getChild(Object parent, int index) {
		if (parent == this) return this.list.get(index);
		try {
			return ((ViewObjectInTree)parent).getChild(index);
		} catch (ModelException e) {
			return e;
		}
	}
	public ViewObjectInTree getChild( int index){
		return (ViewObjectInTree) this.list.get(index);
	}	
	public int getChildCount(Object parent) {
		if (parent == this) return this.list.size();
		try {
			return ((ViewObjectInTree)parent).getChildCount();
		} catch (ModelException e) {
			return 0;
		}
	}
	public int getIndexOfChild(Object parent, Object child) {
		if (parent == this) {
			int result = 0;
			Iterator<?> roots = this.list.iterator();
			while (roots.hasNext()){
				if (roots.next().equals(child)) return result;
				result++;
			}
			return 0;
		}else{
			try {
				return ((ViewObjectInTree)parent).getIndexOfChild(child);
			} catch (ModelException e) {
				return 0;
			}
		}
	}
	public ViewRoot getRoot() {
		return this;
	}
	public boolean isLeaf(Object node) {
		if (node == this)return this.list.isEmpty();
		try {
			return ((ViewObjectInTree)node).isLeaf();
		} catch (ModelException e) {
			return true;
		}
	}
	public boolean isLeaf(){
		return this.list.isEmpty();
	}
	public void addTreeModelListener(javax.swing.event.TreeModelListener l) {}
	public void removeTreeModelListener(javax.swing.event.TreeModelListener l) {}
	public void valueForPathChanged(TreePath path, Object newValue) {}

	public ViewRoot getWrappedObject() {
		return this;
	}
    public javafx.scene.image.Image getImage() {
        return null;
    }
	public ViewObject getTheObject() throws ModelException {
		return null;
	}
	public void addTableModelListener(javax.swing.event.TableModelListener l) {}
	public int getRowCount() {
		return 0;
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	public void removeTableModelListener(javax.swing.event.TableModelListener l) {}
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}
	public boolean hasTransientFields() {
		for (Object current : this.list) {
			if (((ViewRoot) current).hasTransientFields()) return true;
		}
		return false;
	}

}

abstract class UserRegExprForExternalNamesSelectionPanel extends UserRegExprSelectionPanel {

	public UserRegExprForExternalNamesSelectionPanel(String parameterName, Wizard main, expressions.RegularExpression<Character, rGType.CharacterType> regExpr) {
		super(parameterName, main, regExpr);
	}	
}

class RegExprForExternalNamesSelectionPanel extends RegExprSelectionPanel{

	public RegExprForExternalNamesSelectionPanel(String parameterName, Wizard main, expressions.RegularExpression<Character, rGType.CharacterType> regExpr) {
		super(parameterName, main, regExpr);
	}
	protected String getResult() {
		String result = super.getResult();
		return ClientNames.getTheClientNames().getLongName(result);
	}
}


abstract class UserRegExprSelectionPanel extends RegExprSelectionPanel {
	UserRegExprSelectionPanel(String parameterName, Wizard main, expressions.RegularExpression<Character,rGType.CharacterType> regExpr) {
		super(parameterName, main, regExpr);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	abstract boolean userCheck();
}

class RegExprSelectionPanel extends StringSelectionPanel{
	
	protected view.ExprManager manager;
	private expressions.RegularExpression<Character,rGType.CharacterType> regExp;

	public RegExprSelectionPanel(String parameterName, Wizard main, expressions.RegularExpression<Character,rGType.CharacterType> regExpr){
		super(parameterName, main);
		this.regExp = regExpr;
		this.manager = new view.ExprManager(regExpr);
		this.getChildren().add( this.getSupportButton());
	}
	private Button supportButton = null;
	private Button getSupportButton(){
		if( this.supportButton == null){
			this.supportButton = new Button( GUIConstants.SupportButtonText);
			this.supportButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					browse();
				}
			});
		}
		return this.supportButton;
	}
	
	protected void browse(){
    	this.main.setPanel( this.getSupportPanel() );
	}
	
	class RegExprBrowserPanel extends AbstractBrowserPanel {

		private RegExprSelectionPanel panel;
		private expressions.RegularExpression<Character,rGType.CharacterType> regExp;
		private String fieldName;

		public RegExprBrowserPanel( expressions.RegularExpression<Character,rGType.CharacterType> regExp
		         		, RegExprSelectionPanel panel, String text, String fieldName) {
			this.fieldName = fieldName;
			this.panel = panel;
			this.regExp = regExp;
			this.setPrefHeight( GUIConstants.StandardRegExprBrowserPanelHeight);
			this.setCenter( this.getRegExprPanel());
			this.setBottom( this.getButtonPanel());
			this.getRegExprPanel().getRegExprInput().setText(text);
		}
		AbstractRegExpPanel regExprPanel = null;
		AbstractRegExpPanel getRegExprPanel(){
			if (this.regExprPanel == null){
				this.regExprPanel = new RegExprPanel2(this.regExp, this.fieldName);
			}
			return this.regExprPanel;
		}
		private ToolBar buttonPanel = null;
		private ToolBar getButtonPanel() {
			if( this.buttonPanel == null){
				this.buttonPanel = new ToolBar(
					this.getOKButton(),
					this.getCancelButton()
				);
				// this.buttonPanel.setPadding( new Insets(0,0,0,2000));
			}
			return this.buttonPanel;
		}

		private Button cancelButton = null;
		protected Button getCancelButton() {
			if( this.cancelButton == null){
				this.cancelButton = new Button();
				this.cancelButton.setText( GUIConstants.CancelButtonText);
				this.cancelButton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						main.resetPanel();						
					}
				});
			}
			return this.cancelButton;
		}

		private Button okButton = null;
		private Button getOKButton() {
			if (okButton == null){
				okButton = new Button();
				okButton.setText( GUIConstants.OKButtonText);
				okButton.setOnAction( new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						panel.setText(getRegExprPanel().getRegExprInput().getText());
						main.resetPanel();
						setVisible(false);
					}
				});
			}
			return okButton;
		}
		@Override
		public void determineFirstFocus() {
			this.getRegExprPanel().getRegExprInput().requestFocus();
		}
		@Override
		protected Button getDefaultButton() {
			return this.getOKButton();
		}
	}
	
	private AbstractBrowserPanel getSupportPanel() {
		return new RegExprBrowserPanel(this.regExp, this, this.getStringInputTextField().getText(), this.parameterName);
	}
	protected void setText(String text) {
		this.getStringInputTextField().setText(text);
	}
	boolean check() {
		String text = getStringInputTextField().getText();
		boolean result = manager.check(text, "", false);
		this.setOk(result);
		return result;
	}
}