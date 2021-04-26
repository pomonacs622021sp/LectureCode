import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPaths {

	public static void bfsDistances(Graph g, int start) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[g.numberOfVertices()];
		int[] edgeTo = new int[g.numberOfVertices()];
		int[] distTo = new int[g.numberOfVertices()];
		
		q.addLast(start);
		visited[start] = true;
		distTo[start] = 0;

		while( !q.isEmpty() ) {
			int v = q.removeFirst();

			for( int adj: g.adj(v) ) {
				if( !visited[adj] ) {
					visited[adj] = true;
					edgeTo[adj] = v;
					distTo[adj] = distTo[v] + 1;
					q.addLast(adj);
				}
			}
		}
		
		printDistTo(distTo);
		printEdgeTo(edgeTo);
	}
	
	public static void dijkstra(WeightedGraph g, int start) {
		IndexMinPQ<Double> pq = new IndexMinPQ<Double>(g.numberOfVertices());
		int[] edgeTo = new int[g.numberOfVertices()];
		double[] distTo = new double[g.numberOfVertices()];
		
		for( int v = 0; v < g.numberOfVertices(); v++ ) {
			distTo[v] = Double.POSITIVE_INFINITY;
			pq.insert(v, Double.POSITIVE_INFINITY);
		}
		
		distTo[start] = 0.0;
		pq.decreaseKey(start, 0.0);

		while( !pq.isEmpty() ) {
			int v = pq.delMin();
			
			for (WeightedEdge e : g.adj(v)) {
				int adj = e.to();
				
				if( distTo[v] + e.weight() < distTo[adj] ) {
					distTo[adj] = distTo[v] + e.weight();
					edgeTo[adj] = v;
					pq.decreaseKey(adj, distTo[adj]);
				}
			}
		}
		
		printDistTo(distTo);
		printEdgeTo(edgeTo);
	}
	
	public static void fasterDijkstra(WeightedGraph g, int start) {
		IndexMinPQ<Double> pq = new IndexMinPQ<Double>(g.numberOfVertices());
		int[] edgeTo = new int[g.numberOfVertices()];
		double[] distTo = new double[g.numberOfVertices()];
		
		for( int v = 0; v < g.numberOfVertices(); v++ ) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		
		distTo[start] = 0.0;
		pq.insert(start, 0.0);

		while( !pq.isEmpty() ) {
			int v = pq.delMin();
			
			for (WeightedEdge e : g.adj(v)) {
				int adj = e.to();
				
				if( distTo[v] + e.weight() < distTo[adj] ) {
					distTo[adj] = distTo[v] + e.weight();
					edgeTo[adj] = v;
					
					if( pq.contains(adj) ) {
						pq.decreaseKey(adj, distTo[adj]);
					} else {
						pq.insert(adj, distTo[adj]);
					}
				}
			}
		}
		
		printDistTo(distTo);
		printEdgeTo(edgeTo);
	}
	
	private static void printDistTo(int[] distTo) {
		for( int i = 0; i < distTo.length; i++ ) {
			System.out.println(vToLetter(i) + ": " + distTo[i]);
		}
	}
	
	private static void printDistTo(double[] distTo) {
		for( int i = 0; i < distTo.length; i++ ) {
			System.out.println(vToLetter(i) + ": " + distTo[i]);
		}
	}
	
	public static void printEdgeTo(int[] edgeTo) {
		for( int i = 0; i < edgeTo.length; i++ ) {
			System.out.println(vToLetter(edgeTo[i]) + " -> " +
					vToLetter(i));
		}
	}

	public static Graph shortestPathGraph() {
		// A B C D E
		// 0 1 2 3 4
		Graph g = new AdjacencyGraph(5);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(0, 2);
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(1, 3);
		g.addUndirectedEdge(1, 4);
		g.addUndirectedEdge(2, 4);
		g.addUndirectedEdge(3, 4);

		return g;
	}
	
	public static WeightedGraph shortestPathWeightedGraph() {
		// A B C D E
		// 0 1 2 3 4
		WeightedGraph g = new WeightedAdjacencyGraph(5);
		g.addUndirectedEdge(0, 1, 3);
		g.addUndirectedEdge(0, 2, 1);
		g.addUndirectedEdge(1, 2, 1);
		g.addUndirectedEdge(1, 3, 3);
		g.addUndirectedEdge(1, 4, 1);
		g.addUndirectedEdge(2, 4, 4);
		g.addUndirectedEdge(3, 4, 2);

		return g;
	}

	private static char vToLetter(int index) {
		// A is 65 in ascii and the other capital letters follow
		return(char)(65 + index);
	}

	public static void main(String[] args) {
		//bfsDistances(shortestPathGraph(), 0);
		dijkstra(shortestPathWeightedGraph(), 0);
	}
}
