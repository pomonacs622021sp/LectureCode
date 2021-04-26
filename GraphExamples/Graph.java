
public interface Graph {
	public void addUndirectedEdge(int u, int v);
	public Iterable<Integer> adj(int v);
	public int numberOfVertices();
	public boolean edgeExists(int u, int v);
}
