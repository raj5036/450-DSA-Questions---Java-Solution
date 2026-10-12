import java.util.*;

public class FindOdd {
	public static int findIt(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : a) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				int count = map.get(num);
				map.put(num, count + 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();

			if (value % 2 != 0) {
				return key;
			}
		}
		return a[0];
	}
}