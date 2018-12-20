package controller;

import java.io.IOException;

import model.Model_Manager;
import view.View_Game;
import view.View_Manager;


public class Controller_Main{

	private Controller_Game controller_game;
	private View_Game view_game;
	
	
	public Controller_Main(Model_Manager model, View_Manager view) {
		controller_game = new Controller_Game(model.getMb(), model.getMp());
		view_game = view.getView_game();
		
		model.getMb().addObserver(view.getView_game());
		//view_game.addActionListener(controller_game);
	}


	public void start() throws IOException {
		controller_game.start();
	}

}