import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
	static class Pair {
		String s;
		int count;

		Pair(String s, int count) {
			this.s = s;
			this.count = count;
		}
	}

	static class SortByCount implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return a.count - b.count;
		}
	}

	static String secFrequent(String arr[], int N) {
		// your code here
		Map<String, Integer> map = new TreeMap<>();

		for (String str : arr) {
			if (!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				int currentCount = map.get(str);
				map.put(str, currentCount + 1);
			}
		}

		List<Pair> list = new ArrayList<>();
		map.forEach((k, v) -> {
			list.add(new Pair(k, v));
		});

		Collections.sort(list, new SortByCount());

		return list.get(1).s;
	}

	public static void main(String[] args) {
		String[] arr = { "aaa", "bbb", "ccc", "bbb", "aaa", "aaa" };
		System.out.println(secFrequent(arr, arr.length));
	}
}
