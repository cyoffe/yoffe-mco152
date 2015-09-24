package yoffe.quadraticEquation;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetNegativeX() throws InvalidRootException {
		final QuadraticEquation s = new QuadraticEquation(2, 5, -3);
		Assert.assertEquals(-3.0, s.getNegativeX(), 0.01);
	}

	@Test
	public void testGetPositiveX() throws InvalidRootException {
		final QuadraticEquation t = new QuadraticEquation(2, 5, -3);
		Assert.assertEquals(0.5, t.getPositiveX(), 0.01);
	}

	@Test
	public void testInvalidRootException() {
		try {
			new QuadraticEquation(0, 0, 0);
			Assert.fail("didn't throw exception");
		} catch (final InvalidRootException e) {
			// expected
		}
	}
}
