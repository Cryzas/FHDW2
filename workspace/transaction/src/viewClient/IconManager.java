package viewClient;

import javafx.scene.image.Image;

public class IconManager {
	
	private IconManager(){}

	public static Image getImage(int iconInfo) {
		switch (iconInfo) {
		// TODO provide images for icon info numbers!
		case common.IconConstants.AccountIconNumber: return new Image("/viewResources/blue.gif");
		case common.IconConstants.AccountWrapperIconNumber: return new Image("/viewResources/yellow.gif");
		case common.IconConstants.BookedStateIconNumber :  return new Image("/viewResources/blue.gif");
		case common.IconConstants.NotBookedStateIconNumber :  return new Image("/viewResources/yellow.gif");
		default:
			return new Image("/viewResources/default.gif");
		}
	}
}
