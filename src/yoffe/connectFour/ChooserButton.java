package yoffe.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChooserButton extends JButton {
	private ImageIcon arrow = new ImageIcon(this.getClass().getResource("arrow.png"));

	public ChooserButton() {
		setBackground(new Color(0, 153, 153));
		setFocusPainted(false);
		setBorderPainted(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(arrow.getImage(), 0, 0, 100, 100, this);

	}

}
