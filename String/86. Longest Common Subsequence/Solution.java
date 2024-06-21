public class Solution {
	int util(String a, String b, int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		}

		if (a.charAt(n - 1) == b.charAt(m - 1)) {
			return 1 + util(a, b, n - 1, m - 1);
		}

		return Math.max(
				util(a, b, n - 1, m),
				util(a, b, n, m - 1));
	}

	int utilDP(String a, String b, int n, int m) {
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(
							dp[i][j - 1],
							dp[i - 1][j]);
				}
			}
		}

		return dp[n][m];
	}

	public int longestCommonSubsequence(String text1, String text2) {
		int n = text1.length(), m = text2.length();
		return utilDP(text1, text2, n, m);
	}
}