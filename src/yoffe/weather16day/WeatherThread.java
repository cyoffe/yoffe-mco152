package yoffe.weather16day;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherThread extends Thread {

	private WeatherForecast forecast;
	private JTextField zipCode;
	private Container container;
	private WeatherComponent[] weatherBoxes;
	private JLabel error;
	private int index;
	private JLabel city;

	public WeatherThread(JTextField zipCode, WeatherComponent[] weatherBoxes, Container container, JLabel error,
			int index, JLabel city) {

		this.forecast = new WeatherForecast();
		this.weatherBoxes = weatherBoxes;
		this.container = container;
		this.zipCode = zipCode;
		this.error = error;
		this.index = index;
		this.city = city;
	}

	@Override
	public void run() {

		URL url = null;
		BufferedImage img = null;
		try {

			forecast.addConnection(zipCode.getText());

			city.setText(forecast.getWeather().getCity().getName());

			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
			weatherBoxes[index].getDate()
					.setText(String.valueOf(formatter.format(forecast.getWeather().getList()[index].getDt())));

			// image

			url = new URL("http://openweathermap.org/img/w/"
					+ forecast.getWeather().getList()[index].getWeather()[0].getIcon() + ".png");

			img = ImageIO.read(url);

			// enlarge image
			ImageIcon image = new ImageIcon(img);
			Image tempImg = image.getImage();
			// Image newimg = tempImg.getScaledInstance(100, 100,
			// Image.SCALE_SMOOTH);
			weatherBoxes[index].getIcon().setIcon(new ImageIcon(tempImg));

			weatherBoxes[index].getDayTemp().setText(
					String.valueOf((int) forecast.getWeather().getList()[index].getTemp().getDay()) + "\u00b0");
			weatherBoxes[index].getNightTemp().setText(
					String.valueOf((int) forecast.getWeather().getList()[index].getTemp().getNight()) + "\u00b0");
			weatherBoxes[index].getClouds()
					.setText("Rain:" + String.valueOf((int) (forecast.getWeather().getList()[index].getRain())) + "%");

			error.setForeground(container.getBackground());
			zipCode.setText("");
			zipCode.requestFocus();

		} catch (NullPointerException | IOException e) {
			// displayErrorMessage();
			e.printStackTrace();
		}

	}

	private void displayErrorMessage() {
		error.setForeground(Color.RED);
		zipCode.setText("");
		zipCode.requestFocus();
		city.setText("CITY");
	}
}
