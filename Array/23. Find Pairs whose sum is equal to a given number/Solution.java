
//User function Template for Java
import java.util.*;;

class Solution {
	int getPairsCount(int[] arr, int n, int sum) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		// Store counts of all elements in map hm
		for (int i = 0; i < n; i++) {

			// initializing value to 0, if key not found
			if (!hm.containsKey(arr[i]))
				hm.put(arr[i], 0);

			hm.put(arr[i], hm.get(arr[i]) + 1);
		}
		int twice_count = 0;

		// iterate through each element and increment the
		// count (Notice that every pair is counted twice)
		for (int i = 0; i < n; i++) {
			int complement = sum - arr[i];
			if (hm.containsKey(complement))
				twice_count += hm.get(complement);

			// if (arr[i], arr[i]) pair satisfies the
			// condition, then we need to ensure that the
			// count is decreased by one such that the
			// (arr[i], arr[i]) pair is not considered
			if (complement == arr[i])
				twice_count--;
		}

		// return the half of twice_count
		return twice_count / 2;

	}
}
