/* HeapNode provides a structure to store and retrieve both the key and 
the vertex in the heap 
*/
public class HeapNode {
	public int minDist;
	public Vertex nodeVertex;
	
	public HeapNode(Vertex nodeVertex, int minDist) {
		this.nodeVertex = nodeVertex;
		this.minDist = minDist;
	}
}