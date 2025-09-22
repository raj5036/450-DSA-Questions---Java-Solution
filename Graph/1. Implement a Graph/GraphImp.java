import java.util.*;

@SuppressWarnings("unchecked")
class Graph {
	int V, E;
	ArrayList<Integer> adjList[]; // You declared an array, where each element is ArrayList<Integer>

	Graph(int V, int E) {
		this.V = V;
		this.E = E;

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	void addEdge(int src, int dest) {
		this.adjList[src].add(dest);
		this.adjList[dest].add(src);
	}

	void printGraph() {
		for (int i = 0; i < V; i++) {
			System.out.println("Adjacent vertices for " + i + " is ");
			ArrayList<Integer> list = adjList[i];
			for (Integer currentNode : list) {
				System.out.println(currentNode + ", ");
			}

			Iterator<Integer> it = adjList[i].iterator();
			while (it.hasNext()) {
				int currentNode = it.next();
				System.out.print(currentNode + ", ");
			}
		}
	}
}

public class GraphImp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int V = scanner.nextInt();
		final int E = scanner.nextInt();

		Graph graph = new Graph(V, E);
		for (int i = 0; i < E; i++) {
			int src = scanner.nextInt();
			int dest = scanner.nextInt();
			graph.addEdge(src, dest);
		}
		scanner.close();

		graph.printGraph();
	}
}
