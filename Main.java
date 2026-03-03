package hsCodes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("customsGUI.fxml"));
		
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/hsCodes/earth-globe.png")));
		primaryStage.setTitle("Zolltarif-Validator v1.0");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}
	
}
