package viewClient;

import view.Anything;
import view.ModelException;
import view.objects.ViewProxi;
import view.visitor.AnythingVisitor;

import common.Fraction;
import common.DateAndTime;

import rGType.CharacterType;
import expressions.RegularExpression;
import expressions.RegularExpressionHandler;
import view.FX.RegExprPanel2;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


abstract public class DetailPanel extends BorderPane {

	public static void setButtonToNeutral( Button button) {
		button.setBackground( new Background( new BackgroundFill( GUIConstants.Yellow, null, Insets.EMPTY)));
		button.setTextFill( GUIConstants.NeutralForeground);
		button.setText( GUIConstants.NeutralText);
		// 	button.setIcon(GUIConstants.NeutralIcon);
		button.setDisable(true);
	}

	public static void setButtonToOK( Button button) {
		button.setBackground( new Background( new BackgroundFill( GUIConstants.Green, null, Insets.EMPTY)));
		button.setTextFill( GUIConstants.OKForeground);
		button.setText( GUIConstants.OKText);
		// button.setIcon(GUIConstants.OKIcon);
		button.setDisable(false);
	}

	public static void setButtonToNotOk( Button button) {
		button.setBackground( new Background( new BackgroundFill( GUIConstants.Red, null, Insets.EMPTY)));
		button.setTextFill( GUIConstants.NotOKForeground);
		button.setText( GUIConstants.NotOKText);
		// button.setIcon(GUIConstants.NotOKIcon);
		button.setDisable(true);
	}

	protected Anything anything;
	private ExceptionAndEventHandler exceptionAndEventHandler;

	protected DetailPanel(ExceptionAndEventHandler exceptionHandler) {
		super();
		this.exceptionAndEventHandler = exceptionHandler;
	}

	abstract public void setAnything(Anything anything);

	protected Anything getAnything() {
		return this.anything;
	}

	protected ExceptionAndEventHandler getExceptionAndEventhandler() {
		return this.exceptionAndEventHandler;
	}
}

abstract class BaseTypePanel extends HBox {

	protected static final int Neutral = 0;
	protected static final int OK 	   = 1;
	protected static final int NotOK   = 2;

	private DefaultDetailPanel master;
	protected Updater updater;

	protected BaseTypePanel( DefaultDetailPanel master, String name, String value) {
        super(10);
		this.master = master;
		this.setAlignment( Pos.BASELINE_LEFT );
		this.setPadding( new Insets( 10,10,0,10 ));
		this.prefWidthProperty().bind( master.widthProperty());        
		this.getChildren().add( this.getUpdateButton() );
		
		HBox nameBox = new HBox();
		nameBox.setAlignment(Pos.BASELINE_LEFT);
		this.getNameLabel().setText( name );
		nameBox.getChildren().add( this.getNameLabel());
		nameBox.getChildren().add( new Label(":"));
		nameBox.setMinWidth(USE_PREF_SIZE);
		nameBox.setMaxWidth(USE_PREF_SIZE);
		this.getChildren().add( nameBox );

		this.getChildren().add( (Node) this.getConcreteValueComponent() );

		this.getChildren().add( this.getUpdateMarker() );
		this.getValueComponent().setComponentValue( value);
	}

	abstract protected ValueComponent getValueComponent();
	
	protected ValueComponent valueComponent = null;
	protected ValueComponent getConcreteValueComponent(){
		if( this.valueComponent == null){
			this.valueComponent = this.getValueComponent();
			HBox.setHgrow( (Node) this.valueComponent, Priority.ALWAYS);
		}
		return this.valueComponent;
	};
	
	private Label updateMarker = null;
	protected Label getUpdateMarker() {
		if( this.updateMarker == null) {
			this.updateMarker = new Label( GUIConstants.UpdateMarker );
			this.updateMarker.setVisible(false);
		}
		return this.updateMarker;
	}

	private Button updateButton;
	private Button getUpdateButton() {
		if( this.updateButton == null) {
			this.updateButton = new Button("    ");
			this.setStatus( Neutral );
			this.updateButton.setMinWidth(USE_PREF_SIZE);
			this.updateButton.setMaxWidth(USE_PREF_SIZE);
			this.updateButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle( ActionEvent event) {
					if (isUpdatable()) update();
				}
			});
		}
		return this.updateButton;
	}

	public void setOK(boolean ok) {
		if (ok) {
			this.setStatus(OK);
		} else {
			this.setStatus(NotOK);
		}
	}

	private int status = BaseTypePanel.Neutral;
	protected void setStatus(int status) {
		this.status = status;
		if( this.status == Neutral)
			DetailPanel.setButtonToNeutral(this.getUpdateButton());
		if( this.status == OK)
			DetailPanel.setButtonToOK(this.getUpdateButton());
		if( this.status == NotOK)
			DetailPanel.setButtonToNotOk(this.getUpdateButton());
		this.master.check();
	}

	private Label nameLabel;
	protected Label getNameLabel() {
		if( this.nameLabel == null) {
			this.nameLabel = new Label();
		}
		return this.nameLabel;
	}

	protected DefaultDetailPanel getMaster() {
		return this.master;
	}

	protected void registerUpdater( Updater updater) {
		this.updater = updater;
		this.setUpdatable();
		this.getValueComponent().setComponentValue( updater.format(this.getValueComponent().getComponentValue()));
	}

	protected void setUpdatable() {
		this.getUpdateMarker().setVisible(true);
		this.getValueComponent().setComponentEditable();
	}

	public boolean isUpdatable() {
		return this.updater != null;
	}

	protected boolean isReadyForUpdate() {
		return this.isUpdatable() && !this.getUpdateButton().isDisabled();
	}

	public void updateIfReady() {
		if (this.isReadyForUpdate())
			this.update();
	}

	private void update() {
		try {
			this.updater.update( this.getValueComponent().getComponentValue());
			this.setStatus( Neutral);
		} catch (ModelException ex) {
			this.getValueComponent().setComponentValue( ex.getMessage());
			this.setStatus( NotOK);
		}
	}

	public int getStatus() {
		return this.status;
	}
}

