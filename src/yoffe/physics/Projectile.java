package yoffe.physics;

public class Projectile {

	private double velocity;
	private double time;
	private double radians;
	

	public Projectile(double angle, double velocity, double time) {
		this.velocity = velocity;
		this.time = time;
		radians = Math.toRadians(angle);
	}

	
	public double getY() {
		return Math.cos(radians) * velocity * time - (1 / 2 * 9.8 * time * time);
	}

	public double getX() {
		return Math.sin(radians) * velocity * time;
	}
	
	public void setTime(double time){
		this.time = time;
	}

}
