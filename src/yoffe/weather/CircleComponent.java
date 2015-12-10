package yoffe.weather;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class CircleComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	private JPanel container;

	public CircleComponent(JPanel container) {
		this.container = container;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawOval(0, 0, container.getWidth(), container.getHeight());
	}

}
