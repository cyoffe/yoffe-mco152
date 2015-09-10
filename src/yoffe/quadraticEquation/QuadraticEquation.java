package yoffe.quadraticEquation;

public class QuadraticEquation {
	private double a;
	private double b;
	private double c;
	private double discriminant;

	public QuadraticEquation(double a, double b, double c) throws InvalidRootException {
		if(a == 0) throw new InvalidRootException();
		this.a = a;
		this.b = b;
		this.c = c;
		this.discriminant = getDiscriminant(a, b, c);
	}

	public double getPositiveX() throws InvalidRootException {
		if (discriminant < 0) {
			throw new InvalidRootException();
		} else {
			return (-b + Math.sqrt(discriminant)) / (2.0 * a);
		}

	}

	public double getNegativeX() throws InvalidRootException {
		if (discriminant < 0) {
			throw new InvalidRootException();
		} else {
			return (-b - Math.sqrt(discriminant)) / (2.0 * a);
		}
	}

	public double getDiscriminant(double a, double b, double c) {
		return (b * b) - 4 * a * c;
	}
}
