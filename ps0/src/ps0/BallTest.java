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
    private double BALL_VOLUME = 20.0;
    private double JUNIT_DOUBLE_DELTA = 0.0001;

    protected void setUp() throws Exception {
        b = new Ball(BALL_VOLUME);
    }

    /** Test to see that Ball returns the correct capacity when queried. */
    public void testCapacity() {
        assertEquals("b.getCapacity should "+BALL_VOLUME+" but it's "+b.getCapacity()+" instead!",
		     BALL_VOLUME, b.getCapacity(), JUNIT_DOUBLE_DELTA);
    }

}
