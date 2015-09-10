package yoffe.quadraticEquation;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {
	
	@Test
	public void testGetPositiveX() throws InvalidRootException{
		QuadraticEquation t = new QuadraticEquation(2,5,-3);
		Assert.assertEquals(0.5, t.getPositiveX(), 0.01);
	}
	
	@Test
	public void testGetNegativeX() throws InvalidRootException{
		QuadraticEquation s = new QuadraticEquation(2,5,-3);
		Assert.assertEquals(-3.0, s.getNegativeX(), 0.01);
	}
	
}
