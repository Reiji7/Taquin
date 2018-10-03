package model.game;

import controller.Controller_Game;

/**
 * Basic game mechanics
 * @author Adrien
 * @version 1.0 
 */
public class Model_Board {

	private Model_Piece[] board;
	private int moves;
	private long time;
	
	
	public Model_Board() {
		this.board = new Model_Piece[Controller_Game.SIZE * Controller_Game.SIZE];
		this.moves = 0;
		this.time = System.currentTimeMillis();
		
		for(int index = 0; index < Controller_Game.SIZE * Controller_Game.SIZE; index++) {
			board[index] = new Model_Piece(index);
		}
	}
		
	
	/**
	 * Give number of move in this game
	 * @return move
	 */
	public int getMoves() {
		return this.moves;
	}
	
	
	/**
	 * Give time of this game
	 * @return 
	 */
	public long getTime() {
		return this.time;
	}
	
	
	/**
	 * Shuffle board and init Score
	 */
	public void shuffle() {
		for(int index = 0; index < board.length; index ++) {
			move(index, (int)(Math.random() * Controller_Game.SIZE * Controller_Game.SIZE));
		}
	}

	
	/**
	 * Give board status
	 */
	protected Model_Piece[] getBoard(){
		return this.board;
	}
	
	
	/**
	 * Play a turn
	 * @param depart
	 * @param destination
	 * @return 
	 */
	public boolean play(int depart, int destination) {
		if(board[depart].getNumber() == 0 || board[destination].getNumber() == 0) {
			if(depart == destination + 1 ||
					depart == destination - 1 ||
					depart == destination + Controller_Game.SIZE ||
					depart == destination - Controller_Game.SIZE ) {

				this.moves++;
				
				return move(depart, destination);
			}
		}
		
		return false;
	}

	
	/**
	 * Move a piece on board
	 * @param depart
	 * @param destination
	 * @return
	 */
	private boolean move(int depart, int destination) {
		if(destination >= 0 && destination <= Controller_Game.SIZE * Controller_Game.SIZE -1) {
			Model_Piece tampon = board[destination];
			board[destination] = board[depart];
			board[depart] = tampon;
			
			return true;
		}
		
		return false;
	}

	
	public boolean check() {
		if(board[0].getNumber() == 1 && board[Controller_Game.SIZE - 1].getNumber() == 0) {
			for(int index = 0; index < Controller_Game.SIZE; index++) {				// peut etre mettre la taille en moin 1
				if(board[index].getNumber() != board[index+1].getNumber() + 1) {
					return false;
				}
			}
			System.out.println("You win !");
			return true;
		}
		return false;
	}


	/**
	 *  Set score to 0
	 */
	public void init() {
		this.moves = 0;
		this.time = System.currentTimeMillis();
	}


	/**
	 * Display board
	 */
	public void out() {
		
		System.out.print("|");
		for(int index1 = 0; index1 < Controller_Game.SIZE; index1++) {
			System.out.print("----");
		}
		System.out.println("|");
		
		for(int index1 = 0; index1 < Controller_Game.SIZE; index1++) {
			System.out.print("|");
			for(int index2 = 0; index2 < Controller_Game.SIZE; index2++) {
				int position = Controller_Game.SIZE * index1 + index2;
				if(board[position].getNumber() < 10)
					System.out.print(" 0" + board[position].getNumber() + " ");
				else
					System.out.print(" " + board[position].getNumber() + " ");
			}
			System.out.println("|");
		}
		
		System.out.print("|");
		for(int index1 = 0; index1 < Controller_Game.SIZE; index1++) {
			System.out.print("----");
		}
		System.out.println("|");

	}
}