interface ValueComponent{
	String getComponentValue();
	void setComponentValue(String value);
	void setComponentEditable();	
}

abstract class BaseTypePanelWithTextField extends BaseTypePanel{

	protected BaseTypePanelWithTextField(DefaultDetailPanel master, String name, String value) {
		super(master, name, value);
	}
	
	protected ValueTextField getValueTextField() {
		ValueTextField valueTextField = new ValueTextField();
		valueTextField.setEditable(false);
		valueTextField.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (isUpdatable()) {
					try {
						setOK(updater.check(getValue()));
					} catch (ModelException me) {
						getValueComponent().setText(me.getMessage());
					}
				}
			}
		});
		return valueTextField;
	}

	class ValueTextField extends TextField implements ValueComponent{
		public ValueTextField() {
			super();
		}

		@Override
		public String getComponentValue() {
			return this.getText();
		}

		@Override
		public void setComponentValue(String value) {
			this.setText( value);
			this.home();
		}

		@Override
		public void setComponentEditable() {
			this.setEditable(true);
		}
	}
	
	protected ValueTextField getValueComponent(){
		if( this.valueComponent == null){
			return this.getValueTextField();
		}
		return (ValueTextField) this.valueComponent;
	}
	
	public String getValue() {
		return this.getValueComponent().getComponentValue();
	}

	protected void setValue( String value ) {
		this.getValueComponent().setComponentValue(value);
	}
	
	protected void setEditable(){		
		this.getValueComponent().setComponentEditable();
	}	
}

class IntegerPanel extends BaseTypePanelWithTextField {
	protected IntegerPanel(DefaultDetailPanel master, String name, long value) {
		super(master, name, Long.toString(value));
	}
}

class FractionPanel extends BaseTypePanelWithTextField {
	protected FractionPanel(DefaultDetailPanel master, String name, Fraction value) {
		super(master, name, value.toString());
	}
}

class StringPanel extends BaseTypePanelWithTextField {
	protected StringPanel(DefaultDetailPanel master, String name, String value) {
		super(master, name, value);
	}
}

class RegularExpressionPanel extends BaseTypePanelWithTextField {

	private RegularExpressionHandler handler;

	protected RegularExpressionPanel(DefaultDetailPanel master, String name, String value, RegularExpressionHandler handler) {
		super(master, name, value);
		this.handler = handler;
		this.getValueComponent().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				if (getValueComponent().isEditable() ){
					if(e.getClickCount() == 2 || e.isAltDown()) getMaster().switchToRegExprView(RegularExpressionPanel.this);
				}
			}
		});
		this.getValueComponent().setTooltip( new Tooltip( GUIConstants.TextFieldToolTipText));
	}

	protected boolean check() {
		return this.handler.check(new rGType.CharacterValue(this.getValue()));
	}

	public RegularExpression<Character, rGType.CharacterType> getExpression() {
		return handler.getRegExpr();
	}
}

class TextPanel extends BaseTypePanelWithTextField {
	private String value;

	protected TextPanel(DefaultDetailPanel master, String name, String value) {
		super(master, name, value);
		this.value = value;
		// open text view to see the whole text, independent if text editable
		this.getValueComponent().setOnMouseClicked( new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				if (e.getClickCount() == 2 || e.isAltDown()) getMaster().switchToTextView(TextPanel.this);
			}
		});
		this.getValueComponent().setTooltip( new Tooltip( GUIConstants.TextFieldToolTipText));
	}

	public String getValue() {
		return this.value;
	}

	protected void setValue(String value) {
		if (this.value != null && this.value.equals(value)) return;
		this.value = value;
		boolean tooLong = value.length() > GUIConstants.TextPreviewLength;
		this.getValueComponent().setComponentValue(value.substring(0, tooLong ? GUIConstants.TextPreviewLength : value.length()) + (tooLong ? "....." : ""));
		if( this.isUpdatable()) {
			try {
				this.setOK( this.updater.check(getValue()));
			} catch (ModelException me) {
				this.setOK(false);
				this.getValueComponent().setText(me.getMessage());
			}
		}
	}

	protected void setUpdatable() {
		this.getUpdateMarker().setVisible(true);
	}
}


class DatePanel extends BaseTypePanel {
	protected DatePanel(DefaultDetailPanel master, String name, java.util.Date value) {
		super( master, name, DateAndTime.toString(value, false));
	}
	
