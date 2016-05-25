import java.util.*;


public class PriorityHeap{
	private HeapNode[] heap;
	private HashMap<String, Integer> pos = new HashMap<String, Integer>();
	private int fullSize, size;
	public PriorityHeap(int fullSize) {
			this.fullSize = fullSize + 1;
			heap = new HeapNode[this.fullSize];
			size = 0;
			
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == fullSize - 1;
	}
	
	public int size() {
		return size;
	}
	
	public void insert(Vertex vertex, int minDist) {
		HeapNode newNode = new HeapNode(vertex, minDist);
		
		heap[++size] = newNode;
		
		int newPos = size;
		while (newPos != 1 && newNode.minDist > heap[newPos/2].minDist) {
			heap[newPos] = heap[newPos/2];
			pos.put(heap[newPos].nodeVertex.getName(),newPos);
			newPos /= 2;
		}
		heap[newPos] = newNode;
		pos.put(heap[newPos].nodeVertex.getName(),newPos);
	}
	
	public HeapNode extractMin() {
		int parent, child;
		HeapNode min, val;
		if(isEmpty()) {
			return null;
		}
		
		
		min = heap[1];
		val = heap[size--];
		
		parent = 1;
		child = 2;
		while (child <= size) {
			if (child  < size && heap[child].minDist < heap[child + 1].minDist)
				child++;
			if (val.minDist >= heap[child].minDist) 
				break;
			
			heap[parent] = heap[child];
			pos.put(heap[parent].nodeVertex.getName(),parent);
			parent = child;
			child *= 2;
			
		}
		heap[parent] = val;
		pos.put(heap[parent].nodeVertex.getName(),parent);
		
		return min;
	
	}
	
	
	public void changeKey(Vertex v, int newMin) {
		int firstPos = pos.get(v.getName());
		heap[firstPos].minDist = newMin;
		HeapNode firstNode = heap[firstPos];
		
		int newPos = firstPos;
		while (newPos != 1 && newMin > heap[newPos/2].minDist) {
			heap[newPos] = heap[newPos/2];
			pos.put(heap[newPos].nodeVertex.getName(),newPos);
			newPos /= 2;
		}
		heap[newPos] = firstNode;
		pos.put(heap[newPos].nodeVertex.getName(),newPos);
		
	}

}