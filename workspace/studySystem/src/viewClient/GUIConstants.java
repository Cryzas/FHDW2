package viewClient;

import javafx.scene.paint.Color;

public class GUIConstants {
	
    /***************************************************************************
     *                                                                         *
     * titles                                                                  *
     *                                                                         *
     **************************************************************************/
	static final String DetailsTitle = "Details";
	static final String NaviationTitle = "Navigation";
	static final String ErrorTitle = "Errors";
	static final String HelpTitle = "Hilfe";
	static final String NoTitle = "-----";
	
	
    /***************************************************************************
     *                                                                         *
     * button lettering                                                        *
     *                                                                         *
     **************************************************************************/
    static final String OKButtonText = "O.K.";
	static final String CancelButtonText = "Abbrechen";
	static final String ConfirmButtonText = "Bestätigen";

	static final String ShowTextButtonText = "Anzeigen";
	static final String BrowseButtonText = "Auswählen";
	static final String UpdateButtonText = "Übernehmen";
	static final String HelpButtonText = "Hilfe";
	static final String SupportButtonText = "Eingabeunterstützung";
	
	static final String EditTextButtonText = "Bearbeiten";
	static final String CloseTextButtonText = "Schließen";
	static final String SaveTextButtonText = "Speichern ...";
	static final String OpenTextButtonText = "Datei öffnen ...";
			

	/***************************************************************************
     *                                                                         *
     * hints                                                                   *
     *                                                                         *
     **************************************************************************/
	static final String ObjectSelectionHint = "Auswählen auch mit Alt+Click!";

	static final String ChooseFromText = "Auswählen aus:";
	static final String TextFieldToolTipText = "Öffnen mit Doppel-Klick";
	static final String TimeSliderToolTipText = "Zeiteinstellung\n auch mit links-/rechts-Navigation";
	static final String UpdateText = "Alles Aktualisieren";
	static final String SaveTextApproveText = "Text speichern!";
	static final String ApproveText = "Datei wird überschrieben!";
	static final String OpenTextFileApproveText = "Datei als Text öffnen";
    static final String FileDoesNotExistText = "Datei existiert nicht: ";

    static final String WrongTypeMessage = "Falsches Objekt, Anzahl: ";

    static final String EmptyCollectionText = "EMPTY";

    static final String NullRepresentation = "NULL";
	

	/***************************************************************************
     *                                                                         *
     * rendering                                                               *
     *                                                                         *
     **************************************************************************/
	static final int TextPreviewLength = 100;

	static final int BaseTypePanelStandardWidth = 10000;
	static final int BaseTypePanelStandardHeight = 28;
	static final String ConfirmQuestionMark = " ?";
		
	static final String UpdateMarker = " <<<";
	
	static final Color NeutralForeground = Color.rgb(120, 120, 120);
	static final Color OKForeground = Color.rgb(0, 0, 0);
	static final Color NotOKForeground = Color.rgb(127, 127, 127);
	
	static final Color Yellow = Color.rgb(200, 200, 0);
	static final String NeutralText = "Aktualisieren";

	static final Color Green = Color.rgb(0, 200, 0);
	static final String OKText = NeutralText;

	static final Color Red = Color.rgb(200, 0, 0);
	static final String NotOKText = NeutralText;
	
	static final Color ReturnValueBackgroundColor      = Color.rgb(255,255,220); 
	static final Color ReturnValueBackgroundColorForText  = Color.rgb(255,255,0); 
	static final Color ReturnValueBackgroundErrorColor = Color.rgb(255,110,110); 
	static final Color ReturnValueForegroundErrorColor = Color.rgb(0,155,155); 
	
	static final int ReturnValueSmallHeight = 20;
	static final int StandardBrowserPanelHeight = 300;
	static final int StandardRegExprBrowserPanelHeight = 220;

	static final public String STYLE_OPACITY_OFF = "-fx-opacity: 1.0;";

	private GUIConstants(){}

}
