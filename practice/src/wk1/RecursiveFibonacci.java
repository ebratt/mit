package wk1;

public class RecursiveFibonacci extends FibonacciTemplate {

	public RecursiveFibonacci(int n) { super(n); }

	@Override
	int fib(int n) {
		if (n==0 || n==1) return 1;
		return fib(n-2) + fib(n-1);
	}
}
