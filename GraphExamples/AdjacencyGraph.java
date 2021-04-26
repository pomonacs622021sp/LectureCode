import java.util.LinkedList;

public class AdjacencyGraph implements Graph{
    private LinkedList<Integer>[] adj;
    
    // Initializes an empty graph with V vertices and no edges
    public AdjacencyGraph(int numberOfVertices) {
        adj = (LinkedList<Integer>[]) new LinkedList[numberOfVertices];
        
        for (int v = 0; v < numberOfVertices; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    // Adds an undirected edge v-w to this graph.
    public void addUndirectedEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Returns the vertices adjacent to vertex v.
    public Iterable<Integer> adj(int v) {
       return adj[v];
    }
    
    public int numberOfVertices() {
    	return adj.length;
    }

	public boolean edgeExists(int u, int v) {
		return adj[u].contains(v);
	}
}
