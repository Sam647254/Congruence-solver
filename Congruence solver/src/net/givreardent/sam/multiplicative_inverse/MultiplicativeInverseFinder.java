package net.givreardent.sam.multiplicative_inverse;

import net.givreardent.sam.congruence_solver.*;

public class MultiplicativeInverseFinder {

	public static String findMultiplcativeInverse(int a, int z) {
		int d = LinearCongruenceSolver.gcd(a, z);
		String result;
		if (d == 1) {
			result = "The inverse is " + LinearCongruenceSolver.solveCongruence(a, 1, z).substring(16);
		}
		else
			result = "No multiplicative inverse exists.";
		return result;
	}
}
