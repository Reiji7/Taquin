package application;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import controller.Controller_Main;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Model_Manager;
import view.View_Manager;
import view.choose.Choose;


public class Taquin extends Application implements Observer{

	//private Model_Manager model;
	private View_Manager view;
	private Controller_Main controler;
	private Stage primaryStage;
	private Choose choose;


	public static void main(String[] args){
		launch(args);		 	
	}

	
	public void start(Stage primaryStage) throws Exception {

		view = new View_Manager();
		//model = new Model_Manager();
		choose = new Choose();
		this.primaryStage = primaryStage;

		//this.choose.console.addObserver(this);

		primaryStage.setResizable(false);
	    primaryStage.setTitle("Taquin");
	    
	    primaryStage.setScene(choose.getScene());
	    
	}
	
	
    private void exitApplication(Stage primaryStage) {
   	 
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {	
             public void handle(WindowEvent we) {
                 System.exit(0);
             }
         });
	  }


	@Override
	public void update(Observable o, Object arg) {
	    primaryStage.setScene(view.getView_game().getScene());
	    primaryStage.show();

		controler = new Controller_Main(null, view);
		try {
			controler.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
        exitApplication(primaryStage);				
	}

    
}