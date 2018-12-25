package application;

import controller.Controller_Main;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Model_Manager;
import view.View_Manager;
import view.choose.Choose;


public class Taquin extends Application{

	private Model_Manager model;
	private View_Manager view;


	public static void main(String[] args){
		launch(args);		 	
	}

	
	public void start(Stage primaryStage) throws Exception {
		
		view = new View_Manager();
		model = new Model_Manager();
		
		primaryStage.setResizable(false);
	    primaryStage.setTitle("Taquin");
	    
	    primaryStage.setScene(new Choose().getScene());
	    
	    primaryStage.setScene(view.getView_game().getScene());
	    primaryStage.show();

		Controller_Main controler = new Controller_Main(model, view);
		controler.start();
		
        exitApplication(primaryStage);
	}
	
	
    private void exitApplication(Stage primaryStage) {
   	 
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {	
             public void handle(WindowEvent we) {
                 System.exit(0);
             }
         });
	  }
}