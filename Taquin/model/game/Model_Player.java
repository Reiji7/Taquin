package model.game;


/**
 * Player who can move pieces
 * @author Adrien
 * @version 1.0 
 */
public class Model_Player {
	
	private String name;	// Player's name
	private int score;

	
	public Model_Player(String name) {
		this.name = name;
		this.score = 10000;
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
	public int getScore() {
		return this.score;
	}
	
	
	/**
	 * Modify Score
	 * @param add
	 */
	public void setScore(int moves) {
		//setScore(-(moves * 2));
	}
	
	public void init() {
		score  = 10000;
	}
}