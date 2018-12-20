package application;

import java.io.IOException;

import controller.Controller_Main;

public class Main {

	public static void main(String[] args) throws IOException {
		if(args.length == 0) {
			Controller_Main.main(args);
		}
		else {
			Controller_Main controller = new Controller_Main();
			controller.start();
		}
	}

}
