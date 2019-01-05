package model.game;


import controller.Controller_Game;
import model.Model;
import resources.Position;

/**
 * Basic game mechanics
 * @version 1.0 
 */
public class Model_Board extends Model{

	private static final long serialVersionUID = -8157892195810236408L;
	private Model_Piece[][] board;
	private int moves;
	private Position posZ;
	private long time;
	
	
	public Model_Board() {
		this.board = new Model_Piece[Controller_Game.SIZE][Controller_Game.SIZE];
		this.moves = 0;
		this.time = System.currentTimeMillis();
		this.posZ = new Position();
				
		for(int index = 0, index1 = 0; index1 < Controller_Game.SIZE ; index1++) {
			for(int index2 = 0; index2 < Controller_Game.SIZE ; index2++) {
				board[index1][index2] = new Model_Piece(index);
				index ++;
			}
		}
	}
	
	public Model_Board(Model_Piece[][] boardSave, Position posZSave) {
		this.board = boardSave;
		this.moves = 0;
		this.posZ = posZSave;
	}
		
	
	/**
	 * Give number of move in this game
	 * @return move
	 */
	public int getMoves() {
		return this.moves;
	}
	
	public Position getPosZ () {
		return this.posZ;
	}
	
	public void setBoard(int x, int y, int number) {
		this.board[x][y] = new Model_Piece(number);
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
		for(int index1 = 0; index1 < Controller_Game.SIZE ; index1++) {
			for(int index2 = 0; index2 < Controller_Game.SIZE ; index2++) {
				if(board[index1][index2].getNumber() == 0){
					this.posZ.x = index1;
					this.posZ.y = index2;
				}
			}
		}
	}

	
	/**
	 * Give board status
	 */
	public Model_Piece[][] getBoard(){
		return this.board;
	}
	
	public Model_Piece getBoard(int x,int y){
		return this.board[x][y];
	}
	
	
	/**
	 * Play a turn
	 * @param depart
	 * @param destination
	 * @return 
	 */
	public boolean play(String move) {
		int index = posZ.x * Controller_Game.SIZE + posZ.y;
		switch(move) {
		case "up":
			if(index + Controller_Game.SIZE < (Controller_Game.SIZE * Controller_Game.SIZE)) {
				this.moves++;
				return move(index + Controller_Game.SIZE);
			}
		break;
		
		case "down":
			if(index - Controller_Game.SIZE > -1 ) {
				this.moves++;
				return move(index - Controller_Game.SIZE);
			}
		break;
		
		case "left":
			if(((index+1) % Controller_Game.SIZE) != 0) {
				this.moves++;
				return move(index + 1);
			}
		break;
		
		case "right":
			if(index % Controller_Game.SIZE != 0) {
				this.moves++;
				return move(index - 1);
			}
		break;
		case "save":
			return true;	
		}
		return false;
	}

	
	/**
	 * Move a piece on board from move
	 * @param depart
	 * @param destination
	 * @return
	 */
	private boolean move(int destination) {
		return move(posZ.x + posZ.y * Controller_Game.SIZE, destination);
	}
	
	
	/**
	 * checking board if he's in final state
	 * @return 
	 */
	public boolean check() {
		
		boolean test = true;
		int index = 1;
		
		if ((this.board[0][0].getNumber() == 1)&&(board[Controller_Game.SIZE-1][Controller_Game.SIZE-1].getNumber() == 0)) { 
				
			while(test = true && index < ((Controller_Game.SIZE)*2)) {
				for(int index1 = 0; index1 < Controller_Game.SIZE ; index1++) {
					for(int index2 = 0; index2 < Controller_Game.SIZE ; index2++) {
						test = (board[index1][index2].getNumber() == index);
						index ++;	
					}				
				}
			}
			if(test == true) {
				return true;
			}
			else {
				return false;
			}
		}	
		else {
			return false;
		}
	}
	
	/**
	 * Move a piece on board from shuffle
	 * @param depart
	 * @param destination
	 * @return
	 */
	private boolean move(int depart, int destination) {
		try {
			int departX = (int)depart / Controller_Game.SIZE,
					departY = depart % Controller_Game.SIZE,
					destinX = (int)destination / Controller_Game.SIZE,
					destinY = destination % Controller_Game.SIZE;
			
			Model_Piece tampon = board[destinX][destinY];
			board[destinX][destinY] = board[departX][departY];
			board[departX][departY] = tampon;
			
			this.posZ.x = destinX;
			this.posZ.y = destinY;
			
			return true;
		}
		catch(java.lang.Exception e ) {}
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
				if(board[index1][index2].getNumber() < 10)
					System.out.print(" 0" + board[index1][index2].getNumber() + " ");
				else
					System.out.print(" " + board[index1][index2].getNumber() + " ");
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