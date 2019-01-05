package controller;

import model.game.Model_Board;
import model.game.Model_Piece;
import model.game.Model_Player;
import resources.Configuration;
import resources.Position;
import view.game.View_Game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.event.EventHandler;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Game controller containing basic game mechanics
 * @see model.game
 * @version 1.0 
 */
public class Controller_Game extends Controller{

	private View_Game view;
	private Model_Board board;
	private Model_Player p1;
	private boolean format;
	private String move = "";
	
	public static int SIZE = 4;
	
	public Model_Board getBoard() {
		return(this.board);
	}
	
	
	public Controller_Game(Model_Board mb, Model_Player mp) {
		this.board = mb;
		this.p1 = mp;
	}
	
	
	public Controller_Game(View_Game view) {
		this.view = view;
	}
	
	
	private void listenAllButtons(){
		for(int i=0; i< Controller_Game.SIZE; i++){
			for(int j=0; j < Controller_Game.SIZE; j++){
				listenButton(view.getGrid().getButton(
						new Position(i, j)), new Position(i, j));
			}
		}
	}
	
	
	
	
	private void listenButton(Button button, Position position){
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
	        	   updateClickedButton(button, position);
			}
	    });
	}

	
	private void updateClickedButton(Button button, Position position){
		
		
		
		setChanged();
   		notifyObservers();
	}

	/**
	public void start() {
		
	}
	

	public void start() throws IOException {	
		do {
			board.out();
			p1.setNbMoves(board.getMoves());

		}while(!board.check());	
	}
**/
	
	public void start() throws IOException {
				
		boolean initialize = initialize(); 			// method in Controller
		
		boolean load = false;
		boolean test = false;
		
		if (!initialize){
			do{
				format = true;
				System.out.println("Do you want load the last game ? [y][n] ");
				String answerLoad = Configuration.sc.nextLine();
				switch(answerLoad) {
				 case "y":
				 	load = true;
				 	test = true;
				 	break;
				 
				 case "n":
				 	load = false;
				 	test = true;
				 	break;
				 	
				 default:
				 	System.out.println("Error");		
				}
			}while(test==false);
		}

		
		if (load == true){

			deserialisationGame();
			
		}else {

			do {
				try {
					format = true;
					System.out.println("How size is your grid ?");
					
					SIZE = Configuration.sc.nextInt();
					
					if (SIZE < 4) {
						format = false;
						System.out.println("Error, please entire a size bigger than 3");

					}
					
				}catch(java.util.InputMismatchException e) {
					format = false;
					Configuration.sc.nextLine();
				}
			}while(!format);
	
			format = false;
			do {
				try {
					Configuration.sc.nextLine();
					format = true;
					System.out.println("What's your name ?");
					this.p1 = new Model_Player(Configuration.sc.nextLine());
				}catch(java.util.InputMismatchException e) {
					format = false;
				}
			}while(!format);
	
			
			this.board = new Model_Board();
			board.shuffle();
		}

		board.out();	
		play();

	}	
	
	public void play() {
		do {
			do {
				try {
					format = true;
					move = new String();
					System.out.println(p1.getName() + " how do you want move ?");
					move = Configuration.sc.nextLine();

				}catch(java.util.InputMismatchException e) {
					format = false;
				}
			}while(!format);
			
			if(move.equals("save")) {
								
				serialisationGame(board, p1);
				
			}
			else if(!board.play(move)) {
				System.out.println("Bad entry !");
			}
			
			board.out();
			p1.setNbMoves(board.getMoves());

		}while(!board.check());
	}

}