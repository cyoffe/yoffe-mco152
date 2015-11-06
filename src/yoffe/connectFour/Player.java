package yoffe.connectFour;

public class Player {
	private String playerColor;
	private int playerNumber;

	public Player(String color, int playerNumber) {
		this.playerColor = color;
		this.playerNumber = playerNumber;
	}

	public String getPlayerColor() {
		return playerColor;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

}
