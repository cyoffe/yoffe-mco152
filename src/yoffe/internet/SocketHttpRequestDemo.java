package yoffe.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHttpRequestDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("www.google.com", 80);

		String httpRequestString = "GET /index.html\n\n"; // must write same
		// exact way bec its
		// the hTTP protocol

		PrintWriter out = new PrintWriter(socket.getOutputStream()); // getting
		// output
		// stream
		// of
		// socket
		// and
		// writing
		// it to
		// the
		// socket

		out.write(httpRequestString);
		out.flush();

		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		String s;
		while ((s = reader.readLine()) != null) {
			System.out.println(s);
		}

	}
}
