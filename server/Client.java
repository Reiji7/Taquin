package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;


public class Client implements Runnable, Treatment {

	private String login;
	private String id;
	private Socket socket;
	private PrintWriter out;
    private BufferedReader in;
    
    private String idPart;
	
    
	/**
     * Constructor 
     * @param login
     * @param soc
     * @param out
     * @param in
     * @throws IOException 
     */
	public Client(Socket socket) throws IOException {
		this.socket = socket;
		this.id = UUID.randomUUID().toString();
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream());
	}
	
	
    public String getIdPart() {
		return idPart;
	}


	public void setIdPart(String idPart) {
		this.idPart = idPart;
	}


	public String getLogin() {
		return login;
	}


	public String getId() {
		return id;
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