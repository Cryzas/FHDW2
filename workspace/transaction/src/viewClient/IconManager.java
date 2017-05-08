package viewClient;

import javafx.scene.image.Image;

public class IconManager {
	
	private IconManager(){}

	public static Image getImage(int iconInfo) {
		switch (iconInfo) {
		// TODO provide images for icon info numbers!
		default:
			return new Image("/viewResources/default.gif");
		}
	}
}
