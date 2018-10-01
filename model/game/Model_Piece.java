package model.game;


/**
 * Piece that can be moved by the player
 * @author Adrien
 * @version 1.0 
 */
public class Model_Piece {

	private int number; 	// Piece's number

	
	public Model_Piece(int number) {
		this.number = number;
	}
	
	/**
	 * Give piece's number
	 * @return piece's number
	 */
	public int getNumber() {
		return this.number;
	}
}