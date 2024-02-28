import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

	/*
	 * Time complexity: O(V + E), where V is the number of vertices and E is the
	 * number of edges in the graph.
	 * Auxiliary Space: O(V + E), since an extra visited array of size V is
	 * required, And stack size for iterative call to DFS function.
	 */
	void DFS(int src) {
		Boolean[] visited = new Boolean[this.V];
		Arrays.fill(visited, false);

		DFSUtil(src, visited);
	}

	void DFSUtil(int currentNode, Boolean[] visited) {
		System.out.print(currentNode + " ");
		visited[currentNode] = true;

		ArrayList<Integer> adjacentNodes = this.adjList[currentNode];
		for (Integer adjacentNode : adjacentNodes) {
			if (!visited[adjacentNode]) {
				DFSUtil(adjacentNode, visited);
			}
		}
	}
}

public class DFS {
	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println(
				"Following is Depth First Traversal "
						+ "(starting from vertex 2)");

		// Function call
		g.DFS(2);
	}
}
