package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Connection implements Runnable {

    public ServerSocket serverSocket = null;
    
    private Thread threadProc;
    private Socket socket;
    
    // List of conected client 
    private ArrayList<Client> clientList = new ArrayList<>();
    
    
    public Connection(ServerSocket socket) {
    	this.serverSocket = socket;
    }    
    
    /**
     * Create a thread for each client trying to connect
     * @throws IOException
     */
	@Override
	public void run() {
	    while (true) {
	        try {
				socket = serverSocket.accept();

	        	Client client = new Client(socket);
	        	clientList.add(client);
	        	System.out.println("New user connected.");

	        	threadProc = new Thread(client);
	        	threadProc.start();
	        
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}	
	
}