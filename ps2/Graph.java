import java.util.*;

/**
  Graph implementation
**/
public class Graph {
  private HashMap<Vertex, ArrayList<Edge>> vertexMap;

  public Graph() {
    vertexMap = new HashMap<Vertex, ArrayList<Edge>>();
  }

  public void addVertex(Vertex vertex) {
    this.vertexMap.put(vertex, new ArrayList<Edge>());
  }

  public void addEdge(Edge edge) {
      this.vertexMap.get(edge.getFrom()).add(edge);
      this.vertexMap.get(edge.getTo()).add(new Edge(edge.getTo(), edge.getFrom(), edge.getWeight()));
  }

  public Edge getEdgeBetweenVertex(Vertex to, Vertex from) {
      if(to == null || from == null)
          throw new NullPointerException("Null data");

      if(!this.vertexMap.containsKey(to) || !this.vertexMap.containsKey(from))
          throw new IllegalArgumentException("Vertex not part of graph");

      for(Edge e : this.vertexMap.get(from))
          if(e.getTo().equals(to)) return e;

      return null;
  }

  public boolean hasVertex(Vertex to) {
      if (to == null)
        throw new NullPointerException("Null Vertex");
      return this.vertexMap.containsKey(to);
  }

  public List<Edge> getAllEdgesForVertex(Vertex v) {
    if (v == null)
      throw new NullPointerException("Null Vertex");
    return this.vertexMap.get(v);
  }

  public Vertex getVertex(String s) {
      if(s == null)
        throw new NullPointerException("Null Vertex");

      for (Vertex v : this.vertexMap.keySet())
        if (v.getName().equals(s))
          return v;

      return null;
  }

  public Set<Vertex> getAllVertices() {
      return this.vertexMap.keySet();
  }

  public void printGraph() {
      for (Vertex v : this.vertexMap.keySet()) {
          System.out.print(v.getName() + " -> ");
          for (Edge e : this.getAllEdgesForVertex(v)) {
              System.out.print(e.getTo().getName() + " ( " + e.getWeight() + " ) ");
          }
          System.out.println();
      }
  }

}