	class ValueDatePicker extends HBox implements ValueComponent{
		ValueDatePicker(){
			super(10);
			this.getChildren().add(this.getDatePicker());
			this.getChildren().add(this.getSpaceHolder());
			this.setAlignment(Pos.BASELINE_LEFT);
			HBox.setHgrow(this.getDatePicker(), Priority.SOMETIMES);
			HBox.setHgrow(this.getSpaceHolder(), Priority.ALWAYS);
		}
		private Label getSpaceHolder() {
			return new Label();
		}
		private DatePicker datePicker;
		private DatePicker getDatePicker(){
			if( this.datePicker == null){
				this.date = LocalDate.now();
				this.result = java.util.Date.from(this.date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());		
				this.datePicker = new DatePicker(); 
				this.datePicker.getEditor().setText(DateAndTime.toString(this.result, false));
				this.setMinWidth(Double.MIN_VALUE);
				this.setComponentNotEditable();
				this.datePicker.getEditor().setOnKeyReleased( new EventHandler<KeyEvent>() {
					public void handle(KeyEvent event) {
						if( isUpdatable() ){
							try {
								setOK( updater.check( getValueComponent().getComponentValue()));
						    } catch (ModelException me) {
						    	getValueComponent().setComponentValue( me.getMessage());
						    }						
						}
					}
				});
				this.datePicker.setOnAction(new EventHandler<ActionEvent>() {				
					public void handle(ActionEvent event) {
						if( isUpdatable() ){
							try {
								setOK( updater.check( getValueComponent().getComponentValue()));
						    } catch (ModelException me) {
						    	getValueComponent().setComponentValue( me.getMessage());
						    }						
						}
					}
				});			
			}
			return this.datePicker;
		}
		protected void setComponentNotEditable() {
			this.datePicker.setDisable(true);
			this.datePicker.setStyle( GUIConstants.STYLE_OPACITY_OFF);
			this.datePicker.getEditor().setStyle( GUIConstants.STYLE_OPACITY_OFF);			
		}
		@Override
		public String getComponentValue() {
			return this.getDatePicker().getEditor().getText();
		}

		private java.util.Date result;
		private LocalDate date;
		
		@Override
		public void setComponentValue(String value) {
			if( value != null){
				java.util.Date tmp;
				try {
					tmp = DateAndTime.parseDate(value);
					this.result = tmp;
					Instant instant = this.result.toInstant();
					ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
					this.date = zdt.toLocalDate();
					this.getDatePicker().getEditor().setText( DateAndTime.toString( this.result, false));
				} catch (ParseException e) {
					this.getDatePicker().getEditor().setText( e.getMessage());		
				}
			} 			
		}

		@Override
		public void setComponentEditable() {
			this.getDatePicker().setDisable(false);
			this.getDatePicker().getEditor().setEditable(true);
		}		
	}
	@Override
	protected ValueComponent getValueComponent() {		
		if( this.valueComponent == null){
			return new ValueDatePicker();
		}
		return this.valueComponent;
	}

}
class TimestampPanel extends BaseTypePanel implements ValueTimestampMaster{
	protected TimestampPanel(DefaultDetailPanel master, String name, java.util.Date value) {
		super(master, name, DateAndTime.toString(value, true));
//System.out.println("TimestampPanel() value formatted " + DateAndTimeConstantsAndServices.toString(value, true));
		}		
	@Override
	protected ValueComponent getValueComponent() {
		if( this.valueComponent == null){
			return new ValueTimestampPanel(this);
		}
		return this.valueComponent;
	}
	@Override
	public boolean checkAndSetOk(String value) throws ModelException {
		boolean checkResult = this.updater.check(value);
		this.setOK(checkResult);
		return checkResult;
	}	
}

interface CompleteUpdater {
	void update() throws ModelException;
}

interface Updater {
	void update(String text) throws ModelException;

	String format(String text);

	boolean check(String text) throws ModelException;
}

abstract class StandardUpdater implements Updater {
	public String format(String text) {
		return text;
	}
}

