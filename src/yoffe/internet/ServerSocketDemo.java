package yoffe.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

	public static void main(String[] args) throws IOException {

		// a server accepts connections
		ServerSocket serverSocket = new ServerSocket(52746); // need the same
		// port number
		// as client
		Socket socket = serverSocket.accept(); // will wait until someone
		// connects to it
		// once connect the server.accept returns a socket

		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		// client sends message and reads one line of response

		String response = reader.readLine();
		System.out.println("Response:\n");
		System.out.println(response);

		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("HOW ARE YOU DOING?\n"); // new line char is very important
		out.flush();

		serverSocket.close();
		socket.close();
	}

}
