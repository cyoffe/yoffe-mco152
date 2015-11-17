package yoffe.connectFour;

public class Board {
	private int[][] board;
	private int numOfRows;
	private int numOfCol;
	private int spacesUsed;

	public Board() {
		this.numOfRows = 6;
		this.numOfCol = 7;
		board = new int[numOfRows][numOfCol];
		spacesUsed = 0;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int setMove(int col, Player player) {
		int row = -1;
		if (!isFull()) {

			for (int i = numOfRows - 1; i >= 0; i--) {
				if (board[i][col] == 0) {
					board[i][col] = player.getPlayerNumber();
					row = i;
					spacesUsed++;
					break;

				}
			}

			return row;
		}
		return row;

	}

	public boolean isFull() {
		return this.spacesUsed == (numOfRows * numOfCol);
	}

	public int[][] getBoard() {
		return board;
	}

	public boolean checkIfWinner(int playerNum) {
		int count = 0;
		// checks if there are four consecutive chars of the same value
		// horizontally
		for (int row = 0; row < board.length; row++) {
			count = 0;
			for (int column = 0; column < board[row].length; column++) {
				if (board[row][column] == playerNum) {
					count++;
				} else {
					count = 0;
				}
				if (count == 4) {
					return true;
				}
			}
		}

		// checks if there are four consecutive chars of the same value
		// vertically
		for (int column = 0; column < board[0].length; column++) {
			count = 0;
			for (int row = 0; row < board.length; row++) {
				if (board[row][column] == playerNum) {
					count++;
				} else {
					count = 0;
				}
				if (count == 4) {
					return true;
				}
			}
		}

		// checks if there are four consecutive char of the same value
		// diagonally (positive slope)
		for (int row = 3; row < board.length; row++) {
			for (int column = 0; column < (board[0].length - 3); column++) {
				if ((board[row][column] == playerNum) && (board[row][column] == board[row - 1][column + 1])
						&& (board[row - 1][column + 1] == board[row - 2][column + 2])
						&& (board[row - 2][column + 2] == board[row - 3][column + 3])) {
					return true;
				}
			}
		}

		// checks if there are four consecutive chars of the same value
		// diagonally (negative slope)
		for (int row = 0; row < (board.length - 3); row++) {
			for (int column = 0; column < (board[0].length - 3); column++) {
				if ((board[row][column] == playerNum) && (board[row][column] == board[row + 1][column + 1])
						&& (board[row + 1][column + 1] == board[row + 2][column + 2])
						&& (board[row + 2][column + 2] == board[row + 3][column + 3])) {
					return true;
				}
			}
		}
		return false;

	}

	public void clearBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = 0;
			}
		}

	}
}
