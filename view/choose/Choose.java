package view.choose;

import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.util.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Choose extends Observable{ 

	public Button console, graphique;
	protected Scene scene;
	
	
	public Scene getScene() {
		
		Group group = new Group();
		BorderPane pane = new BorderPane();
		
		console = new Button("Console");
		graphique = new Button("Graphique");
		
		console.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        resources.Configuration.consol = true;
		        setChanged();
		   		notifyObservers();
		    }
		});
		
		graphique.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setChanged();
		   		notifyObservers();
		    }
		});
		
		
		pane.setBottom(console);
		pane.setTop(graphique);

		group.getChildren().add(pane);
		scene = new Scene(group, 400, 600);
		
		return scene;
	}

}