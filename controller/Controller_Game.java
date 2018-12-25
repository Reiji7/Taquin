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


	public void start() {
		
	}
	

	/**
	public void start() throws IOException {	
		do {
			board.out();
			p1.setNbMoves(board.getMoves());

		}while(!board.check());	
	}

	
	public void start() throws IOException {
		
		
		ObjectInputStream oisBoard = null;
		ObjectInputStream oisBoardPosZ = null;
		ObjectInputStream oisBoardTime = null;
		
		ObjectInputStream oisP1Name = null;
		ObjectInputStream oisP1Score = null;
		
		boolean initialize = initialize();

		boolean load = false;
		boolean test = false;
		
		//System.out.println(initialize);
		
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
		
		boolean formatDeserialization1 = true;
		
		if (!initialize && load == true){

			// Deserialization board
			do {
				try {
					formatDeserialization1 = true;
					final FileInputStream fichierInBoard = new FileInputStream("..//Taquin//board.ser");
					oisBoard = new ObjectInputStream(fichierInBoard);
					Model_Piece[][] boardSave = (Model_Piece[][])oisBoard.readObject();			
					
					final FileInputStream fichierBoardPosZ = new FileInputStream("..//Taquin//boardPosZ.ser");
					oisBoardPosZ = new ObjectInputStream(fichierBoardPosZ);
					int boardSavePosZ[] = (int[])oisBoardPosZ.readObject();
					
					final FileInputStream fichierBoardTime = new FileInputStream("..//Taquin//boardTime.ser");
					oisBoardTime = new ObjectInputStream(fichierBoardTime);
					//long boardSaveTime = (long)oisBoardTime.readObject();
					
					// Probleme a voir 
					//this.board = new Model_Board(boardSave, boardSavePosZ);
					
					SIZE = boardSave.length;			

					for(int i = 0; i < SIZE ;i++) {
						for(int j = 0; j < SIZE ;j++) {
							int number = boardSave[i][j].getNumber(); 
							board.setBoard(i,j,number);
						}
					}			
				} catch (final java.io.FileNotFoundException e) {
					System.out.println("Sorry neither game find, create a new game please");
				} catch (final ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						if (oisBoard != null) {
							oisBoard.close();
						}
					} catch (final IOException ex) {
					ex.printStackTrace();
					}
				}
			}while(!formatDeserialization1);
			
			// Deserialization Player
			try {
				final FileInputStream fichierInP1Name = new FileInputStream("..//Taquin//p1Name.ser");
				oisP1Name = new ObjectInputStream(fichierInP1Name);
				String playerNameSave = (String)oisP1Name.readObject();
				
				final FileInputStream fichierInP1Score = new FileInputStream("..//Taquin//p1Score.ser");
				oisP1Score = new ObjectInputStream(fichierInP1Score);
				int playerScoreSave = (int)oisP1Score.readObject();

				this.p1 = new Model_Player(playerNameSave, playerScoreSave);
				
				System.out.println("Game load");
				
			} catch (final java.io.FileNotFoundException e) {
				System.out.println(" ");
				
				do {
					try {
						format = true;
						System.out.println("How size is your grid ?");
						
						SIZE = Configuration.sc.nextInt();
						
						if (SIZE < 4) {
							format = false;
							System.out.println("Error, please entire a size bigger than 3");
						}
						
					}catch(java.util.InputMismatchException excep) {
						format = false;
						Configuration.sc.nextLine();
					}
				}while(!format);
		
				
				do {
					try {
						format = true;
						System.out.println("What's your name ?");
						Configuration.sc.nextLine();
						this.p1 = new Model_Player(Configuration.sc.nextLine());
					}catch(java.util.InputMismatchException excep) {
						format = false;
					}
				}while(!format);
		
				
				this.board = new Model_Board();
				board.shuffle();
		
				while(board.check()){
					board.shuffle();
				}
				
			} catch (final ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (oisBoard != null) {
						oisBoard.close();
					}
				} catch (final IOException ex) {
				ex.printStackTrace();
				}
			}	
			
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
	
	
	public boolean initialize() {
		
		// if file exist return false and the game load the game
		try {
			
			final FileInputStream test = new FileInputStream("..//Taquin//board.ser");
			
			return (false);
			
		// if file doesn't exist, return true and create a new game	
		} catch(Exception FileNotFoundException) {
			return (true);
		}
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
								
				ObjectOutputStream oosBoard = null;
				ObjectOutputStream oosPosZ = null;
				ObjectOutputStream oosBoardTime = null;
				
				//Serialization board
				try {
					final FileOutputStream fichierBoard = new FileOutputStream("board.ser");
					oosBoard = new ObjectOutputStream(fichierBoard);
					oosBoard.writeObject(board.getBoard());
					oosBoard.flush();
					
					final FileOutputStream fichierBoardPosZ = new FileOutputStream("boardPosZ.ser");
					oosPosZ = new ObjectOutputStream(fichierBoardPosZ);
					oosPosZ.writeObject(board.getPosZ());
					oosPosZ.flush();
					
					final FileOutputStream fichierBoardTime = new FileOutputStream("boardTime.ser");
					oosBoardTime = new ObjectOutputStream(fichierBoardTime);
					oosBoardTime.writeObject(board.getPosZ());
					oosBoardTime.flush();

				} catch (final java.io.IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (oosBoard != null) {
							oosBoard.flush();
							oosBoard.close();
						}
					} catch (final IOException ex) {
					ex.printStackTrace();
					}
					
					try {
						if (oosPosZ != null) {
							oosPosZ.flush();
							oosPosZ.close();
						}
					} catch (final IOException ex) {
					ex.printStackTrace();
					}
				}
				
				//Serialization player
				ObjectOutputStream oosP1Name = null;
				ObjectOutputStream oosP1Score = null;
				
				try {
					final FileOutputStream fichierP1Name = new FileOutputStream("p1Name.ser");
					oosP1Name = new ObjectOutputStream(fichierP1Name);
					oosP1Name.writeObject(p1.getName());
					oosP1Name.flush();
					
					final FileOutputStream fichierP1Score = new FileOutputStream("p1Score.ser");
					oosP1Score = new ObjectOutputStream(fichierP1Score);
					oosP1Score.writeObject(p1.getNbMoves());
					oosP1Score.flush();
					
				} catch (final java.io.IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (oosP1Name != null) {
							oosP1Name.flush();
							oosP1Name.close();
						}
					} catch (final IOException ex) {
					ex.printStackTrace();
					}
					
					try {
						if (oosP1Score != null) {
							oosP1Score.flush();
							oosP1Score.close();
						}
					} catch (final IOException ex) {
					ex.printStackTrace();
					}
				}
				
				System.out.println("Game saves");
				
			}
			else if(!board.play(move)) {
				System.out.println("Bad entry !");
			}
			
			board.out();
			p1.setNbMoves(board.getMoves());

		}while(!board.check());
	}
	**/
}