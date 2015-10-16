package yoffe.quadraticEquation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuiQuadratic extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JLabel a;
	private final JLabel b;
	private final JLabel c;
	private final JTextField aText;
	private final JTextField bText;
	private final JTextField cText;
	private final JButton calculate;
	private final JLabel answer;

	public GuiQuadratic() {
		setTitle("Quadratic Equation");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		a = new JLabel("a");
		b = new JLabel("b");
		c = new JLabel("c");
		aText = new JTextField();
		bText = new JTextField();
		cText = new JTextField();
		answer = new JLabel("answer");
		calculate = new JButton("calculate");

		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				QuadraticEquation equ = null;
				try {
					equ = new QuadraticEquation(Double.parseDouble(aText.getText()),
							Double.parseDouble(bText.getText()), Double.parseDouble(cText.getText()));
				} catch (NumberFormatException | InvalidRootException e1) {
					System.out.println("invalid root");
				}

				String ans = "";
				try {
					ans = equ.getPositiveX() + ", " + equ.getNegativeX();
				} catch (final InvalidRootException e1) {
					System.out.println("invalid root");
				}
				answer.setText(ans);

			}

		});

		add(a);
		add(aText);
		add(b);
		add(bText);
		add(c);
		add(cText);
		add(calculate);
		add(answer);

	}
}
