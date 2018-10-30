package model.network;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Model_Server implements Runnable{

    private ServerSocket socketserver = null;
    private Socket socket = null;
    private Thread threadProc;

	@Override
	public void run() {
		try {
			socketserver = new ServerSocket(/* PORT */);
		    
		    while (true) {
		        socket = socketserver.accept();
		        
		        //créer un thread: pour échanger les données avec le client
		        		        
		        threadProc = new Thread();
		        
		        threadProc.start();
		    }
		} catch (IOException e) {
		    System.err.println(e);
		}		
	}
}
