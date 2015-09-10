package yoffe.pythagoreanTheorem;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {

	@Test
	public void testSetAB() {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setAB(12, 16);

		Assert.assertEquals(20.0, p.getC(), 0.01);
	}

	@Test
	public void testSetAC() {
		PythagoreanTheorem pt = new PythagoreanTheorem();
		pt.setAC(12, 20);

		Assert.assertEquals(16.0, pt.getB(), 0.01);
	}

	@Test
	public void testSetBC() {
		PythagoreanTheorem pt = new PythagoreanTheorem();
		pt.setBC(16, 20);

		Assert.assertEquals(12.0, pt.getA(), 0.01);
	}
}
