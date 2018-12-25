package view;

import view.game.View_Game;

public class View_Manager {

	private View_Game view_game;
	

	public View_Manager() {
		view_game = new View_Game();
	}
	
	
	public View_Game getView_game() {
		return view_game;
	}
	
}