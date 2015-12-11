package yoffe.weather;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherThread extends Thread {

	private WeatherForecast forecast;
	private JTextField zipCode;
	private JLabel icon;
	private JLabel error;
	private JLabel temp;
	private JLabel description;
	private JLabel zip;
	private Container container;

	public WeatherThread(JTextField zipCode, JLabel icon, JLabel error, JLabel temp, JLabel description, JLabel zip,
			Container container) {
		this.forecast = new WeatherForecast();
		this.zipCode = zipCode;
		this.icon = icon;
		this.error = error;
		this.temp = temp;
		this.description = description;
		this.zip = zip;
		this.container = container;
	}

	@Override
	public void run() {

		URL url;
		BufferedImage img = null;
		try {
			try {
				forecast.addConnection(zipCode.getText());

				// image
				url = new URL("http://openweathermap.org/img/w/" + forecast.getWeather().getWeather()[0].getIcon()
						+ ".png");

				img = ImageIO.read(url);
			} catch (IOException e) {
				displayErrorMessage();
			}

			// enlarge image
			ImageIcon image = new ImageIcon(img);
			Image tempImg = image.getImage();
			Image newimg = tempImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			icon.setIcon(new ImageIcon(newimg));

			temp.setText(String.valueOf((int) forecast.getWeather().getMain().getTemp()) + "\u00b0");
			description.setText(forecast.getWeather().getWeather()[0].getDescription());
			zip.setText(zipCode.getText());

			error.setForeground(container.getBackground());
			zipCode.setText("");
			zipCode.requestFocus();

		} catch (NullPointerException ex) {
			displayErrorMessage();
		}
	}

	private void displayErrorMessage() {
		error.setForeground(Color.RED);
		zipCode.setText("");
		zipCode.requestFocus();
	}
}
