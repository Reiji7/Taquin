package model.ai;

import java.util.ArrayList;
import controller.Controller_Game;
import model.game.Model_Board;

public class Model_Problem {
	private Model_State goal, start, current;
	private ArrayList<Model_Action> list;
	
	
	/*
	 * constructor of Model_Problem
	 * initializes the problem with goal state from the board and with start and current state from the game controller
	 * it means that at the beginning of the game, start=current
	 */
	 public Model_Problem(Controller_Game cg){
			list = setActions();
			goal = new Model_State();   
			goal.setName("goal"); 
			goal.boarder = new Model_Board();
			
			start = new Model_State();	
			start.setName("start");
			start.setNbPieces(start.countNbPieces());
			start.boarder = cg.getBoard();
			
			current = new Model_State();
			current.setName("current");
			current.boarder = cg.getBoard();
			current.setNbPieces(current.countNbPieces());
	 }
	 
	 /*
	  * getters and setters of Model_Problem
	  */
	 
	 /*
	  * return initial state of the taquin game
	  */
	 public Model_State getInitialState() {
		 return(start);
	 }
	 
	 /*
	  * set initial state of the taquin game with the state given in parameters
	  */
	 public void setInitialState(Model_State s) {
		 this.start = s;
	 }
	 
	 /*
	  * return goal state of the taquin game
	  */
	 public Model_State getGoalState() {
		 return(goal);
	 }
	 
	 /*
	  * set goal state of the taquin game with the state given in parameters
	  */
	 public void setGoalState(Model_State g) {
		 this.goal = g;
	 }
	 
	 /*
	  * return current state of the taquin game
	  */
	 public Model_State getCurrentState() {
		 return(current);
	 }
	 
	 /*
	  * set current state of the taquin game with the state given in parameters
	  */
	 public void setCurrentState(Model_State c) {
		 this.current = c;
	 }
	 
	 /*
	  * return the list of actions of the taquin game
	  */
	 public ArrayList<Model_Action> getListOfActions(){
			return(list);
		    }
	 
	 /*
	  * set the list of actions possible in the taquin game, a.k.a moving the blank piece left/right/up/down
	  */
	 public ArrayList<Model_Action>setActions(){
		 ArrayList<Model_Action> list = new ArrayList<Model_Action>();
		 Model_Action a;
		 a = new Model_Action();
		 a.setAction("up");
		 list.add(a);
		 a = new Model_Action();
		 a.setAction("down");
		 list.add(a);
		 a = new Model_Action();
		 a.setAction("left");
		 list.add(a);
		 a = new Model_Action();
		 a.setAction("right");
		 list.add(a);
		 return(list);
	 }
	 
	 /*
	  * methods for Model_Problem
	  */
	 
	 /*
	  * update the current state after each move
	  */
	 public void updateCurrent(Controller_Game cg) {
		 current.boarder = cg.getBoard();
		 current.setNbPieces(current.countNbPieces());
	 }

}
