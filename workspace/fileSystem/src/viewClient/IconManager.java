package viewClient;

import javafx.scene.image.Image;

public class IconManager {
	
	private IconManager(){}

	public static Image getImage(int iconInfo) {
		switch (iconInfo) {
		// TODO provide images for icon info numbers!
		case common.Constants.FileIconNumber: return new Image("/viewResources/file.png");
		case common.Constants.DirectoryIconNumber: return new Image("/viewResources/directory.png");
		case common.Constants.FileSystemIconNumber: return new Image("/viewResources/fileSystem.png");
		case common.Constants.ErrorDisplayIconNumber: return new Image("/viewResources/error.png");
		case common.Constants.EmptyClipBoardIconNumber: return new Image("/viewResources/clipboardEmpty.png");
		case common.Constants.FilledClipBoardIconNumber: return new Image("/viewResources/clipboardFilled.png");
		default:
			return new Image("/viewResources/default.gif");
		}
	}
}
