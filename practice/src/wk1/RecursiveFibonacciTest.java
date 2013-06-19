package wk1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class RecursiveFibonacciTest {
	FibonacciTemplate rf1 = new RecursiveFibonacci(5);
	FibonacciTemplate rf2 = new RecursiveFibonacci(4);
	

	@Test
	public void testRecursiveFibonacci() {
		Assert.assertFalse(rf1.equals(rf2));
		Assert.assertFalse(rf1==rf2);
		try { FibonacciTemplate rf3 = new RecursiveFibonacci(0); fail("should not reach here"); } catch (IllegalArgumentException iae) {};
	}

	@Test
	public void testGet() {
		Assert.assertTrue(rf1.get()==8);
		Assert.assertTrue(rf2.get()==5);
	}
}
