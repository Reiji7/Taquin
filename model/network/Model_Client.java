package model.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Model_Client implements Runnable {

	private Socket socket;
	private PrintWriter out;
    private BufferedReader in;
    
    private String namePart;
	
    
	/**
	 * Constructor
	 * @param socket
	 * @throws IOException
	 */
	public Model_Client(Socket socket) throws IOException {
		this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream());
	}
	
	
    public String getIdPart() {
		return namePart;
	}


	public void setIdPart(String namePart) {
		this.namePart = namePart;
	}


	@Override
	public void run() {
		while(true) {
			try {
				
				String message = in.readLine();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}