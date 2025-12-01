class Solution {
	public int maxProfit_TLE(int[] prices) { // LeetCode: Time Limit Exceeded
		int maxProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int buyingPrice = prices[i], sellingPrice = prices[j];
				if (buyingPrice > sellingPrice) {
					continue;
				}

				maxProfit = Integer.max(maxProfit, sellingPrice - buyingPrice);
			}
		}
		return maxProfit;
	}

	public int maxProfit(int[] prices) {
		int buyPrice = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < buyPrice) {
				buyPrice = prices[i];
			}

			profit = Math.max(profit, prices[i] - buyPrice);
		}

		return profit;
	}
}