package yoffe.connectFour;

import java.awt.Color;

public class Player {
	private Color playerColor;
	private int playerNumber;

	public Player(Color color, int playerNumber) {
		this.playerColor = color;
		this.playerNumber = playerNumber;
	}

	public Color getPlayerColor() {
		return playerColor;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

}
