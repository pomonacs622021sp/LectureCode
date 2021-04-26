
public class WeightedEdge {
	private int u;
	private int v;
	private double weight;
	
	public WeightedEdge(int u, int v, double weight ) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	
	public int from() {
		return u;
	}
	
	public int to() {
		return v;
	}
	
	public double weight() {
		return weight;
	}
}