abstract class UpdaterForInteger extends StandardUpdater {
	public boolean check(String text) throws ModelException {
		try {
			Long.parseLong(text);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}

abstract class UpdaterForString extends StandardUpdater {
	public boolean check(String text) throws ModelException {
		return true;
	}
}

abstract class UpdaterForText extends StandardUpdater {
	public boolean check(String text) throws ModelException {
		return true;
	}
}

abstract class UpdaterForDate extends StandardUpdater {
	public boolean check(String text) throws ModelException {
		try {
			DateAndTime.parseDate(text);
			return true;
		} catch (java.text.ParseException pe) {
			return false;
		}
	}
}

abstract class UpdaterForTimeStamp extends StandardUpdater {
	public boolean check(String text) throws ModelException {
		try {
			DateAndTime.parseTimestamp(text);
			return true;
		} catch (java.text.ParseException pe) {
			return false;
		}
	}
}

abstract class DefaultDetailPanel extends DetailPanel {

	public static DetailPanel getStandardDetailPanel(Anything object, final ExceptionAndEventHandler handler) throws ModelException {
		DetailPanelFactory factory = new DetailPanelFactory(handler);
		object.accept(factory);
		return factory.result;
	}

	public void check() {
		boolean somethingUpdatable = false;
		this.setStatus(BaseTypePanel.Neutral);
		java.util.Iterator<BaseTypePanel> panelIterator = this.panels.values().iterator();
		while (panelIterator.hasNext()) {
			BaseTypePanel current = panelIterator.next();
			if (current.getStatus() == BaseTypePanel.NotOK) {
				this.setStatus(BaseTypePanel.NotOK);
				return;
			}
			if (current.getStatus() == BaseTypePanel.OK) {
				somethingUpdatable = true;
			}
		}
		if (somethingUpdatable)
			this.setStatus(BaseTypePanel.OK);
	}

	Hashtable<String, BaseTypePanel> panels;
	private CompleteUpdater completeUpdater;

	protected DefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
		super(exceptionHandler);
		this.panels = new Hashtable<String, BaseTypePanel>();
		this.setCenter( this.getStandardDetailsPanel() );
		this.setAnything(anything);
	}

	protected void registerUpdater(String fieldName, Updater updater) {
		BaseTypePanel panel = this.panels.get(fieldName);
		if (panel != null)
			panel.registerUpdater(updater);
	}

	protected void registerCompleteUpdater(CompleteUpdater completeUpdater) {
		this.completeUpdater = completeUpdater;
	}

	abstract protected void addFields();

	public BaseTypePanel getPanel(String key) {
		return this.panels.get(key);
	}

	public void switchBackFromTextView( boolean update) {
		this.setCenter(this.getStandardDetailsPanel());
		if( update) {
			this.currentTextPanel.setValue( this.getTextView().getText());
		}
	}

	private TextPanel currentTextPanel = null;
	public void switchToTextView( TextPanel panel) {
		this.currentTextPanel = panel;
		this.getTextView().setText( panel.getValue());
		this.getTextView().positionCaret(0);
		this.getTextView().setEditable( this.currentTextPanel.isUpdatable() );
		this.getTextPaneWithTitle().setText( panel.getNameLabel().getText() );
		this.setCenter( this.getTextPane());
		this.getTextView().requestFocus();
	}

	private RegularExpressionPanel currentRegExpPanel = null;
	public void switchToRegExprView(RegularExpressionPanel panel) {
		this.currentRegExpPanel = panel;
		final BorderPane regExpPanel = this.getRegExprComfortPanel(panel.getExpression(), panel.getNameLabel().getText(), panel.getValue());
		this.setCenter( regExpPanel );
		this.regExprPane.getRegExprInput().focusedProperty().addListener( new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(! newValue ){					
					if( regExpOkButton.isFocused() || regExpCancelButton.isFocused()){
					} else {						
						switchBackFromRegExpView(false);
					}
				}
			}
		});
		this.regExprPane.getRegExprInput().requestFocus();
	}

	public void switchBackFromRegExpView( boolean update) {
		this.setCenter( this.getStandardDetailsPanel());
		if( update ) {
			String value = this.regExprPane.getRegExprInput().getText();
			this.currentRegExpPanel.setValue( value);
			this.currentRegExpPanel.setOK( this.currentRegExpPanel.check());
		}
	}

	private BorderPane regExprComfortPanel = null;
	private BorderPane getRegExprComfortPanel(RegularExpression<Character, CharacterType> expression, String name, String value) {
		if( this.regExprComfortPanel == null) {
			this.regExprComfortPanel = new BorderPane();
			this.regExprComfortPanel.setBottom( this.getRegExprComfortToolBar());
			this.regExprComfortPanel.setCenter( this.getRegExprPane( expression, name, value));
		} 
		return regExprComfortPanel;
	}
	private ToolBar regExprComfortToolBar = null;
	private ToolBar getRegExprComfortToolBar() {
		if( this.regExprComfortToolBar == null) {
			this.regExprComfortToolBar = new ToolBar(getRegExpOkButton(), getRegExpCancelButton() );
		}
		return regExprComfortToolBar;
	}
	private Button regExpOkButton = null;
	private Button getRegExpOkButton() {
		if( this.regExpOkButton == null) {
			this.regExpOkButton = new Button( GUIConstants.UpdateButtonText);
			this.regExpOkButton.setMinWidth(Region.USE_PREF_SIZE);
			this.regExpOkButton.setMaxWidth(Region.USE_PREF_SIZE);
			this.regExpOkButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					switchBackFromRegExpView(true);
				}
			});
		}
		return this.regExpOkButton;
	}
	private Button regExpCancelButton = null;
	private Button getRegExpCancelButton() {
		if( this.regExpCancelButton == null) {
			this.regExpCancelButton = new Button( GUIConstants.CancelButtonText );
			this.regExpCancelButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					switchBackFromRegExpView(false);
				}
			});
		}
		return this.regExpCancelButton;
	}
	private RegExprPanel2 regExprPane = null;
	private RegExprPanel2 getRegExprPane(RegularExpression<Character, CharacterType> expression, String name, String value) {
		this.regExprPane = new RegExprPanel2(expression, name, value);
		return regExprPane;
	}
	private BorderPane standardDetailsPane;
	private BorderPane getStandardDetailsPanel() {
		if( this.standardDetailsPane == null) {
			this.standardDetailsPane = new BorderPane();
			this.standardDetailsPane.setBottom( this.getMajorToolBar());
			this.standardDetailsPane.setCenter( this.getDetailScrollPane() );
		}
		return this.standardDetailsPane;
	}
	private ToolBar majorToolBar;
	private ToolBar getMajorToolBar() {
		if( this.majorToolBar == null) {
			this.majorToolBar = new ToolBar(  this.getUpdateAllButton());
		}
		return this.majorToolBar;
	}
	private Button updateAllButton;
	private Button getUpdateAllButton() {
		if( this.updateAllButton == null) {
			this.updateAllButton = new Button( GUIConstants.UpdateText);
			this.updateAllButton.setMinWidth(USE_PREF_SIZE);
			this.updateAllButton.setMaxWidth(USE_PREF_SIZE);
			this.updateAllButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					updateAll();
				}
			});
			this.setStatus( BaseTypePanel.Neutral);
		}
		return this.updateAllButton;
	}

	protected void updateAll() {
		if( this.hasCompleteUpdater()) {
			try {
				this.completeUpdater.update();
				this.resetDetails(true, "");
			} catch (ModelException e) {
				this.resetDetails(false, e.getMessage());
			}
		}
		java.util.Iterator<BaseTypePanel> panelIterator = this.panels.values().iterator();
		while (panelIterator.hasNext()) {
			BaseTypePanel current = panelIterator.next();
			current.updateIfReady();
		}
		this.check();
	}

	private void resetDetails(boolean withoutErrors, String message) {
		java.util.Iterator<BaseTypePanel> panelIterator = this.panels.values().iterator();
		while (panelIterator.hasNext()) {
			BaseTypePanel current = panelIterator.next();
			if (current.isReadyForUpdate()) {
				if (withoutErrors) {
					current.setStatus(BaseTypePanel.Neutral);
				} else {
					current.getValueComponent().setComponentValue(message);
					current.setStatus(BaseTypePanel.NotOK);
				}
			}
		}
		this.check();
	}

	private boolean hasCompleteUpdater() {
		return this.completeUpdater != null;
	}

	private void setStatus(int status) {
		if (status == BaseTypePanel.Neutral)
			DetailPanel.setButtonToNeutral(this.getUpdateAllButton());
		if (status == BaseTypePanel.OK)
			DetailPanel.setButtonToOK(this.getUpdateAllButton());
		if (status == BaseTypePanel.NotOK)
			DetailPanel.setButtonToNotOk(this.getUpdateAllButton());
	}
	private ScrollPane detailScrollPane = null;
	private ScrollPane getDetailScrollPane() {
		if( this.detailScrollPane == null) {
			this.detailScrollPane = new ScrollPane();
			this.detailScrollPane.setContent( this.getScrollablePane());
		    this.detailScrollPane.prefWidthProperty().bind( this.widthProperty().multiply(0.98));			
		    this.detailScrollPane.prefHeightProperty().bind( this.heightProperty());			
		}
		return detailScrollPane;
	}
	private BorderPane textPane = null;
	private BorderPane getTextPane() {
		if( this.textPane == null) {
			this.textPane = new BorderPane();
			this.textPane.setCenter( this.getTextPaneWithTitle());
			this.textPane.setBottom( this.getTextToolBar());
		}
		return this.textPane;
	}
	private TitledPane textPaneTitle;
	private TitledPane getTextPaneWithTitle() {
		if (this.textPaneTitle == null) {
			this.textPaneTitle = new TitledPane("", this.getTextView());
			this.textPaneTitle.setCollapsible(false);
		}
		return this.textPaneTitle;
	}

	private ToolBar textToolBar;
	private ToolBar getTextToolBar() {
		if( this.textToolBar == null) {
			this.textToolBar = new ToolBar();
			this.textToolBar.getItems().add( this.getSwitchBackCancelButton());
			this.textToolBar.getItems().add( this.getSwitchBackUpdateButton());
		}
		return this.textToolBar;
	}

	private Button switchBackUpdateButton;
	private Button getSwitchBackUpdateButton() {
		if( this.switchBackUpdateButton == null) {
			this.switchBackUpdateButton = new Button( GUIConstants.UpdateButtonText);
			this.switchBackUpdateButton.setDisable( true);
			this.switchBackUpdateButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					switchBackFromTextView(true);
				}
			}); 
		}
		return this.switchBackUpdateButton;
	}

	private Button switchBackCancelButton;
	private Button getSwitchBackCancelButton() {
		if( this.switchBackCancelButton == null){
			this.switchBackCancelButton = new Button( GUIConstants.CancelButtonText);
			this.switchBackCancelButton.setOnAction( new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					switchBackFromTextView(false);
				}
			});
		}
		return this.switchBackCancelButton;
	}

	private TextArea textView = null;
	private TextArea getTextView() {
		if( this.textView == null) {
			this.textView = new TextArea();
			this.textView.setWrapText( true );
			this.textView.setPrefHeight(USE_PREF_SIZE);
			this.textView.setMaxHeight(Double.MAX_VALUE);
			this.textView.prefHeightProperty().bind(this.heightProperty());
			this.textView.setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle( KeyEvent event ) {
					getSwitchBackUpdateButton().setDisable( !getTextView().isEditable());					
				}
			});
		}
		return this.textView;
	}

	private VBox scrollablePane = null;
	protected VBox getScrollablePane() {
		if( this.scrollablePane == null) {
			this.scrollablePane = new VBox(8);
			this.scrollablePane.setAlignment( Pos.TOP_LEFT);
			this.scrollablePane.prefWidthProperty().bind( this.getDetailScrollPane().prefWidthProperty());
		}
		return this.scrollablePane;
	}

	public void setAnything(Anything anything) {
		this.anything = anything;
		((ViewProxi) anything).expand();
		this.addFields();
	}
}

