import java.util.LinkedList;

public class WeightedAdjacencyGraph implements WeightedGraph{
    private LinkedList<WeightedEdge>[] adj;
    
    // Initializes an empty graph with V vertices and no edges
    public WeightedAdjacencyGraph(int numberOfVertices) {
        adj = (LinkedList<WeightedEdge>[]) new LinkedList[numberOfVertices];
        
        for (int v = 0; v < numberOfVertices; v++) {
            adj[v] = new LinkedList<WeightedEdge>();
        }
    }

    // Adds an undirected edge v-w to this graph.
    public void addUndirectedEdge(int v, int w, int weight) {
        adj[v].add(new WeightedEdge(v, w, weight));
        adj[w].add(new WeightedEdge(w, v, weight));
    }

    // Returns the vertices adjacent to vertex v.
    public Iterable<WeightedEdge> adj(int v) {
       return adj[v];
    }
    
    public int numberOfVertices() {
    	return adj.length;
    }

	public boolean edgeExists(int u, int v) {
		// TODO
		return false;
	}
}
