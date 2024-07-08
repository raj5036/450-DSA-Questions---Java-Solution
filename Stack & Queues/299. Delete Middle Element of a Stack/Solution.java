import java.util.*;
import java.io.*;

public class Solution {
	public static void deleteMiddle(Stack<Integer> stack, int N) {
		// WRITE YOUR CODE HERE
		// inputStack.push(item)
		List<Integer> list = new ArrayList<>();
		while (!stack.empty()) {
			int item = stack.peek();
			list.add(item);
			stack.pop();
		}

		int middleElementIndex = (N % 2 == 0)
				? (N / 2) - 1
				: ((N + 1) / 2) - 1;

		list.remove(middleElementIndex);
		Collections.reverse(list);

		for (Integer i : list) {
			stack.push(i);
		}
	}
}