package yoffe.physics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JLabel angle;
	private final JLabel velocity;
	private final JLabel time;
	private final JTextField angleInput;
	private final JTextField velInput;
	private final JTextField timeInput;
	private final JButton button;
	private final JLabel answer;

	public ProjectileGUI() {
		setTitle("Projectile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		angle = new JLabel("angle:");
		velocity = new JLabel("velocity:");
		time = new JLabel("time:");
		angleInput = new JTextField();
		velInput = new JTextField();
		timeInput = new JTextField();
		button = new JButton("Calculate");
		answer = new JLabel("answer:");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				final Projectile projectile = new Projectile(Double.parseDouble(angleInput.getText()),
						Double.parseDouble(velInput.getText()), Double.parseDouble(timeInput.getText()));

				answer.setText("X = " + projectile.getX() + ", Y = " + projectile.getY());

			}

		});

		add(angle);
		add(angleInput);
		add(velocity);
		add(velInput);
		add(time);
		add(timeInput);
		add(button);
		add(answer);
	}

}