class ValueTimestampPanel extends HBox implements ValueComponent{
	private java.util.Date result;
	private LocalDate date;
	private LocalTime time;
	private ValueTimestampMaster master;
	private int partsPerHour;
	private int delta;								// delta in seconds of time slider step
	private int hourStart = DateAndTime.HOUR_START; // time slider range start, inclusive
	private int hourEnd = DateAndTime.HOUR_END; 	// time slider range end, exclusive

	ValueTimestampPanel(){		
		this(DateAndTime.PARTS_PER_HOUR, DateAndTime.HOUR_START, DateAndTime.HOUR_END);
	}

	ValueTimestampPanel( ValueTimestampMaster master ){
		this( DateAndTime.PARTS_PER_HOUR, DateAndTime.HOUR_START, DateAndTime.HOUR_END);
		this.master = master;
	}

	ValueTimestampPanel(ValueTimestampMaster master, int partsPerHour, int startHour, int endHour){		
		this( partsPerHour, startHour, endHour);
		this.master = master;
	}

	/**
	 * The Parameter <code> partsPerHour </code> determines the granularity for the time slider in seconds. 
	 * <p> The default is 12.
	 * <p> The range is 1 to 3600.
	 * <p> One hour (60 minutes) is divided into 5 minutes parts by default; e.g. one time slider step is 5 minutes plus or minus.
	 */
	ValueTimestampPanel(int partsPerHour, int startHour, int endHour){		
		super(10);
		this.partsPerHour = partsPerHour;
		this.delta = 3600/this.partsPerHour;
		this.hourStart = startHour;
		this.hourEnd = endHour;

		this.master = new ValueTimestampMaster() {
			public boolean checkAndSetOk(String value) throws ModelException {
				return false;
			}
			public boolean isUpdatable() {
				return false;
			}
		};
		
		this.date = LocalDate.now();
		this.time = LocalTime.now();
		long fractions = this.calcFractions( this.time.getHour(), this.time.getMinute(), this.time.getSecond());
		this.time = LocalTime.ofSecondOfDay(((long) fractions*delta));
//System.out.println("init time " + this.time + " fractions " + fractions + " part " + partsPerHour);		
//		this.time = this.time.minusSeconds(this.time.getSecond());
//		this.time = this.time.minusNanos(this.time.getNano());
        this.result = java.util.Date.from( this.date.atTime(this.time).atZone(ZoneId.systemDefault()).toInstant());
		
		this.setAlignment( Pos.BASELINE_LEFT );
		this.getChildren().add( this.getDatePicker());
		this.getChildren().add( this.getTimeInputField());
		this.getChildren().add( this.getTimeSlider());
		HBox.setHgrow(this.getDatePicker(), Priority.NEVER);
		HBox.setHgrow(this.getTimeInputField(), Priority.SOMETIMES);			
		HBox.setHgrow(this.getTimeSlider(), Priority.ALWAYS);
		
		this.setTimeValue( this.time.getHour(), this.time.getMinute(), this.time.getSecond());
	}
			
