/**
 * This is part of the Problem Set 0: Introduction for 6.170 Fall 2005.
 */
package ps0;

import junit.framework.TestCase;

/**
 * HolaWorldTest is a simple test of the HolaWorld class that is to be
 * fixed by the students. This test just makes sure that the program
 * does not crash and that the correct greeting is printed.
 */
public class HolaWorldTest extends TestCase {

    /**
     * Tests that HolaWorld does not crash
     */
    public void testCrash() {
	boolean crashed = false;
        try {
	    HolaWorld.main(new String[1]);
        } catch (Exception ex) {
	    crashed = true;
        }
        assertFalse("HolaWorld crashed. ",crashed);
    }

    /**
     * Tests that the HolaWorld greeting is correct.
     */
    public void testGreeting() {
	HolaWorld world = new HolaWorld();
        assertEquals(HolaWorld.spanishGreeting, world.sayHello());
    }


}
