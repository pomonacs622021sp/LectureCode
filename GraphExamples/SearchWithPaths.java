import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SearchWithPaths {

	public static void bfs(Graph g, int start) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[g.numberOfVertices()];
		int[] edgeTo = new int[g.numberOfVertices()];

		q.addLast(start);
		visited[start] = true;

		while( !q.isEmpty() ) {
			int v = q.removeFirst();

			for( int adj: g.adj(v) ) {
				if( !visited[adj] ) {
					System.out.println("Visiting: " + vToLetter(adj));
					visited[adj] = true;
					edgeTo[adj] = v;
					q.addLast(adj);
				}
			}
		}

		printEdgeTo(edgeTo);
	}
	
	public static void temp() {
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("a");
		a.add("b");
		a.add("c");
		
		for( String val: a ) {
			System.out.println(val);
		}
	}

	public static void dfs(Graph g, int start) {
		boolean[] visited = new boolean[g.numberOfVertices()];
		int[] edgeTo = new int[g.numberOfVertices()];
		dfsHelper(g, visited, edgeTo, start);
		printEdgeTo(edgeTo);
	}

	private static void dfsHelper(Graph g, boolean[] visited, int[] edgeTo, int v) {
		visited[v] = true;
		System.out.println("Visiting: " + vToLetter(v));

		for( int adj: g.adj(v) ) {
			if( !visited[adj] ) {
				edgeTo[adj] = v;
				dfsHelper(g, visited, edgeTo, adj);
			}
		}
	}

	public static void printEdgeTo(int[] edgeTo) {
		for( int i = 0; i < edgeTo.length; i++ ) {
			System.out.println(vToLetter(edgeTo[i]) + " -> " +
					vToLetter(i));
		}
	}

	public static Graph lectureTree() {
		// A B C D E F G
		// 0 1 2 3 4 5 6
		Graph g = new MatrixGraph(7);

		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(0, 3);
		g.addUndirectedEdge(0, 4);
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(1, 5);
		g.addUndirectedEdge(4, 6);

		return g;
	}

	public static Graph lectureGraph() {
		// A B C D E F G
		// 0 1 2 3 4 5 6
		Graph g = new AdjacencyGraph(7);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(0, 4);
		g.addUndirectedEdge(0, 3);
		g.addUndirectedEdge(1, 5);
		g.addUndirectedEdge(1, 4);
		g.addUndirectedEdge(3, 4);
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(5, 6);

		return g;
	}

	private static char vToLetter(int index) {
		// A is 65 in ascii and the other capital letters follow
		return(char)(65 + index);
	}

	public static void main(String[] args) {
		dfs(lectureGraph(), 0);
	}
}
