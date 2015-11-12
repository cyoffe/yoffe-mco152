package yoffe.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class GridComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {

		g.setColor(Color.PINK);
		g.fillRect(0, 0, 100, 100);

		g.setColor(Color.GRAY);
		g.drawRect(0, 0, 100, 100);

		super.repaint();
	}

}
