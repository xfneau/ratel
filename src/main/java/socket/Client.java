package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	Socket socket;
	BufferedReader reader;
	PrintWriter out;
	
	public Client(){
		try {
			System.out.println("Try to Connect to 127.0.0.1:10000...");
			
			while(true){
				socket  =new Socket("127.0.0.1", 10001);
				System.out.println("The Server Connected!");
				System.out.println("Please enter some Character:");
				BufferedReader line  = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(socket.getOutputStream(),true);
				out.println(line.readLine());
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println(reader.readLine());
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
		new Client();
	}

}
