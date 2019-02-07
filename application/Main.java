package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Stage myPrimaryStage;
	@Override
	public void start(Stage primaryStage) {
		try {
	myPrimaryStage=primaryStage;
			
			FXMLLoader rootLoader = new FXMLLoader(getClass().getResource("parametres/InterfaceParametres.fxml"));
			
			
			BorderPane root = rootLoader.load();
			
			Scene scene = new Scene(root,650,470);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			myPrimaryStage.setScene(scene);
			myPrimaryStage.show();
			myPrimaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
