package model.network;


import java.io.*;
import java.net.Socket;

public class Model_Client implements Runnable{

	private Socket s = null;

	@Override
	public void run() {
		try {
		    //s = new Socket(serverhost, PORT);
		    
		    InputStream in = s.getInputStream();
		    
		    OutputStream out = s.getOutputStream();
		    
		    ObjectInputStream objIn = new ObjectInputStream(in);
		    
		    ObjectOutputStream objOut = new ObjectOutputStream(out);
		    
		    Integer i = (Integer) objIn.readObject();
		    		    
		    objOut.writeObject(i);
		    
		    s.close();
		    
		} catch (IOException | ClassNotFoundException e) {
		    System.err.println(e);

		}
	}
}