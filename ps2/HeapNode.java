public class HeapNode {
	public int minDist;
	public Vertex nodeVertex;
	
	public HeapNode(Vertex nodeVertex, int minDist) {
		this.nodeVertex = nodeVertex;
		this.minDist = minDist;
	}
}