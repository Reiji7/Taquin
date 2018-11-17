package application;


import controller.Controller_Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller_Main extends Application{

	private Controller_Game controller_game;
	
	public void start() {
		controller_game = new Controller_Game();
		controller_game.start();
	}

	@Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/Board.fxml"));
        
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
