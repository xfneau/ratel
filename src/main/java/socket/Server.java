package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket ss;
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter out;
	
	public Server(){
		try {
			ss = new ServerSocket(10001);
			while( true ){
				socket = ss.accept();
				String RemoteIP =
					socket.getInetAddress().getHostAddress();
				String RemotePort = ":"+socket.getLocalPort();
				System.out.println("A client come in!IP:"
						+ RemoteIP+RemotePort);
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = reader.readLine();
				System.out.println("Client send is:"+line);
				out = new PrintWriter(socket.getOutputStream(),true);
				out.print("Your Message Received!");
				out.close();
				reader.close();
				socket.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new Server();

	}

}
