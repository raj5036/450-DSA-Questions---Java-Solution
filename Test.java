import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {
		Map<Integer, String> Umap = new HashMap<>();
		Map<Integer, String> Omap = new TreeMap<>();

		int[] keys = { -3, -2, -1, 0, 1, 2, 3 };
		String[] values = { "-3", "-2", "-1", "0", "1", "2", "3" };

		for (int i = 0; i < keys.length; i++) {
			Umap.put(keys[i], values[i]);
			Omap.put(keys[i], values[i]);
		}

		System.out.println("Un-ordered Map");
		Umap.forEach((k, v) -> {
			System.out.print(v + " ");
		});
		System.out.println("\nOrdered Map");
		Omap.forEach((k, v) -> {
			System.out.print(v + " ");
		});
	}
}