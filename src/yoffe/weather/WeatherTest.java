package yoffe.weather;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class WeatherTest {

	@Test
	public void testCurrentWeather() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter a zipcode:");
		String zipcode = keyboard.next();

		try {
			WeatherForecast weather = new WeatherForecast();
			weather.addConnection(zipcode);
			Assert.assertEquals("mist", weather.getWeather().getWeather()[0].getDescription());
		} catch (IOException e) {
			System.out.println("something went wrong...");
		}

	}
}
