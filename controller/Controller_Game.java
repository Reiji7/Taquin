package controller;

import model.game.Model_Board;
import model.game.Model_Player;
import resources.Configuration;

/**
 * Game controller containing basic game mechanics
 * @see model.game
 * @author Adrien
 * @version 1.0 
 */
public class Controller_Game {

	private Model_Board board;
	private Model_Player p1;
	private boolean format;
	
	public static int SIZE;
	
	
	public void start() {
		do {
			try {
				format = true;
				System.out.println("How size is your grid ?");
				SIZE = Configuration.sc.nextInt();
			}catch(java.util.InputMismatchException e) {
				format = false;
			}
		}while(!format);

		
		do {
			try {
				format = true;
				System.out.println("What's your name ?");
				Configuration.sc.nextLine();
				this.p1 = new Model_Player(Configuration.sc.nextLine());
			}catch(java.util.InputMismatchException e) {
				format = false;
			}
		}while(!format);

		
		this.board = new Model_Board();
		board.shuffle();
		board.out();
		
		play();
	}
	
	
	public void play() {
		int depart = 0, destination = 0;
		
		do {
			do {
				try {
					format = true;
					System.out.println(p1.getName() + " what piece you want to move ?");
					depart = Configuration.sc.nextInt();
				}catch(java.util.InputMismatchException e) {
					format = false;
				}
			}while(!format);
			
			
			do {
				try {
					format = true;
					System.out.println(p1.getName() + " where do you want to move ?");
					destination = Configuration.sc.nextInt();
				}catch(java.util.InputMismatchException e) {
					format = false;
				}
			}while(!format);
			
			board.play(depart, destination);
			board.out();
			p1.setScore(board.getMoves());
		}while(!board.check());
	}

}