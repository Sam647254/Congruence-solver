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
		int[] solutions;
		String answer = "";
		if (divides(d,b)) {
			solutions = new int[d];
			for(int i = 0, j = 0; i < m && j < solutions.length; i++)
				if ((a*i-b) % m == 0) {
					solutions[j] = i;
					j++;
				}
			if (solutions.length == 1)
				answer = "The solution is x ≡ " + solutions[0] + " (mod " + m + ")";
			else {
				answer = "The solutions are x ≡ ";
				for (int i = 0; i < solutions.length-1; i++) 
					answer += solutions[i] + ", ";
				answer += solutions[solutions.length-1] + " (mod " + m + ")\nOr equivalently, "
						+ solveCongruence(a / d, b / d, m / d).substring(16);
			}
		}
		else
			return "No solution.";
		return answer;
	}
	
}
