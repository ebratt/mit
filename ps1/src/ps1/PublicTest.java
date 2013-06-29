package ps1;

import junit.framework.Test;
import junit.framework.TestSuite;


/** PublicTest is a simple TestSuite that includes
    and runs all the tests in {@link RatNumTest}, 
    {@link RatPolyTest}, and {@link RatPolyStackTest}.
*/
public class PublicTest extends TestSuite
{
    public static Test suite() { return new PublicTest(); }
    public PublicTest() { this("Problem Set 1 Public Test"); }
    public PublicTest(String s)
    {
        super(s);
        addTestSuite(RatNumTest.class);
        addTestSuite(RatPolyTest.class);
        addTestSuite(RatPolyStackTest.class);
    }

}
