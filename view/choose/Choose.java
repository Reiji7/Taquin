package view.choose;

import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Choose implements Observable{ 

	private Button console, graphique;
	private Scene scene;
	
	
	public Scene getScene() {
		
		Group group = new Group();
		BorderPane pane = new BorderPane();
		
		console = new Button("Console");
		graphique = new Button("Graphique");
		
		console.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        // Ajouter la fermeture de la fenetre
		    }
		});
		
		graphique.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        resources.Configuration.consol = true;
		        // Ajouter la fermeture de la fenetre
		    }
		});
		
		pane.setBottom(console);
		pane.setTop(graphique);

		group.getChildren().add(pane);
		scene = new Scene(group, 400, 600);
		
		return scene;
	}


	@Override
	public void addListener(InvalidationListener arg0) {
		
	}


	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

}