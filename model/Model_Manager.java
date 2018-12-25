package model;

import model.game.Model_Board;
import model.game.Model_Player;
import resources.Configuration;


public class Model_Manager {

	private Model_Board mb;
	private Model_Player mp;
	
	
	public Model_Manager() {
		this.mb = new Model_Board();
		this.mp = setPlayer();
	}
	
	
	public Model_Board getMb() {
		return mb;
	}


	public Model_Player getMp() {
		return mp;
	}
	
	
	private Model_Player setPlayer() {
		boolean format;
		Model_Player mp = null;
		do {
			try {
				format = true;
				System.out.println("What's your name ?");
				
				mp = new Model_Player("Bob !");
				//mp = new Model_Player(Configuration.sc.nextLine());
			}catch(java.util.InputMismatchException e) {
				format = false;
			}
		}while(!format);

		return mp;
	}
}
