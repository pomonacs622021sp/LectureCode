import java.util.LinkedList;

public class MatrixGraph implements Graph {
	private boolean[][] adjMatrix;
	
	public MatrixGraph(int numberOfVertices) {
		adjMatrix = new boolean[numberOfVertices][numberOfVertices];
	}
	
	public void addUndirectedEdge(int u, int v) {
		adjMatrix[u][v] = true;
		adjMatrix[v][u] = true;
	}

	public Iterable<Integer> adj(int v) {
		LinkedList<Integer> adj = new LinkedList<Integer>();
		
		for( int i = 0; i < adjMatrix.length; i++ ) {
			if( adjMatrix[v][i] ) {
				adj.add(i);
			}
		}
		
		return adj;
	}

	public int numberOfVertices() {
		return adjMatrix.length;
	}

	public boolean edgeExists(int u, int v) {
		return adjMatrix[u][v];
	}
	
}
