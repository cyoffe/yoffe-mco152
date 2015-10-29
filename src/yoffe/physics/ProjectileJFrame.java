package yoffe.physics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new ProjectileJFrame().setVisible(true);
	}

	public ProjectileJFrame() {
		setTitle("Projectile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		container.add(new ProjectileComponent(), BorderLayout.CENTER);

	}

}