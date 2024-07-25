import java.util.*;

@SuppressWarnings("unchecked")
class Graph {
	int V;
	ArrayList<Integer>[] adjList;

	Graph(int V) {
		this.V = V;
		this.adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	void addEdge(int src, int destination) { // This is a directed Graph
		this.adjList[src].add(destination);
	}

	void printGraph() {
		for (int v = 0; v < this.V; v++) {
			ArrayList<Integer> adjacentNodes = adjList[v];
			System.out.println(v + "->");
			for (Integer adjacentNode : adjacentNodes) {
				System.out.print(adjacentNode + ", ");
			}
		}
	}

	boolean detectCycleUtil(int currentNode, Boolean[] visited, Boolean[] recStack) {
		if (recStack[currentNode]) {
			return true;
		}
		if (visited[currentNode]) { // Current Node is not in recStack, is already Visited
			return false;
		}

		visited[currentNode] = true;
		recStack[currentNode] = true;

		ArrayList<Integer> adjacentNodes = this.adjList[currentNode];
		for (Integer adjacentNode : adjacentNodes) {
			if (detectCycleUtil(adjacentNode, visited, recStack)) {
				return true;
			}
		}

		recStack[currentNode] = false;
		return false;
	}

	boolean detectCycle() {
		Boolean[] visited = new Boolean[this.V];
		Boolean[] recStack = new Boolean[this.V];

		Arrays.fill(visited, false);
		Arrays.fill(recStack, false);

		for (int v = 0; v < this.V; v++) {
			if (this.detectCycleUtil(v, visited, recStack)) {
				return true;
			}
		}
		return false;
	}
}

public class DetectCycle {
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		// Function call
		if (graph.detectCycle())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't "
					+ "contain cycle");
	}
}
