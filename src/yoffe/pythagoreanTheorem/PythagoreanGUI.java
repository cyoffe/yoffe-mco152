package yoffe.pythagoreanTheorem;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PythagoreanGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JLabel a;
	private final JLabel b;
	private final JLabel c;
	private final JTextField aText;
	private final JTextField bText;
	private final JTextField cText;
	private final JButton calculate;
	private final JLabel answer;

	public PythagoreanGUI() {
		setTitle("Pythagorean Theorem");
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
		answer = new JLabel("Answer");
		calculate = new JButton("Calculate");

		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				final PythagoreanTheorem pyth = new PythagoreanTheorem();
				if (aText.getText().equals("")) {
					pyth.setBC(Double.parseDouble(bText.getText()), Double.parseDouble(cText.getText()));
				} else if (bText.getText().equals("")) {
					pyth.setAC(Double.parseDouble(aText.getText()), Double.parseDouble(cText.getText()));
				} else {
					pyth.setAB(Double.parseDouble(aText.getText()), Double.parseDouble(bText.getText()));
				}

				answer.setText("A = " + pyth.getA() + "   B = " + pyth.getB() + "   C = " + pyth.getC());
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
