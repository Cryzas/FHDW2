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
		default:
			return new Image("/viewResources/default.gif");
		}
	}
}
