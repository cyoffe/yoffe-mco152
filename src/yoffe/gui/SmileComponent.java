package yoffe.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private int y = 150;
	private int y2 = 145;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.YELLOW);
		g.fillOval(50, 50, 500, 500);

		g.setColor(Color.BLUE);

		if (y == 160) {
			y = 145;
		}

		if (y2 == 155) {
			y2 = 145;
		}

		g.fillOval(175, y, 50, 50);
		g.fillOval(400, y2, 50, 50);

		y2++;
		y++;

		g.setColor(Color.RED);
		g.drawArc(125, 125, 350, 350, 180, 180);

		try {
			Thread.sleep(10);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		super.repaint();

	}
}
