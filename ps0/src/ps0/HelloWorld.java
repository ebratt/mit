/**
 * This is part of the Problem Set 0: Introduction for 6.170 Fall 2005.
 */
package ps0;

/**
 * HelloWorld is an implementation of the token
 * introductory "Hello World" program.
 *
 * HelloWorld is also the superclass for the other classes in this package.
 */
public class HelloWorld {

    /** the greeting to display when this sayHello() is invoked */
    static final String greeting = "Hello World!";
    
    /**
     * @effects prints the string "Hello World!" to the console
     */
    public static void main(String[] argv) {
        HelloWorld myFirstHW = new HelloWorld();
        System.out.println(myFirstHW.sayHello());
    }

    /**
       @return Returns a greeting (in English).
    */
    public String sayHello() {
	return greeting;
    }
    
}
