package yoffe.weather16day;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class WeatherComponent extends JComponent {
	private JLabel zipCode, icon, dayTemp, nightTemp, clouds, date;

	public WeatherComponent() {
		// weather picture

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentY(Component.CENTER_ALIGNMENT);
		setBorder(new LineBorder(Color.BLACK));

		date = new JLabel();
		date.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(date);

		icon = new JLabel();
		icon.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(icon);

		// temp
		dayTemp = new JLabel();
		dayTemp.setText("--");
		dayTemp.setAlignmentX(Component.CENTER_ALIGNMENT);
		dayTemp.setFont(new Font("Serif", Font.BOLD, 35));
		add(dayTemp);

		nightTemp = new JLabel();
		nightTemp.setAlignmentX(Component.CENTER_ALIGNMENT);
		nightTemp.setFont(new Font("Serif", Font.BOLD, 25));
		add(nightTemp);

		clouds = new JLabel();
		clouds.setAlignmentX(Component.CENTER_ALIGNMENT);
		clouds.setFont(new Font("Serif", Font.PLAIN, 15));
		add(clouds);

	}

	public JLabel getZip() {
		return zipCode;
	}

	public JLabel getIcon() {
		return icon;
	}

	public JLabel getDayTemp() {
		return dayTemp;
	}

	public JLabel getNightTemp() {
		return nightTemp;
	}

	public JLabel getClouds() {
		return clouds;
	}

	public JLabel getDate() {
		return date;
	}
}
