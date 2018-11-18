package server;

import java.util.ArrayList;

public abstract class Treatment {
	
	protected boolean treatment(ArrayList<String> command) throws NullPointerException{
		
		switch(command.get(0)) {
		
		// Get score table
		case("g"):
			
		break;
		
		// Add score to table
		case("a"):
			
		break;
		
		// Create game room
		case("r"):
			
		break;
		
		// connect to game room
		case("c"):
			
		break;
		
		// Play 
		case("p"):
			
		break;
		
		// Signal win
		case("w"):
			
		break;
		
		default: break;
		
		}
		return false;
	}
	
	
	
}