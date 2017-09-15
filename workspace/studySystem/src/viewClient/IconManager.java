package viewClient;

import javafx.scene.image.Image;

public class IconManager {
	
	private IconManager(){}

	public static Image getImage(int iconInfo) {
		switch (iconInfo) {
		case 1:
			return new Image("/viewResources/Black.gif");
		case 2:
			return new Image("/viewResources/Blue.gif");
		case 3:
			return new Image("/viewResources/Green.gif");
		case 4:
			return new Image("/viewResources/Yellow.gif");
		case 5:
			return new Image("/viewResources/Red.gif");
		case 6:
			return new Image("/viewResources/Student.png");
		case 7:
			return new Image("/viewResources/StudyGroup.png");
		case 8:
			return new Image("/viewResources/Delete.png");
		case 9:
			return new Image("/viewResources/Add.png");
		case 10:
			return new Image("/viewResources/Remove.png");
		case 11:
			return new Image("/viewResources/Change.png");
		case 12:
			return new Image("/viewResources/ModuleGroup.png");
		case 13:
			return new Image("/viewResources/ModuleWithUnits.png");
		case 14:
			return new Image("/viewResources/ModuleAtomar.png");
		case 15:
			return new Image("/viewResources/Unit.png");
		case 16:
			return new Image("/viewResources/GradeChange.png");
		case 17:
			return new Image("/viewResources/StudyGroup_Play.png");
		case 18:
			return new Image("/viewResources/StudyGroup_Stop.png");
		default:
			return new Image("/viewResources/default.gif");
		}
	}
}
