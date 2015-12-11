package yoffe.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("192.168.117.96", 52746); // IP of the
		// server

		PrintWriter out = new PrintWriter(socket.getOutputStream());

		out.write("Hi there\n"); // new line char is very important
		out.flush();

		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		// client sends message and reads one line of response

		String response = reader.readLine();
		System.out.println("Response:\n");
		System.out.println(response);
		socket.close();

	}
}
