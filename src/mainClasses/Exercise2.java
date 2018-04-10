package mainClasses;

import toolClasses.Pair;

public class Exercise2 {

	public static void main(String[] args) {
		long a = System.nanoTime();
		long fib1 = fib1(50);
		long b = System.nanoTime();
		Pair fib2 = fib2(50);
		long c = System.nanoTime();
		System.out.println("Fib1 is "+fib1);
		System.out.println("Fib1 took "+(b-a)/1000000000+" seconds");
		System.out.println("Fib2 is ("+fib2.first()+", "+fib2.second()+")");
		System.out.println("Fib2 took "+(c-b)/1000+" microseconds");
	}

	private static long fib1(int n) {
		if (n == 1 || n == 0) return 1; 
		else return fib1(n-1) + fib1(n-2); 
	}

	private static Pair<Long> fib2(int n) {
		long one = 1;
		if (n==0||n==1)
			return new Pair<Long>(one, one);
		Pair<Long> p = fib2(n-1);
		return new Pair<Long>(p.first() + p.second(), p.first());
	}
}
