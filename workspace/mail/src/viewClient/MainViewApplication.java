package viewClient;

import javafx.application.Platform;

public class MainViewApplication extends MainView {
	void performClose() {
		Platform.exit();
		System.exit(0);				
	}
}