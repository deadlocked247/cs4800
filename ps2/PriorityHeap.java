import java.util.*;

/*
PriorityHeap creates a weakly sorted tree
that provides the smallest value in log N operations
Also implements insert to add new elements, fixing the heap
afterwords. 
*/
public class PriorityHeap{
	private HeapNode[] heap;
	private HashMap<String, Integer> pos = new HashMap<String, Integer>();
	private int fullSize, size;
	public PriorityHeap(int fullSize) {
			this.fullSize = fullSize + 1;
			heap = new HeapNode[this.fullSize];
			size = 0;

	}
	/* isEmpty() used to check if any elements left */
	public boolean isEmpty() {
		return size == 0;
	}
	/* isFull() checks if array is at capacity */
	public boolean isFull() {
		return size == fullSize - 1;
	}
	/* size() gives the number of elements in the heap */
	public int size() {
		return size;
	}

	/* insert adds the vertex and it's minimum distance as a HeapNode to the
	heap, using the heapify up process, wherein it compares succesively higher
	parents of the tree with the new element, and if the key is higher, swaps 
	elements and goes to the parents by dividing the index by 2. Also fixes 
	the HashMap<Vertex, Integer> as it re-heapifies.
	*/
	public void insert(Vertex vertex, int minDist) {
		HeapNode newNode = new HeapNode(vertex, minDist);

		heap[++size] = newNode;

		int newPos = size;
		while (newPos != 1 && newNode.minDist < heap[newPos/2].minDist) {
			heap[newPos] = heap[newPos/2];
			pos.put(heap[newPos].nodeVertex.getName(),newPos);
			newPos /= 2;
		}
		heap[newPos] = newNode;
		pos.put(heap[newPos].nodeVertex.getName(),newPos);
	}
	/* returns the root of the tree, which has the smallest distance 
	value, and removes it from the tree. Fixes the whole be grabbing 
	the last element in the heap and putting it in the node, then heapifying 
	down, which compares the min value of the children, and if both are smaller
	swaps with the larger righthand child and keeps heading down until it
	finds a larger node or reaches the original position.
	*/
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
			if (child  < size && heap[child].minDist > heap[child + 1].minDist)
				child++;
			if (val.minDist <= heap[child].minDist) 
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

	/* Changes the min distance of a specific vertex in the heap, by looking
	at it's position using a HashMap of vertexes to distances. Then heapifies
	up to fix the position. 
	Also fixes 
	the HashMap<Vertex, Integer> as it re-heapifies.
	*/
	public void changeKey(Vertex v, int newMin) {
		int firstPos = pos.get(v.getName());
		heap[firstPos].minDist = newMin;
		HeapNode firstNode = heap[firstPos];

		int newPos = firstPos;
		while (newPos != 1 && newMin < heap[newPos/2].minDist) {
			heap[newPos] = heap[newPos/2];
			pos.put(heap[newPos].nodeVertex.getName(),newPos);
			newPos /= 2;
		}
		heap[newPos] = firstNode;
		pos.put(heap[newPos].nodeVertex.getName(),newPos);

	}

}
