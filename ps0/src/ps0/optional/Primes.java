package ps0.optional;

public class Primes {
	protected static void findPrimes(int nValues) {
		findPrimes(0, nValues);
	}

	protected static void findPrimes(int start, int nValues) {
		boolean isPrime = true;

		for (int i = start; i <= nValues; i++) {
			isPrime = true;
      
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				//System.out.println(i);
			}
		}
	}
		

	private static void findPrimesFaster(int nValues) throws InterruptedException {
		int nFirstHalf = nValues / 2;
		PrimesRunnable pr1 = new PrimesRunnable(0, nFirstHalf);
		Thread t1 = new Thread(pr1);
		System.out.println("");
		System.out.println("\t" + t1.getName() + ": " + pr1._a + " to " + pr1._b);
		t1.start();
		PrimesRunnable pr2 = new PrimesRunnable(nFirstHalf+1, nValues);
		Thread t2 = new Thread(pr2);
		System.out.println("\t" + t2.getName() + ": " + pr2._a + " to " + pr2._b);
		t2.start();
		t1.join();
		t2.join();
	}


	private static void findPrimesEvenFaster(int nValues) throws InterruptedException {
		int nFirstQuarter = nValues / 4;
		int nSecondQuarter = nValues / 4 * 2;
		int nThirdQuarter = nValues / 4 * 3;
		int nFourthQuarter = nValues;
		PrimesRunnable pr1 = new PrimesRunnable(0, nFirstQuarter);
		Thread t1 = new Thread(pr1);
		System.out.println("");
		System.out.println("\t" + t1.getName() + ": " + pr1._a + " to " + pr1._b);
		t1.start();
		PrimesRunnable pr2 = new PrimesRunnable(nFirstQuarter+1, nSecondQuarter);
		Thread t2 = new Thread(pr2);
		System.out.println("\t" + t2.getName() + ": " + pr2._a + " to " + pr2._b);
		t2.start();
		PrimesRunnable pr3 = new PrimesRunnable(nSecondQuarter+1, nThirdQuarter);
		Thread t3 = new Thread(pr3);
		System.out.println("\t" + t3.getName() + ": " + pr3._a + " to " + pr3._b);
		t3.start();
		PrimesRunnable pr4 = new PrimesRunnable(nThirdQuarter+1, nFourthQuarter);
		Thread t4 = new Thread(pr4);
		System.out.println("\t" + t4.getName() + ": " + pr4._a + " to " + pr4._b);
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
	}



	public static void main(String[] args) throws InterruptedException {		
		
		// Find and print all primes between 0 and 50.

		System.out.println("Running method findPrimes:");
		findPrimes(50);

		System.out.println("\nRunning method findPrimesFaster:");
		findPrimesFaster(50);

		System.out.println("\nRunning method findPrimesEvenFaster:");
		findPrimesEvenFaster(50);



		// Time how long it takes to find primes.

		long startTime = 0;
		long endTime = 0;


		System.out.print("\n\nTiming method findPrimes:");
		startTime = System.currentTimeMillis();
		findPrimes(20000);
		endTime = System.currentTimeMillis();
		System.out.println("  " + (endTime-startTime) + " milliseconds");

		System.out.print("\nTiming method findPrimesFaster:");
		startTime = System.currentTimeMillis();
		findPrimesFaster(20000);
		endTime = System.currentTimeMillis();
		System.out.println("  " + (endTime-startTime) + " milliseconds");

		System.out.print("\nTiming method findPrimesEvenFaster:");
		startTime = System.currentTimeMillis();
		findPrimesEvenFaster(20000);
		endTime = System.currentTimeMillis();
		System.out.println("  " + (endTime-startTime) + " milliseconds");		


		System.out.print("\n\nTiming method findPrimes:");
		startTime = System.currentTimeMillis();
		findPrimes(50000);
		endTime = System.currentTimeMillis();
		System.out.println("  " + (endTime-startTime) + " milliseconds");

		System.out.print("\nTiming method findPrimesFaster:");
		startTime = System.currentTimeMillis();
		findPrimesFaster(50000);
		endTime = System.currentTimeMillis();
		System.out.println("  " + (endTime-startTime) + " milliseconds");

		System.out.print("\nTiming method findPrimesEvenFaster:");
		startTime = System.currentTimeMillis();
		findPrimesEvenFaster(50000);
		endTime = System.currentTimeMillis();
		System.out.println("  " + (endTime-startTime) + " milliseconds");		
	}

}




class PrimesRunnable implements Runnable {
	int _a, _b;

	public PrimesRunnable(int a, int b) {
		_a = a;
		_b = b;
	}

	@Override
	public void run() {
		Primes.findPrimes(_a, _b);
	}

}