package yoffe.weather16day;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class WeatherTest {

	@Test
	public void testCurrentWeather() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter a city:");
		String city = keyboard.next();

		try {
			WeatherForecast weather = new WeatherForecast();
			weather.addConnection(city);
			Assert.assertEquals("sky is clear", weather.getWeather().getList()[0].getWeather()[0].getDescription());
		} catch (IOException e) {
			System.out.println("something went wrong...");
		}

	}
}
