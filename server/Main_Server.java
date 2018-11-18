package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main_Server {

    public final static int PORT = 2003;

	public static void main(String[] args) {
        try {
        	ServerSocket SOCKET = new ServerSocket(PORT);
            System.out.println("server listen port " + SOCKET.getLocalPort());
            
            Connection server = new Connection(SOCKET);
            Thread t = new Thread(server);
            t.run();
        }
        catch (IOException e) {
        	System.err.println("Le port n'est pas disponible !");
        }
    }
}
