package yoffe.connectFour;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameGUI extends JFrame {

	private JLabel playerRed;
	private JLabel playerBlack;
	private JButton buttons[];
	private int numColumns = 7;
	private int numRows = 5;

	private Board board;

	public GameGUI() {
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final Container container = getContentPane();
		setLayout(new GridLayout(6, 7));
		
		
		buttons = new JButton[numColumns];
		
		for(int i = 0; i < numColumns; i++){
			buttons[i] = new JButton("" +(i + 1));
			buttons[i].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					e.
					
				}
				
			});
		} 
		
		
	
	}

}