	private DatePicker datePicker;
	private DatePicker getDatePicker(){
		if( this.datePicker == null){
			this.datePicker = new DatePicker( this.date );
			this.datePicker.getEditor().setText(DateAndTime.toString(this.result, false));
			this.datePicker.setDisable(true);
			this.datePicker.setStyle(GUIConstants.STYLE_OPACITY_OFF);
			this.datePicker.getEditor().setStyle(GUIConstants.STYLE_OPACITY_OFF);
			this.datePicker.getEditor().setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if( master.isUpdatable() ){
						try {
							master.checkAndSetOk( getComponentValue());
					    } catch (ModelException me) {
					    	datePicker.getEditor().setText( me.getMessage());
					    }						
					}
				}
			});
			this.datePicker.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					if( master.isUpdatable() ){
						try {
							master.checkAndSetOk( getComponentValue());
					    } catch (ModelException me) {
					    	datePicker.getEditor().setText( me.getMessage());
					    }						
					}
				}
			});		
		}
		return this.datePicker;
	}
	
	private Slider timeSlider;
	private Slider getTimeSlider() {
		if( this.timeSlider == null){
			this.timeSlider = new Slider( this.hourStart*this.partsPerHour
										, this.hourEnd*this.partsPerHour - 1
					, this.calcFractions( this.time.getHour(), this.time.getMinute(), this.time.getSecond() ));	
			this.timeSlider.setPrefWidth(20);
			this.timeSlider.setMinWidth(Double.MIN_VALUE);
			this.timeSlider.setTooltip(new Tooltip(GUIConstants.TimeSliderToolTipText));
			this.timeSlider.setVisible(false);
			this.timeSlider.setOnMouseDragged(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					time = LocalTime.ofSecondOfDay(((long) (timeSlider.getValue())*delta));
					setTimeValue( time.getHour(), time.getMinute(), time.getSecond());
					if( master.isUpdatable() ){
						try {
							master.checkAndSetOk( getComponentValue());
					    } catch (ModelException me) {
					    	getDatePicker().getEditor().setText( me.getMessage());
					    }						
					}					
				}
			});
			this.timeSlider.setOnKeyPressed(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if( event.getCode() == KeyCode.RIGHT ) {
						time = LocalTime.ofSecondOfDay(((long) (timeSlider.getValue())* delta));							
						if(((long)timeSlider.getValue()) >= hourEnd * partsPerHour - 1) return;						
						time = time.plusSeconds( delta );
						Platform.runLater(new Runnable() {
							public void run() {
								timeSlider.setValue( calcFractions(time.getHour(), time.getMinute(), time.getSecond()));									
								setTimeValue( time.getHour(), time.getMinute(), time.getSecond());						
								if( master.isUpdatable() ){
									try {
										master.checkAndSetOk( getComponentValue());
								    } catch (ModelException me) {
								    	getDatePicker().getEditor().setText( me.getMessage());
								    }						
								}					
							}
						});
					} else if (event.getCode() == KeyCode.LEFT){
						time = LocalTime.ofSecondOfDay(((long) (timeSlider.getValue())* delta));							
						if( ((long)timeSlider.getValue()) <= hourStart*partsPerHour)return;					
						time = time.minusSeconds( delta );
						Platform.runLater(new Runnable() {
							public void run() {
								timeSlider.setValue( calcFractions(time.getHour(), time.getMinute(), time.getSecond()));
								setTimeValue( time.getHour(), time.getMinute(), time.getSecond());						
								if( master.isUpdatable() ){
									try {
										master.checkAndSetOk( getComponentValue());
								    } catch (ModelException me) {
								    	getDatePicker().getEditor().setText( me.getMessage());
								    }						
								}					
							}
						});
					}
				}
			});				
		}
		return this.timeSlider;
	}
	private long calcFractions( int hour, int minute, int second ){
		int totalSeconds = (hour*60+minute)*60 + second;
		return totalSeconds/this.delta + (totalSeconds % this.delta > 0 ? 1 : 0);
	}
	private TextField timeInputField;
	private TextField getTimeInputField() {
		if( this.timeInputField == null){
			this.timeInputField = new TextField();
			this.timeInputField.setPrefWidth(70);
			this.timeInputField.setMinWidth(Double.MIN_VALUE);
			this.timeInputField.setEditable(false);
			this.timeInputField.setOnKeyReleased(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if( master.isUpdatable() ){
						try {
							master.checkAndSetOk( getComponentValue());
							getTimeSlider().setValue( calcFractions(time.getHour(), time.getMinute(), time.getSecond()));
					    } catch (ModelException me) {
					    	getDatePicker().getEditor().setText( me.getMessage());
					    }						
					}
				}
			});			
		}
		return this.timeInputField;
	}
	protected void setTimeValue( int hours, int minutes, int seconds) {
		LocalTime time;
		String format;
		if( this.partsPerHour > 60 ){				
			time =  LocalTime.of( hours, minutes, seconds);
			format = DateAndTime.TIMEFORMAT;
		}
		else {
			time =  LocalTime.of( hours, minutes, 0);				
			format = DateAndTime.TIMEFORMAT_SIMPLE;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern( format );
		this.getTimeInputField().setText( time.format(formatter));							
	}

	public void setComponentValue( String value) {			
		if( value != null){
			java.util.Date tmp;
			try {
				tmp = DateAndTime.parseTimestamp(value);
				this.setComponentValue(tmp);
			} catch (ParseException e) {
				this.datePicker.getEditor().setText( e.getMessage());
			}
		} 
	}
	
	public void setComponentValue( java.util.Date value) {
		this.result = value;
		Instant instant = this.result.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		this.date = zdt.toLocalDate();
		this.time = zdt.toLocalTime();
		this.datePicker.getEditor().setText( DateAndTime.toString( this.result, false));
		this.setTimeValue( this.time.getHour(), this.time.getMinute(), this.time.getSecond());
	}

	public String getComponentValue() {
		if( check()){
//System.out.println("getComponentValue " + this.getCurrentResult());		
			return this.getCurrentResult();
		}
//System.out.println("getComponentValue gescheitert");				
		return this.getDatePicker().getEditor().getText() + " " + this.getTimeInputField().getText(); 
	}

	String getCurrentResult() {
		return DateAndTime.toString(this.result, true);
	}
	
	public java.util.Date getResult(){
		return this.result;
	}
	
	public boolean check() {
		boolean isResultOk = false;
		java.util.Date tmp = this.result;
		try {
			String dateInputAsText = this.getDatePicker().getEditor().getText();
			if( dateInputAsText.length() > 0){				
				tmp = DateAndTime.parseDate( dateInputAsText );
				this.date = tmp.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				isResultOk = true;
			} else if( this.getDatePicker().getValue() != null){
				this.date = this.getDatePicker().getValue();
				isResultOk = true;
			}	
		} catch (java.text.ParseException pe) {}
		if( isResultOk){
			try{	
				tmp = DateAndTime.parseTime( this.getTimeInputField().getText() );
				this.time = tmp.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
				this.result = java.util.Date.from( this.date.atTime(this.time).atZone(ZoneId.systemDefault()).toInstant() );
			} catch (ParseException pe) {
				isResultOk = false;
//System.out.println("parse time -> schrott (Format?)" + this.getTimeInputField().getText());				
			}			
		}
		return isResultOk;
	}
		
	public void setComponentEditable() {
		this.getTimeInputField().setEditable(true);
		this.getDatePicker().setDisable(false);
		this.getTimeSlider().setVisible(true);
	}
	
	public void handleFocusGained() {
		this.getDatePicker().requestFocus();
	}

}


