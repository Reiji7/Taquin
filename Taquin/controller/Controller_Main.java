package controller;

public class Controller_Main {

	private Controller_Game controller_game;
	
	public void start() {
		controller_game = new Controller_Game();
		controller_game.start();
	}
}
