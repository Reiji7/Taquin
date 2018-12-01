package model.game;

import java.io.Serializable;

/**
 * Piece that can be moved by the player
 * @author Adrien
 * @version 1.0 
 */
public class Model_Piece implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7312296235716773696L;
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
	
	@Override
	public String toString() {
		return Integer.toString(number);
	}
}