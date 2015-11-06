package yoffe.physics;

import org.junit.Assert;
import org.junit.Test;

public class ProjectileTest {

	@Test
	public void testGetX() {
		Projectile p = new Projectile(31, 20, 2.7);
		double x = p.getX();

		Assert.assertEquals(27.81, x, 0.1);
	}

	@Test
	public void testGetY() {
		Projectile p = new Projectile(31, 20, 2.7);
		Assert.assertEquals(10.56, p.getY(), 0.1);
	}
}
