package controller;

import model.game.Model_Board;
import model.game.Model_Player;
import resources.Configuration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Game controller containing basic game mechanics
 * @see model.game
 * @author Adrien
 * @version 1.0 
 */
public class Controller_Game implements Serializable{

	private Model_Board board;
	private Model_Player p1;
	private boolean format;
	private String move = "";
	
	public static int SIZE;
	
	public Model_Board getBoard() {
		return(this.board);
	}
	
	public void start() throws IOException {
		
		/**
		ObjectInputStream ois = null;
		
		boolean initialize = initialize();
		
		
		boolean formatDeserialization1 = true;

		// faire modif pour que ça soit demander seulement si le joueur le demande
		if (!initialize){
			
			// Deserialization board
			do {
				try {
					formatDeserialization1 = true;
					final FileInputStream fichierIn = new FileInputStream("C://Users//Christian poratble//git//Taquin//board.ser");
					ois = new ObjectInputStream(fichierIn);
					board = (Model_Board)ois.readObject();
				} catch (final java.io.FileNotFoundException e) {
					System.out.println("Sorry neither game find, create a new game please");
				} catch (final ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						if (ois != null) {
						ois.close();
						}
					} catch (final IOException ex) {
					ex.printStackTrace();
					}
				}
			}while(!formatDeserialization1);
			
			// Deserialization Player
			try {
				final FileInputStream fichierIn = new FileInputStream("C://Users//Christian poratble//git//Taquin//p1.ser");
				ois = new ObjectInputStream(fichierIn);
				p1 = (Model_Player)ois.readObject();
			} catch (final java.io.FileNotFoundException e) {
				System.out.println(" ");
				
				do {
					try {
						format = true;
						System.out.println("How size is your grid ?");
						
						SIZE = Configuration.sc.nextInt();
						
						if (SIZE < 3) {
							format = false;

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
					if (ois != null) {
					ois.close();
					}
				} catch (final IOException ex) {
				ex.printStackTrace();
				}
			}	
			
		}else {
		**/
			do {
				try {
					format = true;
					System.out.println("How size is your grid ?");
					
					SIZE = Configuration.sc.nextInt();
					
					if (SIZE < 3) {
						format = false;

					}
					
				}catch(java.util.InputMismatchException e) {
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
				}catch(java.util.InputMismatchException e) {
					format = false;
				}
			}while(!format);
	
			
			this.board = new Model_Board();
			board.shuffle();
	
			while(board.check()){
				board.shuffle();
			}
			
		/**
		}
		**/
				
		board.out();
					
		play();
				
	}
	
	
	public boolean initialize() {
		
		// if file exist return false and the game load the game
		try {
			
			Path pathBoard = Paths.get("C://Users//Christian poratble//git//Taquin//board.ser");
			Path pathPlayer = Paths.get("C://Users//Christian poratble//git//Taquin//p1.ser");
			
			return (false);
			
		// if file doesn't exist, return true and create a new game	
		} catch(Exception FileNotFoundException) {
			return (true);
		}
	}
	
	
	public void play() {
		move = "";
		do {
			
			do {
				try {
					format = true;
					move = "";
					System.out.println(p1.getName() + " how do you want move ?");
					move = Configuration.sc.nextLine();

				}catch(java.util.InputMismatchException e) {
					format = false;
				}
			}while(!format);
			
			if(move.equals("save")) {
								
				ObjectOutputStream oos = null;
			
				//Serialization board
				try {
					final FileOutputStream fichier = new FileOutputStream("board.ser");
					oos = new ObjectOutputStream(fichier);
					oos.writeObject(board);
					oos.flush();
				} catch (final java.io.IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (oos != null) {
						oos.flush();
						oos.close();
						}
					} catch (final IOException ex) {
					ex.printStackTrace();
					}
				}
				
				//Serialization player
				ObjectOutputStream oos2 = null;
				try {
					final FileOutputStream fichier = new FileOutputStream("p1.ser");
					oos2 = new ObjectOutputStream(fichier);
					oos2.writeObject(p1);
					oos2.flush();
				} catch (final java.io.IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (oos2 != null) {
						oos2.flush();
						oos2.close();
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

}