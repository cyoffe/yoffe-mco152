package yoffe.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class CircleComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private Color color;

	public CircleComponent(Color color) {
		this.color = color;
	}

	@Override
	protected void paintComponent(Graphics g) {

		g.setColor(color);
		g.fillOval(5, 5, 90, 90);

	}

	public void setColor(Color color) {
		this.color = color;
		super.repaint();
	}

}
