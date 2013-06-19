package wk1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class LinearFibonacciTest {

	FibonacciTemplate lf1 = new LinearFibonacci(5);
	FibonacciTemplate lf2 = new LinearFibonacci(4);
	
	@Test
	public void testLinearFibonacci() {
		Assert.assertFalse(lf1.equals(lf2));
		Assert.assertFalse(lf1==lf2);
		try { FibonacciTemplate rf3 = new LinearFibonacci(0); fail("should not reach here"); } catch (IllegalArgumentException iae) {};
	}
}
