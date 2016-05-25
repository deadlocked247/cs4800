public class PriorityHeap{
	private HeapNode[] heap;
	private HashMap<String, Int> pos = new HashMap<String, Int>();
	private int fullSize, size;
	public PriorityHeap(int fullSize) {
			this.fullSize = fullSize + 1;
			heap = new HeapNode[this.fullSize];
			size = 0;
			
	}
	
	public HeapNode extractMin() {
		int parent, child;
		HeapNode min, val;
		if(isEmpty()) {
			return null;
		}
		
		min = heap[1];
		val = heap[Size--];
		
		parent = 1;
		child = 2;
		while (child <= heapSize) {
			if (child  < Size && heap[child].minDist < heap[child + 1].minDist)
				child++;
			if (val.minDist >= heap[child].priority) 
				break;
			
			heap[parent] = heap[child];
			
			child *= 2;
			
		}
		heap[parent] = val;
		
		return min;
	
	}
	
	
	public void changeKey(vertex v, int newMin) {}
	
	public Key
}

public class HeapNode {
	public int minDist;
	public Vertex nodeVertex;
	
	public HeapNode(Vertex nodeVertex, int minDistance) {
		this.nodeVertex = nodeVertex;
		this.minDistance = minDistance;
	}
}