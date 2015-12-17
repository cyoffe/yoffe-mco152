package yoffe.weather16day;

public class Weather {

	private DailyWeather[] weather;
	private Temperature temp;
	private double rain;
	private long dt;

	public DailyWeather[] getWeather() {
		return weather;
	}

	public Temperature getTemp() {
		return temp;
	}

	public double getRain() {
		return rain;
	}

	public long getDt() {
		return dt * 1000;
	}

}
