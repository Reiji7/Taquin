package model.game;

import java.io.Serializable;
import java.util.Observable;

/**
 * Player who can move pieces
 * @author Adrien
 * @version 1.0 
 */
public class Model_Player extends Observable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6820116923434799219L;
	public static String name;	// Player's name
	private int nbMoves;

	
	public Model_Player(String name) {
		this.name = name;
		this.nbMoves = 0;
	}
	
	
	/**
	 * Give name
	 * @return player's name
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * Give Score
	 * @return score
	 */
	public int getNbMoves() {
		return this.nbMoves;
	}
	
	
	/**
	 * Modify Score
	 * @param add
	 */
	public void setNbMoves(int moves) {
		nbMoves = nbMoves + 1 ;
	}
	
}