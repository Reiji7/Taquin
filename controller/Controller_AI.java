package controller;
import java.util.ArrayList;
import controller.Controller_Game;
import model.ai.Model_Action;
import model.ai.Model_State;
import model.ai.Model_Node;
import model.ai.Model_Problem;

public class Controller_AI {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 *  local variables 
		 */
		Controller_Game cg= new Controller_Game();
		int i;
		Model_State e, start, current;
		boolean found;
		Model_Problem pb;
		ArrayList<Model_Action> listActions, solution;
		ArrayList<Model_Node> listOfSons, l;
		Model_Node n, head;
		
		/*
		 *  initializing problem
		 */
		pb = new Model_Problem(cg);

		/*
		 * initializing the list of solutions and the initial state
		 */
		solution = new ArrayList<Model_Action>();
		start = pb.getInitialState();


		/*
		 *  initializing the waiting list with the initial state
		 */
		n = new Model_Node(start,null);
		l = new ArrayList<Model_Node>();
		l.add(n);
		
		/*
		 *  memorizing the list of possible actions of the taquin game
		 */
		listActions = pb.getListOfActions();

		/*
		 *  main = search of a solution
		 */
		found = false; // becomes true when it has found the goal state
		while (!found){ // as long as the goal state is not found
		    			// gets head of the waiting list and deletes it
		    head = l.remove(0); 
		    //head.print();
		    if(head.getState().isGoal(pb)){ // if goal state is reached, then it stops
		    	found = true;
		    	solution = head.getListofActions();
		    }
		    else{ // else for each action, executes the following instructions
		    	listOfSons = new ArrayList<Model_Node>();
		    	for (i = 0; i<listActions.size(); i++){
		    		e = head.getState().executeAction(listActions.get(i), pb); // launches executeAction with i-action on head, which returns e state		
		    		// builds the new node with e as new state and the list from former node head
		    		n = new Model_Node(e, head.getListofActions());
		    		n.addAction(listActions.get(i)); // adds last executed actions to the list of actions of the current node
		    		listOfSons.add(n); 		 
			}
			l.addAll(listOfSons); // for in width search. for in depth search, use: l.addAll(0,listOfSons); 
		    }
	   	}
		if(found){
			System.out.println("solution found for this taquin game!");
		    for (i = 0;i < solution.size(); i++)
		    	solution.get(i).print();
		}
		else
		    System.out.println("no solution found for this game");
		//testing
		//end of testing
	}
	
}
