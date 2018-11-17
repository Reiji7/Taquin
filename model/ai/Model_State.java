package model.ai;

import controller.Controller_Game;
import model.game.Model_Board;
import model.game.Model_Piece;

public class Model_State {
	private String name;
	private int nbPieces; //the number of pieces that aren't on their target location
	public Model_Board boarder;
	
	/*
	 * constructors of Model_State
	 */
	public Model_State() {
		this.boarder = new Model_Board();
		this.nbPieces = 0;
	}
	
	public Model_State(Model_State s){
	     nbPieces = s.countNbPieces(); 
	 	 boarder = s.boarder;
	    }
	
	/*
	 * getters and setters of Model_State
	 */
	public String getName() {
		return this.name;
	}
	public void setName(String n) {
		this.name = n;
	}
	public Model_Piece[] getBoarder() {
		return this.boarder.getBoard();
	}
	
	public int getNbPieces() {
		return this.nbPieces;
	}
	
	public void setNbPieces(int n) {
		this.nbPieces = n;
	}
	
	
	/*
	 * methods of Model_State
	 */
	
	/*
	 * check if the current state is valid or not. okay but WDYM BY VALID?
	 */
	public boolean isValid() {
		boolean valid = false;
		while (valid) {
			
		}
		return valid;	//method is imcomplete
	}
	
	/*
	 * print out all informations about the current state
	 * completed by method print in Model_Node
	 */
    public void print(){
	System.out.println("Name of the current State: "+name);
	System.out.println("Number of misplaced pieces left: "+nbPieces);
    }
    
    /*
     * return the number of misplaced pieces left in the current state
     */
    public int countNbPieces() {
    	int nb = 0;
    	for(int index = 0; index < Controller_Game.SIZE * Controller_Game.SIZE; index++) {
    		if (this.boarder.getBoard()[index].getNumber()!= index) {
    			nb++;
    		}
    	}
    	
    	return (nb);
    }
	
	/*
	 * check if the current state is the goal state a.k.a if the current state is the solved taquin game
	 */
    public boolean isGoal(Model_Problem pb) {
    	Model_State p = new Model_State();
    	p = pb.getGoalState();
    	return (p==this);	
    }
    
    /*
     * check if the current state is the same as the state given in parameters
     */
    public boolean isEqual(Model_State s) {
    	return (s==this);
    }
    
    /*
     * execute a given action on the current state
     */
    public Model_State executeAction(Model_Action a, Model_Problem p) {
    	Model_State s = new Model_State();
    	if(a.getAction()=="up") {
    		this.boarder.play("up");
    	}
    	else if(a.getAction()=="down") {
    		this.boarder.play("down");
    	}
    	else if(a.getAction()=="left") {
    		this.boarder.play("left");
    	}
    	else if(a.getAction()=="right") {
    		this.boarder.play("right");
    	}
    	return(s);
    }
	
}
