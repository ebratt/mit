/**
 * This is part of the Problem Set 0: Introduction for 6.170 Fall 2005.
 */
package ps0;

/**
 * HolaWorld is like HelloWorld except it can say hello in Spanish!
 */
public class HolaWorld extends HelloWorld {

    /** Greeting in Spanish */
    static final String spanishGreeting = "Hola Mundo!";

    /**
     * Shows what happens when the sayHello() method
     * of both HelloWorld and HolaWorld are invoked
     */
    public static void main(String[] argv) {

	// Create the Hello World objects.
	HelloWorld myFirstHW = new HelloWorld();
        HolaWorld world = new HolaWorld();

	// Print out greetings
        System.out.println(myFirstHW.sayHello());
        System.out.println(world.sayHello());
    }

    /**
       @return Returns a greeting (in Spanish).
    */
    public String sayHello() {
	return spanishGreeting;
    }
    
}
