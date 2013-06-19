/* FibonacciTemplate.java */

package wk1;

/**
 * The abstract class (template) for Fibonacci implementations.  
 * 
 * @author Eric Bratt
 * @version 2013-06-19
 */

abstract class FibonacciTemplate {
	private int _n=0;
	
	/* The constructor takes an integer and checks that it is > 0. 
	 * Otherwise throws an IAE.
	 */
	FibonacciTemplate(int n) { 
		if (n==0) 
			throw new IllegalArgumentException();
		else
			_n = fib(n);
		}
	
	/* template method takes an int and returns an int */
	int fib(int n) {	return _n; }
	
	/* typical getter method to return the private field _n. */
	public int get() {
		return _n;
	}
	
	/* typical setter method to set the private field _n. */
	public void set(int _n) {
		this._n = _n;
	}
	
	/* just for fun */
	@Override
	public	String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(_n);
		return sb.toString();
	}
}
