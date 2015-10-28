package yoffe.physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ProjectileComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g;

		Projectile projectile = new Projectile(31, 20, 0);
		double x = 0.0;
		double y = getHeight();

		for (int i = 1; i <= 20; i++) {
			double prevX = x;
			double prevY = y;

			projectile.setTime(i);
			x = projectile.getX();
			y = getHeight() - projectile.getY();

			g2D.draw(new Line2D.Double(prevX, prevY, x, y));
			// System.out.println(prevX + ", " + prevY + " " + x + ", " + y);

		}
	}
}