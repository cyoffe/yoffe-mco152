package yoffe.chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jetty.server.Server;

public class ChatJFrame extends JFrame {

	public ChatJFrame() {
		setTitle("Chat");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		JLabel label = new JLabel("COMPUTER SCIENCE CHAT");
		container.add(label, BorderLayout.NORTH);

		JTextArea area = new JTextArea();

		JScrollPane pane = new JScrollPane(area);
		// pane.setPreferredSize(new Dimension(500, 600));

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JTextField text = new JTextField();
		text.grabFocus();
		JButton button = new JButton("Button");

		panel.add(text, BorderLayout.CENTER);
		panel.add(button, BorderLayout.EAST);

		container.add(pane, BorderLayout.CENTER);
		container.add(panel, BorderLayout.SOUTH);

		Server server = new Server(8080);
		server.setHandler(new ChatP2Handler(area)); // use handler to handler a
		// request

		try {
			server.start();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				URL url;
				try {
					url = new URL("http://192.168.117.111:8080");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					OutputStream output = connection.getOutputStream();
					PrintWriter writer = new PrintWriter(output);
					writer.print(text.getText());
					writer.flush();
					connection.getInputStream();

					// area.append(text.getText() + "\n");
					text.setText("");
					text.requestFocus();

				} catch (IOException e1) {
					area.append("SHAINDY LEFT THE CHAT\n");
				}

			}

		});
	}

	public static void main(String[] args) {
		ChatJFrame gui = new ChatJFrame();
		gui.setVisible(true);
	}
}
