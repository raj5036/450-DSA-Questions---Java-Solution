public class LCS {
	// Function to find the length of the longest common subsequence of
	// sequences `X[0…m-1]` and `Y[0…n-1]`
	public static int LCSLength(String X, String Y, int m, int n) {
		// return if the end of either sequence is reached
		if (m == 0 || n == 0) {
			return 0;
		}

		// if the last character of `X` and `Y` matches
		if (X.charAt(m - 1) == Y.charAt(n - 1)) {
			return LCSLength(X, Y, m - 1, n - 1) + 1;
		}

		// otherwise, if the last character of `X` and `Y` don't match
		return Math.max(LCSLength(X, Y, m, n - 1),
				LCSLength(X, Y, m - 1, n))
	}

	public static int LCSLength(String X, String Y) {
		int m = X.length(), n = Y.length();

		// lookup table stores solution to already computed subproblems,
		// i.e., `T[i][j]` stores the length of LCS of substring
		// `X[0…i-1]` and `Y[0…j-1]`
		int[][] T = new int[m + 1][n + 1];

		// fill the lookup table in a bottom-up manner
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// if the current character of `X` and `Y` matches
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					T[i][j] = T[i - 1][j - 1] + 1;
				}
				// otherwise, if the current character of `X` and `Y` don't match
				else {
					T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
				}
			}
		}

		// LCS will be the last entry in the lookup table
		return T[m][n];
	}

	public static void main(String[] args) {
		String X = "ABCBDAB", Y = "BDCABA";

		System.out.println("The length of the LCS is "
				+ LCSLength(X, Y, X.length(), Y.length()));
	}
}