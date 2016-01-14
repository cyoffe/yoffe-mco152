package yoffe.weather16day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherForecast {
	private WeatherList weather;
	private String zipCode;
	private URL url;

	public WeatherForecast() {

	}

	public WeatherList getWeather() {
		return weather;
	}

	public void setWeather(WeatherList weather) {
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
			throw new NullPointerException();
		}
		this.zipCode = zipCode;
		this.url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?zip=" + zipCode
				+ "&cnt=16&APPID=c08c6900d895082702317a1b4c3fae0d&units=imperial");
		HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		weather = gson.fromJson(reader, WeatherList.class);
	}

	public void changeZip(String zipCode) {
		this.zipCode = zipCode;
	}

}
