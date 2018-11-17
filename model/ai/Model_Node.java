package model.ai;

import java.util.ArrayList;

public class Model_Node {
	private Model_State state;
	private ArrayList<Model_Action> moves;	// the list of moves that brought the player to the current state
	
	/*
	 * constructors of Model_Node
	 */
	
	/*
	 * is the first constructor really necessary? 
	 */
    public Model_Node(){
    	this.state = new Model_State();
    	this.moves = null;
    }
    
	public Model_Node(Model_State s, ArrayList<Model_Action>  la){
			int i;
			this.state = new Model_State();
			this.moves = new ArrayList<Model_Action>();
			if(la!= null)
				for (i = 0; i < la.size(); i++)
					this.moves.add(la.get(i));
	}
	
    /*
     * getters and setters of Model_Node
     */
    public Model_State getState(){
    	return(this.state);
    }
    public ArrayList<Model_Action> getListofActions(){
    	return(this.moves);
    }
    public void setState(Model_State s){
    	this.state = s;
    }

    /*
     * methods of Model_Node
     */
    
    /*
     * add an action to the node when this action has been executed on the current state
     */
    public void addAction(Model_Action a){
    	this.moves.add(a);
    }
    
    /*
     * print the informations on the current node using Model_State.print adding the score of the node 
     */
    public void printState(){
    	this.state.print();
    	System.out.println("Number of moves to get to this noddle: "+ moves.size());
    }
    
	  /*
	   * print every action that led to the current node  
	   */
    public void print() {
    	for (int i = 0; i < moves.size(); i++)
    		 moves.get(i).print();
    		 System.out.print (" then ");
    }
    
    /*
     * sends back a copy of the current node of the current state
     */
    public Model_Node copy(){ 
    	Model_Node n = new Model_Node();
    	n.setState(this.getState());
    	for (int i = 0; i < moves.size(); i++)
    		n.moves.add(moves.get(i));
    		return(n);
    }
}
