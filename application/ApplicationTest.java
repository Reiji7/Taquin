package application;

import controller.Controller_Main;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model_Manager;
import view.View_Manager;


public class ApplicationTest extends Application{

	private Model_Manager model;
	private View_Manager view;


	public static void main(String[] args){
		launch(args);		 	
	}


	public void start(Stage primaryStage) throws Exception {
		model = new Model_Manager();
		view = new View_Manager();
		
		primaryStage.setResizable(false);
	    primaryStage.setTitle("Taquin");
	    primaryStage.setScene(view.getView_game().getScene());
	    primaryStage.show();

		Controller_Main controler = new Controller_Main(model, view);
		controler.start();
	}
}