
// https://www.geeksforgeeks.org/dsa/detect-cycle-undirected-graph/
// Using Depth First Search - O(V+E) Time and O(V) Space
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unchecked")
public class Solution {
	static class Graph {
		int V;
		ArrayList<Integer> adjList[];

		Graph(int V) {
			this.V = V;

			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				adjList[i] = new ArrayList<>();
			}
		}

		void addEdge(int src, int dest) {
			adjList[src].add(dest);
			adjList[dest].add(src);
		}

		boolean detectCycle() {
			boolean[] visited = new boolean[V];
			Arrays.fill(visited, false);

			for (int i = 0; i < V; i++) {
				if (!visited[i] && detectCycleUtil(i, -1, visited)) {
					return true;
				}
			}

			return false;
		}

		boolean detectCycleUtil(int node, int parent, boolean[] visited) {
			visited[node] = true;

			for (int i : adjList[node]) {
				if (!visited[i]) {
					if (detectCycleUtil(i, node, visited)) {
						return true;
					}
				} else if (i != parent) {
					return true;
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		int V = 4;
		int[][] edges = {
				{ 0, 1 }, { 1, 2 }, { 2, 3 }
		};

		Graph graph = new Graph(V);
		for (int[] edge : edges) {
			int src = edge[0], dest = edge[1];
			graph.addEdge(src, dest);
		}

		System.out.println(graph.detectCycle());
	}
}
