
public interface WeightedGraph {
	public void addUndirectedEdge(int u, int v, int weight);
	public Iterable<WeightedEdge> adj(int v);
	public int numberOfVertices();
	public boolean edgeExists(int u, int v);
}
