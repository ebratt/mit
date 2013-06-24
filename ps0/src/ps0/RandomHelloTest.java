/**
 * This is part of the Problem Set 0: Introduction for 6.170 Fall 2005.
 */
package ps0;

import junit.framework.TestCase;
import java.util.HashSet;

/**
 * RandomHelloTest is a simple test of the RandomHello class that is
 * to be written by the students. This test just makes sure that the
 * program does not crash and that it prints at least 5 different
 * greetings.
 */
public class RandomHelloTest extends TestCase {

    /** Number of times to run the greeting test until we're quite sure we'd have seen all the greetings */
    private int TIMES_TO_TEST = 1000;

    /** Required number of greetings */
    private int REQUIRED_NUMBER_OF_GREETINGS = 5;

    /**
     * Tests that RandomHello does not crash
     */
    public void testCrash() {
	boolean crashed = false;
        try {
	    RandomHello.main(new String[1]);
        } catch (Exception ex) {
	    crashed = true;
        }
        assertFalse("RandomWorld crashed. ",crashed);
    }


    /**
     * Tests that the greetings are indeed random and that there are
     * at least 5 different ones.
     */
    public void testGreetings() {
	RandomHello world = new RandomHello();
	HashSet<String> set = new HashSet<String>();
	
	for (int i=0; i< TIMES_TO_TEST; i++) {
	    String greeting = world.sayHello();
	    if (!set.contains(greeting)) {
		set.add(greeting);
	    }
	}
        assertTrue("Insufficient number of greetings. Only "+set.size()+" greetings observed when we asked for "+ REQUIRED_NUMBER_OF_GREETINGS, set.size() >= REQUIRED_NUMBER_OF_GREETINGS);
        assertFalse("Too many greetings in RandomHello. "+set.size()+" different greetings were observed when we asked for exactly "+ REQUIRED_NUMBER_OF_GREETINGS, set.size() > REQUIRED_NUMBER_OF_GREETINGS);
    }

  
}
