/**
 * This is part of the Problem Set 0: Introduction for 6.170 Fall 2005.
 */
package ps0;

import junit.framework.TestCase;

/**
 * BallContainerTest is a glassbox test of the BallContainer class. 
 *
 * Recall that the BallContainer is a container for Balls. However, you can only
 * put a Ball into a BallContainer once. After you put the Ball into the BallContainer,
 * further attempts to do so will fail, since the Ball is already in
 * the BallContainer! Similarly, you cannot expect to remove a Ball from a BallContainer
 * if it is not inside the BallContainer.
 *
 * @see ps0.Ball
 * @see ps0.BallContainer
 */
public class BallContainerTest extends TestCase {

    private BallContainer ballcontainer = null;
    private int NUM_BALLS_TO_TEST = 3;
    private Ball[] b = null;
    private double BALL_UNIT_VOLUME = 20.0;
    private double JUNIT_DOUBLE_DELTA = 0.0001;

    protected void setUp() throws Exception {
	assertEquals("Test case error, you must test at least 1 Ball!!", true, NUM_BALLS_TO_TEST > 0); 
        ballcontainer = new BallContainer();

	// Let's create the balls we need.
        b = new Ball[NUM_BALLS_TO_TEST];
	for (int i=0; i<NUM_BALLS_TO_TEST; i++) {
	    b[i] = new Ball((i+1)*BALL_UNIT_VOLUME);
	}
    }


    /** Test to check that BallContainer.add(Ball) is implemented correctly */
    public void testAdd() {
	ballcontainer.clear();
	for (int i=0; i<NUM_BALLS_TO_TEST; i++) {
	    assertEquals("BallContainer.add(Ball) failed to add a new Ball!", true, ballcontainer.add(b[i]));
	    assertEquals("BallContainer.add(Ball) seems to allow the same Ball to be added twice!", false, ballcontainer.add(b[i]));
	    assertEquals("BallContainer does not contain a ball after it is supposed to have been added!", true, ballcontainer.contains(b[i]));
	}
    }

    /** Test to check that BallContainer.remove(Ball) is implemented correctly */
    public void testRemove() {
	ballcontainer.clear();
        assertEquals("BallContainer.remove(Ball) should fail because ballcontainer is empty, but it didn't!", false, ballcontainer.remove(b[0]));
	for (int i=0; i<NUM_BALLS_TO_TEST; i++) {
	    ballcontainer.clear();
	    for (int j=0; j<i; j++) {
		ballcontainer.add(b[j]);
	    }
	    for (int j=0; j<i; j++) {
		assertEquals("BallContainer.remove(Ball) failed to remove a Ball that is supposed to be inside", true, ballcontainer.remove(b[j]));
		assertEquals("BallContainer still contains a ball after it is supposed to have been removed!", false, ballcontainer.contains(b[j]));
	    }
	    for (int j=i; j<NUM_BALLS_TO_TEST; j++) {
		assertEquals("BallContainer.remove(Ball) did not fail for a Ball that is not inside", false, ballcontainer.remove(b[j]));
	    } 
	}
    }

    /** Test to check that BallContainer.clear() is implemented correctly */
    public void testClear() {
	ballcontainer.clear();
        assertEquals("BallContainer is not empty after being cleared!", 0, ballcontainer.size());
	ballcontainer.add(b[0]);
	ballcontainer.clear();
        assertEquals("BallContainer is not empty after being cleared!", 0, ballcontainer.size());
    }

    /** Test to check that check that we can put a Ball into a BallContainer */
    public void testCapacity() {
	ballcontainer.clear();
        assertEquals("Capacity of empty BallContainer is not zero!", 0, ballcontainer.getCapacity(), JUNIT_DOUBLE_DELTA);
	for (int i=0; i<NUM_BALLS_TO_TEST; i++) {
	    ballcontainer.add(b[i]);
	    assertEquals("Capacity of BallContainer with "+(i+1)+" ball(s) is supposed to be "+((i+1)*(i+2)*BALL_UNIT_VOLUME/2)+" but it's "
			 +ballcontainer.getCapacity()+" instead", (i+1)*(i+2)*BALL_UNIT_VOLUME/2, ballcontainer.getCapacity(), JUNIT_DOUBLE_DELTA);
	}

    }

    /** Test to check that size() returns the correct number. */
    public void testSize() {
	ballcontainer.clear();
        assertEquals("size() of empty BallContainer is not zero!", 0, ballcontainer.size());
	for (int i=0; i<NUM_BALLS_TO_TEST; i++) {
	    ballcontainer.add(b[i]);
	    assertEquals("size() of BallContainer with "+(i+1)+" ball(s) is supposed to be "+(i+1)+" but it's "
			 +ballcontainer.size()+" instead", i+1, ballcontainer.size());
	}
    }

    /** Test to check that size() returns the correct number. */
    public void testContains() {
	ballcontainer.clear();
	for (int i=0; i<NUM_BALLS_TO_TEST; i++) {
	    assertEquals("Empty BallContainer seems to contain a ball!", false, ballcontainer.contains(b[i]));
	}
	for (int i=0; i<NUM_BALLS_TO_TEST; i++) {
	    ballcontainer.add(b[i]);
	    assertEquals("BallContainer does not contain a Ball that is supposed to be inside!", true, ballcontainer.contains(b[i]));
	    for (int j=i+1; j<NUM_BALLS_TO_TEST; j++) {
		assertEquals("BallContainer seems to contain a Ball that is not inside!", false, ballcontainer.contains(b[j]));
	    }
	}
    }

}
