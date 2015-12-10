package yoffe.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherForecast {
	private CurrentWeather weather;
	private String zipCode;
	private URL url;

	public WeatherForecast() {

	}

	public CurrentWeather getWeather() {
		return weather;
	}

	public void setWeather(CurrentWeather weather) {
		this.weather = weather;
	}

	public String getZipCode() {
		return zipCode;
	}

	public URL getUrl() {
		return url;
	}

	public void addConnection(String zipCode) throws IOException {
		if ((zipCode == null) || (zipCode == "")) {
			throw new InvalidDataException();
		}
		this.zipCode = zipCode;
		this.url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode
				+ ",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
		HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		weather = gson.fromJson(reader, CurrentWeather.class);
	}

	public void changeZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
