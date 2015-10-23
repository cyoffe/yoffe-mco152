package yoffe.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.YELLOW);
		g.fillOval(50, 50, 500, 500);

		g.setColor(Color.BLUE);

		g.fillOval(175, 175, 50, 50);
		g.fillOval(400, 175, 50, 50);

		g.setColor(Color.red);
		g.drawArc(125, 125, 350, 350, 180, 180);

	}
}
