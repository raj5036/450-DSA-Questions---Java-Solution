import java.util.*;

public class DetectLoop {
	public static boolean detectLoop(Node head) {
		Node currentNode = head;
		Set<Node> set = new HashSet<>();
		while (currentNode != null) {
			if (set.contains(currentNode)) {
				return true;
			}
			set.add(currentNode);
			currentNode = currentNode.next;
		}
		return false;
	}
}
