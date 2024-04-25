/* 
 * First, we define the base cases for our function.
 * If the sum is equal to 0, return 1 (i.e. a valid combination of coins is found).
 * If the sum is less than 0 or the number of coins (i.e. N) is less than or equal to 0, return 0 (i.e. no valid 
 * combination of coins is possible).
 * If we take the coin then we make a recursive call and in the parameters, the array size remains the same, and 
 * the sum is decreased by coins[N-1] and stored inside a variable "take".
 * If we don't take the coin then we make a recursive call and in the parameters, we decrease the array size 
 * by 1(i.e. N-1) and the sum remains the same and we store it inside a variable notake.
 * Return the sum of take and notake (i.e. take + notake). 
 */

import java.util.Arrays;

public class Solution {
	long count(int[] coins, int N, int sum) {
		if (sum == 0) {
			return 1;
		}

		if (sum < 0 || N <= 0) {
			return 0;
		}

		long take = count(coins, N, sum - coins[N - 1]);
		long noTake = count(coins, N - 1, sum);
		return take + noTake;
	}

	long countDP(int[] coins, int N, int sum) {
		long[][] dp = new long[N + 1][sum + 1];

		for (long[] row : dp) {
			Arrays.fill(row, 0);
		}

		return countMemo(coins, N, sum, dp);
	}

	long countMemo(int[] coins, int N, int sum, long[][] dp) {
		if (sum == 0) {
			return 1;
		}

		if (sum < 0 || N <= 0) {
			return 0;
		}

		if (dp[N][sum] != 0) {
			return dp[N][sum];
		}

		long take = countMemo(coins, N, sum - coins[N - 1], dp);
		long noTake = countMemo(coins, N - 1, sum, dp);

		dp[N][sum] = take + noTake;
		return take + noTake;
	}

	public static void main(String[] args) {

	}
}
