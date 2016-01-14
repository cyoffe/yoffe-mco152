package yoffe.twitter;

import org.eclipse.jetty.server.Server;

public class TwitterJettyServer {

	//http://localhost:8080
	public static void main(String[] args) throws Exception{
		Server server = new Server(8080);
		server.setHandler(new TwitterHandler());
		server.start();
		server.join();
	}
}