package yoffe.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SmileJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		new SmileJFrame().setVisible(true);
	}

	public SmileJFrame() {
		setTitle("Smile");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final BorderLayout layout = new BorderLayout();
		final Container container = getContentPane();
		container.setLayout(layout);

		SmileComponent smile = new SmileComponent();

		container.add(smile, BorderLayout.CENTER);

	}
}
