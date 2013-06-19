package wk1;

abstract class FibonacciTemplate {
	private int _n=0;

	FibonacciTemplate(int n) { 
		if (n==0) 
			throw new IllegalArgumentException();
		else
			_n = fib(n);
		}

	int fib(int n) {	return _n; }
	
	public int get() {
		return _n;
	}

	public void set(int _n) {
		this._n = _n;
	}

	@Override
	public	String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(_n);
		return sb.toString();
	}
}
