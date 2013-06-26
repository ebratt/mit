/**
 * This is part of the Problem Set 0: Introduction for 6.170 Fall 2005.
 */
package ps0;

import junit.framework.TestCase;

/**
 * BallTest is a simple glassbox test of the Ball class.
 * 
 * @see ps0.Ball
 */
public class BallTest extends TestCase {

	private Ball b = null;
	private double BALL_WEIGHT = 5.0, BALL_VOLUME = 20.0, JUNIT_DOUBLE_DELTA = 0.0001;

	protected void setUp() throws Exception {
		b = new Ball(BALL_WEIGHT, BALL_VOLUME);
	}

	/** Test to see that Ball returns the correct capacity when queried. */
	public void testCapacity() {
		assertEquals("b.getCapacity should be [" + BALL_VOLUME
				+ "] but it is [" + b.getCapacity() + "] instead!",
				BALL_VOLUME, b.getCapacity(), JUNIT_DOUBLE_DELTA);
	}

	/** Test to see that Ball returns the correct weight when queried. */
	public void testWeight() {
		assertEquals("b.getWeight should be [" + BALL_WEIGHT + "] but it is ["
				+ b.getWeight() + "] instead!", BALL_WEIGHT, b.getWeight(),
				JUNIT_DOUBLE_DELTA);
	}

}
