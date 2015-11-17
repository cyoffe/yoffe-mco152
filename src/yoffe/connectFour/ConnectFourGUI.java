package yoffe.connectFour;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConnectFourGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private ChooserButton buttons[];
	private CircleComponent circles[][];
	private int numColumns = 7;
	private int numRows = 6;
	private boolean winner = false;

	private Game game;

	public ConnectFourGUI() {
		setTitle("Connect Four");
		setSize(700, 700);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new ChooserButton[numColumns];
		circles = new CircleComponent[numRows][numColumns];
		game = new Game();

		final Container container = getContentPane();
		container.setBackground(new Color(0, 153, 153));
		setLayout(new GridLayout(7, 7));

		for (int i = 0; i < numColumns; i++) {

			final int col = i;
			buttons[i] = new ChooserButton();

			buttons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {

					game.changePlayerTurn(game.getWhoseTurn());
					int row = game.getBoard().setMove(col, game.getWhoseTurn());
					if (row != -1) { // board is not full

						circles[row][col].setColor(game.getWhoseTurn().getPlayerColor());
						circles[row][col].repaint();

						// check if there is a winner
						winner = game.isWinner();
						if (winner) {
							JOptionPane.showMessageDialog(container, "WINNER!");
							int choice = JOptionPane.showConfirmDialog(container, "Do you want to play again?");
							if (choice == JOptionPane.YES_OPTION) {
								newGame();
								return;
							} else {
								dispose();// end game and close window
							}

						}
					}

				}
			});

			add(buttons[i]);
		}

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				circles[i][j] = new CircleComponent(Color.WHITE);
				add(circles[i][j]);
			}
		}

	}

	public void newGame() {
		game = new Game();
		for (int i = 0; i < circles.length; i++) {
			for (int j = 0; j < circles[i].length; j++) {
				circles[i][j].setColor(Color.WHITE);
			}
		}
	}

	public static void main(String[] args) {
		ConnectFourGUI game = new ConnectFourGUI();
		game.setVisible(true);
		game.setResizable(false);

	}

}
