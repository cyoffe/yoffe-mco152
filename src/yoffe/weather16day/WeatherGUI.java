package yoffe.weather16day;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeatherGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton cityButton;
	private WeatherComponent[] weatherBoxes = new WeatherComponent[16];
	private JLabel error;

	public WeatherGUI() {
		setTitle("Weather");
		setSize(800, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setResizable(false);

		Container container = getContentPane();
		container.setLayout(new BorderLayout(0, 20));

		// title
		JPanel title = new JPanel();
		title.setLayout(new BoxLayout(title, BoxLayout.Y_AXIS));

		JLabel weather = new JLabel("16-DAY WEATHER FORECAST");
		weather.setFont(new Font("Serif", Font.BOLD, 30));
		weather.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.add(weather);

		JLabel city = new JLabel("CITY");
		city.setAlignmentX(Component.CENTER_ALIGNMENT);
		city.setFont(new Font("Serif", Font.BOLD, 15));
		title.add(city);

		// weather boxes
		JPanel weatherInfo = new JPanel();
		weatherInfo.setLayout(new GridLayout(2, 8));
		for (int i = 0; i < 16; i++) {
			weatherBoxes[i] = new WeatherComponent();
			weatherInfo.add(weatherBoxes[i]);
		}

		// cityName info
		JPanel cityInfo = new JPanel();
		cityInfo.setLayout(new BorderLayout());

		JLabel cityTitle = new JLabel();
		cityTitle.setText("Zip Code:");

		JTextField cityName = new JTextField();
		cityName.setAlignmentY(Component.CENTER_ALIGNMENT);

		cityButton = new JButton();
		cityName.setFont(new Font("San Serif", Font.PLAIN, 12));
		cityButton.setSize(10, 5);
		cityButton.setText("Update");

		error = new JLabel("*please enter a valid zip code");
		error.setForeground(container.getBackground());

		cityInfo.add(cityTitle, BorderLayout.LINE_START);
		cityInfo.add(cityName, BorderLayout.CENTER);
		cityInfo.add(cityButton, BorderLayout.LINE_END);
		cityInfo.add(error, BorderLayout.PAGE_END);

		cityButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				for (int index = 0; index < 16; index++) {

					WeatherThread thread = new WeatherThread(cityName, weatherBoxes, container, error, index, city);
					thread.start();
				}

			}

		});

		container.add(title, BorderLayout.PAGE_START);
		container.add(weatherInfo, BorderLayout.CENTER);
		container.add(cityInfo, BorderLayout.PAGE_END);

	}

	public static void main(String[] args) {
		WeatherGUI gui = new WeatherGUI();
		gui.setVisible(true);
	}
}