interface ValueTimestampMaster{

	boolean isUpdatable();

	boolean checkAndSetOk(String value) throws ModelException;	
}


class DetailPanelFactory implements AnythingVisitor {
	protected DefaultDetailPanel result = null;
	private ExceptionAndEventHandler handler;
	public DetailPanelFactory(ExceptionAndEventHandler handler) {
		this.handler = handler;
	}
    public void handleServer(view.ServerView object){
        result = new ServerDefaultDetailPanel(handler, object);
    }
    public void handleQuantifiedComponent(view.QuantifiedComponentView object){
        result = new QuantifiedComponentDefaultDetailPanel(handler, object);
    }
    public void handleErrorDisplay(view.ErrorDisplayView object){
        result = new ErrorDisplayDefaultDetailPanel(handler, object);
    }
    public void handleProduct(view.ProductView object){
        result = new ProductDefaultDetailPanel(handler, object);
    }
    public void handleMaterial(view.MaterialView object){
        result = new MaterialDefaultDetailPanel(handler, object);
    }
    public void handleComponentLst(view.ComponentLstView object){
        result = new ComponentLstDefaultDetailPanel(handler, object);
    }

}



class ServerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Server$$currentComponents = "Server$$currentComponents";
    protected static final String Server$$user = "Server$$user";
    
    protected ServerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "user", this.getAnything().getUser());
            this.getScrollablePane().getChildren().add(panel);
            this.panels.put(Server$$user, panel);
        }catch(ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ServerView getAnything(){
        return (view.ServerView)this.anything;
    }
}

class QuantifiedComponentDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String QuantifiedComponent$$quantity = "QuantifiedComponent$$quantity";
    protected static final String QuantifiedComponent$$component = "QuantifiedComponent$$component";
    
    protected QuantifiedComponentDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new IntegerPanel(this, "quantity", this.getAnything().getQuantity());
            this.getScrollablePane().getChildren().add(panel);
            this.panels.put(QuantifiedComponent$$quantity, panel);
        }catch(ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.QuantifiedComponentView getAnything(){
        return (view.QuantifiedComponentView)this.anything;
    }
}

class ErrorDisplayDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String ErrorDisplay$$message = "ErrorDisplay$$message";
    
    protected ErrorDisplayDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "message", this.getAnything().getMessage());
            this.getScrollablePane().getChildren().add(panel);
            this.panels.put(ErrorDisplay$$message, panel);
        }catch(ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ErrorDisplayView getAnything(){
        return (view.ErrorDisplayView)this.anything;
    }
}

class ProductDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Component$$name = "Component$$name";
    protected static final String Component$$price = "Component$$price";
    protected static final String Component$$overAllPrice = "Component$$overAllPrice";
    protected static final String Product$$components = "Product$$components";
    
    protected ProductDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().getChildren().add(panel);
            this.panels.put(Component$$name, panel);
        }catch(ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new FractionPanel(this, "price", this.getAnything().getPrice());
            this.getScrollablePane().getChildren().add(panel);
            this.panels.put(Component$$price, panel);
        }catch(ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new FractionPanel(this, "overAllPrice", this.getAnything().getOverAllPrice());
            this.getScrollablePane().getChildren().add(panel);
            this.panels.put(Component$$overAllPrice, panel);
        }catch(ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ProductView getAnything(){
        return (view.ProductView)this.anything;
    }
}

class MaterialDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Component$$name = "Component$$name";
    protected static final String Component$$price = "Component$$price";
    protected static final String Component$$overAllPrice = "Component$$overAllPrice";
    
    protected MaterialDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().getChildren().add(panel);
            this.panels.put(Component$$name, panel);
        }catch(ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new FractionPanel(this, "price", this.getAnything().getPrice());
            this.getScrollablePane().getChildren().add(panel);
            this.panels.put(Component$$price, panel);
        }catch(ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new FractionPanel(this, "overAllPrice", this.getAnything().getOverAllPrice());
            this.getScrollablePane().getChildren().add(panel);
            this.panels.put(Component$$overAllPrice, panel);
        }catch(ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.MaterialView getAnything(){
        return (view.MaterialView)this.anything;
    }
}

class ComponentLstDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String ComponentLst$$parts = "ComponentLst$$parts";
    
    protected ComponentLstDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.ComponentLstView getAnything(){
        return (view.ComponentLstView)this.anything;
    }
}
