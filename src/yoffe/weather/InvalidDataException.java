package yoffe.weather;

public class InvalidDataException extends RuntimeException {
	public InvalidDataException() {
		super("invalid data");
	}
}
