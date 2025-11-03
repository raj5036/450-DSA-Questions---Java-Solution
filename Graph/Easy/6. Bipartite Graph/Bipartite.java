
/*
 * 🧩 What is a Bipartite Graph?
 * 
 * A bipartite graph is a graph where
 * 👉 you can divide all the vertices (nodes) into two groups,
 * so that
 * 👉 every edge (connection) always goes from one group to the other — never within the same group.
 * 
 * 🧠 Key Idea
 * You can think of it as coloring the graph using 2 colors:
 * Color 1 → Group 1
 * 
 * Color 2 → Group 2
 * If you can color the entire graph using only 2 colors such that
 * no two adjacent vertices have the same color,
 * then it’s a bipartite graph.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
class Graph {
	int V;
	ArrayList<Integer> adjList[];

	Graph(int V) {
		this.V = V;
		this.adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			this.adjList[i] = new ArrayList<>();
		}
	}

	void addEdge(int src, int dest) {
		this.adjList[src].add(dest);
		this.adjList[dest].add(src);
	}

	boolean isBipartite() {
		int[] colors = new int[this.V];
		Arrays.fill(colors, -1);

		for (int i = 0; i < V; i++) {
			if (colors[i] == -1) {
				Queue<Integer> queue = new LinkedList<>();
				colors[i] = 0;
				queue.add(i);

				// BFS
				while (!queue.isEmpty()) {
					int u = queue.poll();

					ArrayList<Integer> adj = adjList[u];
					for (Integer v : adj) {
						if (colors[v] == -1) {
							colors[v] = 1 - colors[u];
							queue.add(v);
						} else if (colors[v] == colors[u]) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}
}

public class Bipartite {
	public static void main(String[] args) {
		int V = 4;

		// Edges of the graph
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 } };

		Graph graph = new Graph(V);
		for (int[] edge : edges) {
			graph.addEdge(edge[0], edge[1]);
		}

		System.out.println(graph.isBipartite());
	}

}
