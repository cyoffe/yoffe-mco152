package yoffe.connectFour;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChooserButton extends JButton {
	private ImageIcon arrow = new ImageIcon(this.getClass().getResource("arrow.png"));

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(arrow.getImage(), 0, 0, 100, 100, this);

		super.repaint();
	}

}
