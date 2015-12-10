package yoffe.weather;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeatherGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField zipCode;
	private JButton zipButton;
	private WeatherForecast forecast;
	private JLabel error;

	public WeatherGUI() {
		setTitle("Weather");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setResizable(false);

		forecast = new WeatherForecast();

		Container container = getContentPane();
		setLayout(new BorderLayout());

		// title
		JPanel title = new JPanel();
		JLabel weather = new JLabel("WEATHER FORECAST");
		weather.setFont(new Font("Serif", Font.BOLD, 30));
		title.add(weather);

		// weather picture
		JPanel weatherInfo = new JPanel();
		weatherInfo.setLayout(new BoxLayout(weatherInfo, BoxLayout.Y_AXIS));
		weatherInfo.setAlignmentX(CENTER_ALIGNMENT);

		JLabel zip = new JLabel();
		zip.setFont(new Font("Serif", Font.PLAIN, 30));
		zip.setAlignmentX(CENTER_ALIGNMENT);
		weatherInfo.add(zip);

		JLabel icon = new JLabel();
		icon.setAlignmentX(CENTER_ALIGNMENT);
		weatherInfo.add(icon);

		// temp
		JLabel temp = new JLabel();
		temp.setText("--");
		temp.setAlignmentX(CENTER_ALIGNMENT);
		temp.setFont(new Font("Serif", Font.BOLD, 80));
		weatherInfo.add(temp);

		JLabel description = new JLabel();
		description.setAlignmentX(CENTER_ALIGNMENT);
		description.setFont(new Font("Serif", Font.PLAIN, 20));
		weatherInfo.add(description);

		// zipcode info
		JPanel zipInfo = new JPanel();
		zipInfo.setLayout(new BorderLayout());

		JLabel zipTitle = new JLabel();
		zipTitle.setText("Zip Code:");

		zipCode = new JTextField();
		zipCode.setAlignmentY(Component.CENTER_ALIGNMENT);

		zipButton = new JButton();
		zipCode.setFont(new Font("San Serif", Font.PLAIN, 12));
		zipButton.setSize(10, 5);
		zipButton.setText("Update");

		error = new JLabel("*please enter a valid zip code");
		error.setForeground(container.getBackground());

		zipInfo.add(zipTitle, BorderLayout.LINE_START);
		zipInfo.add(zipCode, BorderLayout.CENTER);
		zipInfo.add(zipButton, BorderLayout.LINE_END);
		zipInfo.add(error, BorderLayout.PAGE_END);

		zipButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					forecast.addConnection(zipCode.getText());
					error.setForeground(container.getBackground());

					// image
					URL url = new URL("http://openweathermap.org/img/w/"
							+ forecast.getWeather().getWeather()[0].getIcon() + ".png");

					BufferedImage img = ImageIO.read(url);

					// enlarge image
					ImageIcon image = new ImageIcon(img);
					Image tempImg = image.getImage();
					Image newimg = tempImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
					icon.setIcon(new ImageIcon(newimg));

					temp.setText(String.valueOf((int) forecast.getWeather().getMain().getTemp()) + "\u00b0");
					description.setText(forecast.getWeather().getWeather()[0].getDescription());
					zip.setText(zipCode.getText());

					zipCode.setText("");
					zipCode.requestFocus();

				} catch (IOException e) {
					displayErrorMessage();
				} catch (NullPointerException ex) {
					displayErrorMessage();
				}
			}

		});

		container.add(title, BorderLayout.PAGE_START);
		container.add(weatherInfo, BorderLayout.CENTER);
		container.add(zipInfo, BorderLayout.PAGE_END);

	}

	private void displayErrorMessage() {
		error.setForeground(Color.RED);
		zipCode.setText("");
		zipCode.requestFocus();
	}

	public static void main(String[] args) {
		WeatherGUI gui = new WeatherGUI();
		gui.setVisible(true);
	}
}
