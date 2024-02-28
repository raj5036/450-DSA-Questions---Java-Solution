import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int findDuplicate(int[] nums) { // LeetCode Accepted Solution
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				return num;
			}
			set.add(num);
		}
		return -1;
	}
}
