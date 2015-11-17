package yoffe.connectFour;

import java.awt.Color;

public class Game {
	private Player player1, player2;
	private Player playerTurn;
	private Board board;

	public Game() {
		player1 = new Player(new Color(204, 0, 0), 1);
		player2 = new Player(new Color(255, 219, 88), 2);
		board = new Board();
		playerTurn = player2;
	}

	public Player changePlayerTurn(Player playerTurn) {
		if (playerTurn.getPlayerNumber() == 1) {
			this.playerTurn = player2;

		} else if (playerTurn.getPlayerNumber() == 2) {
			this.playerTurn = player1;
		}

		return playerTurn;

	}

	public Player getWhoseTurn() {
		return this.playerTurn;
	}

	public Board getBoard() {
		return board;
	}

	public boolean isWinner() {
		return this.board.checkIfWinner(playerTurn.getPlayerNumber());
	}

}