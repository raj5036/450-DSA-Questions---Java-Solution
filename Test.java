import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(-1, "-1");
		map.put(-3, "-3");
		map.put(-2, "-2");
		map.put(3, "3");
		map.put(-25, "-25");

		map.forEach((k, v) -> {
			System.out.println(k + "->" + v);
		});
		System.out.println();
		SortedSet<Integer> sortedKeys = new TreeSet<>(map.keySet());
		for (Integer key : sortedKeys) {
			System.out.println(map.get(key));
		}
	}
}
