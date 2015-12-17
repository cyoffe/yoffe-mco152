package yoffe.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDemo extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JLabel label1;
	private final JButton button1;
	private final JTextField textField;

	public JFrameDemo() {
		setTitle("JFrameDemo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // tells what happens
		// when hit x button

		final Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		label1 = new JLabel("all this text is shown all the time");
		add(label1);

		textField = new JTextField();
		add(textField);

		button1 = new JButton("button");
		add(button1);

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println(textField.getText());

			}
		});

	}

}
