import java.util.HashSet;
import java.util.Set;

public class Solution {
	static int findLongestConseqSubsequence(int arr[], int N) { // GFG Accepted Solution
		// add your code here
		Set<Integer> set = new HashSet<>();
		for (int num : arr) {
			set.add(num);
		}

		int maxLength = 0;
		for (int i = 0; i < N; i++) {
			if (!set.contains(arr[i] - 1)) {
				int temp = arr[i], length = 0;
				while (set.contains(temp)) {
					length++;
					temp++;
				}
				maxLength = Math.max(maxLength, length); // There can be multiple subsequences, we need to find the
															// longest one
			}
		}
		return maxLength;
	}
}
