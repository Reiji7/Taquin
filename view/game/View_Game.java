package view.game;

import java.awt.event.ActionEvent;
import java.util.Observable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import view.View;


public class View_Game extends View{

	private Group root;
	private Scene scene;
	private Grid grid;

	
	public View_Game() {
		this.grid = new Grid();
		createScene();
	}
	
	public Grid getGrid() {
		return this.grid;
	}
	
	
	public Scene getScene(){
		return scene;
	}

	
	private void createScene() {
		root  = new Group();
		scene = new Scene(root, 400, 600, Color.GREEN);
        scene.getStylesheets().add("style.css");

        root.getChildren().add(grid.createBoard());
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}