package net.givreardent.sam.congruence_solver;

public class LinearCongruenceSolver {

	public static int gcd(int a, int b) {
		if (a < b)
			return gcd(b, a);
		else if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}
 
	public static boolean divides(int a, int b) {
		return (b % a == 0);
	}
 
	public static String solveCongruence(int a, int b, int m) {
		int d = gcd(a,m);
		if (divides(d,b))
			for(int i = 0; i < m; i++) {
				if ((a * i - b) % m == 0)
					return "The solution is x ≡ " + i + " (mod " + m + ")";
			}
		else
			return "No solution.";
		return "Error in calculation.";
	}
	
}
