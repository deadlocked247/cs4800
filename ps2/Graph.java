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
    if (!this.hasVertex(vertex)) {
      this.vertexMap.put(vertex, new ArrayList<Edge>());
    }
  }

  public void addEdge(Edge edge) {
      this.vertexMap.get(edge.getFrom()).add(edge);
      this.vertexMap.get(edge.getTo()).add(new Edge(edge.getTo(), edge.getFrom(), edge.getWeight()));
  }

  public Edge getEdgeBetweenVertex(Vertex to, Vertex from) {
      if(to == null || from == null)
        System.err.println("Null data");

      if(!this.vertexMap.containsKey(to) || !this.vertexMap.containsKey(from))
        System.err.println("Vertex not part of graph");

      for(Edge e : this.vertexMap.get(from))
        if(e.getTo().equals(to)) return e;

      return null;
  }

  public Edge removeEdgeBetweenVertex(Vertex from, Vertex to) {
      if(to == null || from == null)
        System.err.println("Null data");

      if(!this.vertexMap.containsKey(to) || !this.vertexMap.containsKey(from))
        System.err.println("Vertex not part of graph");

      Edge removed = null;

      for (Edge e : this.vertexMap.get(to)) {
        if (e.getTo().equals(from)) {
          removed = e;
        }
      }


      this.vertexMap.get(to).remove(removed);

      for (Edge e : this.vertexMap.get(from)) {
        if (e.getTo().equals(to)) {
          removed = e;
        }
      }


      this.vertexMap.get(from).remove(removed);

      return removed;
  }

  public boolean hasVertex(Vertex to) {
      if (to == null)
        System.err.println("Null Vertex");
      return this.vertexMap.containsKey(to);
  }

  public List<Edge> getAllEdgesForVertex(Vertex v) {
    if (v == null)
      System.err.println("Null Vertex");
    return this.vertexMap.get(v);
  }

  public Vertex getVertex(String s) {
      if(s == null)
        System.err.println("Null Vertex");

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
