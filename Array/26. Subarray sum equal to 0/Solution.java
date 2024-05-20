import java.util.*;

public class Solution {
	static boolean findSum(int arr[], int n) { // GFG Accepted Solution
		Set<Integer> set = new HashSet<Integer>();
		int currentSum = 0;

		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];

			if (currentSum == 0 || arr[i] == 0 || set.contains(currentSum)) {
				return true;
			}

			set.add(currentSum);
		}

		return false;
	}
}