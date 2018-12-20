package view;

import java.util.Observable;
import controller.Controller_Game;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class View_Game extends View{

	private Group root;
	private Scene scene;
	private APane anchorpane;
	private Button buttBoard[][];
	
	
	public View_Game() {
		createScene();
		createBoard();
	}
	
	
	public Scene getScene(){
		return scene;
	}

	
	private void createScene() {
		root  = new Group();
		scene = new Scene(root, 800, 600, Color.WHITE);
        scene.getStylesheets().add("style.css");
        
        anchorpane = new APane();
        root.getChildren().add(anchorpane.getContent());
	}
	
	
	private void createBoard() {
		GridPane grid = new GridPane();

		grid.setPadding(new Insets(20));
	    grid.setHgap(Controller_Game.SIZE);
	    grid.setVgap(Controller_Game.SIZE);

		this.buttBoard = new Button[Controller_Game.SIZE][Controller_Game.SIZE];

		for(int index = 0, index1 = 0; index1 < Controller_Game.SIZE ; index1++) {
			for(int index2 = 0; index2 < Controller_Game.SIZE ; index2++) {
				buttBoard[index1][index2] = new Button(Integer.toString(index));
				grid.add(new Button(), index1, index2);
				index ++;
			}
		}
		// to root or scene 
	}
	

	@Override
	public void update(Observable o, Object arg) {
		
		
	}
}
