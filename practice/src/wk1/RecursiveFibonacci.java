/* RecursiveFibonacci.java */

package wk1;

/**
 * An implementation of the FibonacciTemplate abstract class.
 * This particular implementation uses recursion to calculate
 * the fibonacci sequence result for n. 
 * 
 * @author Eric Bratt
 * @version 2013-06-19
 */

public class RecursiveFibonacci extends FibonacciTemplate {

	public RecursiveFibonacci(int n) { super(n); }

	@Override
	int fib(int n) {
		if (n==0 || n==1) return 1;
		return fib(n-2) + fib(n-1);
	}
}
