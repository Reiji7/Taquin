package model.game;


/**
 * Player who can move pieces
 * @author Adrien
 * @version 1.0 
 */
public class Model_Player {
	
	private String name;	// Player's name
	
	
	public Model_Player(String name) {
		this.name = name;
	}
	
	
	/**
	 * Give name
	 * @return player's name
	 */
	public String getName() {
		return this.name;
	}
}