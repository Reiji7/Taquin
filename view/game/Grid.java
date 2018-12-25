package view.game;

import controller.Controller_Game;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import resources.Position;


public class Grid {

	private Button buttBoard[][];

	
	public Node createBoard() {
		GridPane grid = new GridPane();

		grid.setPadding(new Insets(20));
	    grid.setHgap(Controller_Game.SIZE);
	    grid.setVgap(Controller_Game.SIZE);
	    
		this.buttBoard = new Button[Controller_Game.SIZE][Controller_Game.SIZE];
		
		for(int index = 0, index1 = 0; index1 < Controller_Game.SIZE ; index1++) {
			for(int index2 = 0; index2 < Controller_Game.SIZE ; index2++) {
				buttBoard[index1][index2] = createButton(Integer.toString(index));
				grid.add(buttBoard[index1][index2], index1, index2);
				
				index ++;
			}
		}
		return grid;
	}
	
	
	public Button getButton(Position p){
		return this.buttBoard[p.x][p.y];
	}
	
	
	private Button createButton(String buttonName){
		
		Button button = new Button(buttonName);	
		button.setMinHeight(50.0);
		button.setMinWidth(50.0);
		return button;
	}
}
