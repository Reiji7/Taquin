package application;
	
import controller.Controller_Main;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Board.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        
        stage.setScene(scene);
        stage.show();
    }
	
	public static void main(String[] args) {
		launch();
	
		Controller_Main controller = new Controller_Main();
		controller.start();
	}
}
