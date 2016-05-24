import java.util.*;

/**
  Graph implementation
**/
public class Graph {
  private HashMap<Vertex, TreeSet<Vertex>> adjList;
	private HashMap<String, Vertex> vertices;

  public Graph() {
    adjList = new HashMap<Vertex, TreeSet<Vertex>>();
		vertices = new HashMap<String, Vertex>();
  }

  public boolean vertexExists(String vertex) {
    return vertices.containsKey(vertex);
  }

  public boolean edgeExists(String from, String to) {
    return vertexExists(from) && vertexExists(to) && adjList.get(vertices.get(from)).contains(vertices.get(to));
  }

}
