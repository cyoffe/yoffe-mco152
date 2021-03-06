package yoffe.quadraticEquation;

public class QuadraticEquation {
	private final double a;
	private final double b;
	private final double discriminant;

	public QuadraticEquation(double a, double b, double c) throws InvalidRootException {
		if (a == 0) {
			throw new InvalidRootException();
		}
		this.a = a;
		this.b = b;
		this.discriminant = getDiscriminant(a, b, c);
	}

	public double getDiscriminant(double a, double b, double c) {
		return (b * b) - (4 * a * c);
	}

	public double getNegativeX() throws InvalidRootException {
		if (discriminant < 0) {
			throw new InvalidRootException();
		} else {
			return (-b - Math.sqrt(discriminant)) / (2.0 * a);
		}
	}

	public double getPositiveX() throws InvalidRootException {
		if (discriminant < 0) {
			throw new InvalidRootException();
		} else {
			return (-b + Math.sqrt(discriminant)) / (2.0 * a);
		}

	}
}
