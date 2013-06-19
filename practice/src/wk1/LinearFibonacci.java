/* LinearFibonacci.java */

package wk1;

/**
 * An implementation of the FibonacciTemplate abstract class.
 * This particular implementation uses a linear growth to calculate
 * the fibonacci sequence result for n. 
 * 
 * @author Eric Bratt
 * @version 2013-06-19
 */

public class LinearFibonacci extends FibonacciTemplate {

	public LinearFibonacci(int n) { super(n); }

	@Override
	int fib(int n) {
		int current = 1, next = 1, nextNext;
		for (int i = 1; i < n; i++) {
			nextNext = next + current;
			current = next;
			next = nextNext;
		}
		return current;
	}
}
