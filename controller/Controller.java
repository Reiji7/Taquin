package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;

import model.game.Model_Board;
import model.game.Model_Piece;
import model.game.Model_Player;
import resources.Configuration;

public abstract class Controller extends Observable implements Serializable{

	private static final long serialVersionUID = 6310221332167444950L;
	
	private FileInputStream testExistFile;

	private ObjectInputStream oisBoard = null;
	private ObjectInputStream oisBoardPosZ = null;
	private ObjectInputStream oisBoardTime = null;
	
	private ObjectInputStream oisP1Name = null;
	private ObjectInputStream oisP1Score = null;
	

	
	public boolean initialize() {
		
		// if file exist return false and the game load the game
		try {
			
			testExistFile = new FileInputStream("..//Taquin//board.ser");
			
			return (false);
			
		// if file doesn't exist, return true and create a new game	
		} catch(Exception FileNotFoundException) {
			return (true);
		}
	}
	
	// return nothing because he save just the game, just a textual notification of the save
	public void serialisationGame (Model_Board board, Model_Player p1) {
		
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
	
	// Must return elements
	public void deserialisationGame () throws IOException {
	
		Model_Board board = new Model_Board();
		boolean formatDeserialization1 = true;
		boolean format = false;
		
		// Deserialization board
		Model_Piece[][] boardSave = null;
		do {
			try {
				formatDeserialization1 = true;
				final FileInputStream fichierInBoard = new FileInputStream("..//Taquin//board.ser");
				oisBoard = new ObjectInputStream(fichierInBoard);
				boardSave = (Model_Piece[][])oisBoard.readObject();			
				
				final FileInputStream fichierBoardPosZ = new FileInputStream("..//Taquin//boardPosZ.ser");
				oisBoardPosZ = new ObjectInputStream(fichierBoardPosZ);
				int boardSavePosZ[] = (int[])oisBoardPosZ.readObject();
				
				final FileInputStream fichierBoardTime = new FileInputStream("..//Taquin//boardTime.ser");
				oisBoardTime = new ObjectInputStream(fichierBoardTime);
				long boardSaveTime = (long)oisBoardTime.readObject();
								
				Controller_Game.SIZE = boardSave.length;			
				
			} catch (final java.io.FileNotFoundException e) {
				System.out.println("Sorry neither game find, create a new game please");
			} catch (final ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if(oisBoardPosZ != null) {
						oisBoardPosZ.close();
					}
					if(oisBoardTime != null) {
						oisBoardTime.close();
					}
					if(oisBoard != null) {
						oisBoard.close();
					}
				} catch (final IOException ex) {
					ex.printStackTrace();
				}
			}
			
			for(int i = 0; i < Controller_Game.SIZE ;i++) {
				for(int j = 0; j < Controller_Game.SIZE ;j++) {
					int number = boardSave[i][j].getNumber(); 
					board.setBoard(i,j,number);
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

			Model_Player p1 = new Model_Player(playerNameSave, playerScoreSave);
			
			System.out.println("Game load");
			
		} catch (final java.io.FileNotFoundException e) {
			System.out.println(" ");
			
			do {
				try {
					format = true;
					System.out.println("How size is your grid ?");
					
					Controller_Game.SIZE = Configuration.sc.nextInt();
					
					if (Controller_Game.SIZE < 4) {
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
					Model_Player p1 = new Model_Player(Configuration.sc.nextLine());
				}catch(java.util.InputMismatchException excep) {
					format = false;
				}
			}while(!format);
			
			board = new Model_Board();
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
	}
}