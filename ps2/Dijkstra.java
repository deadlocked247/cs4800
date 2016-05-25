/**

  Burak Aslan
  Eli Abidor
  CS4800
  PS2
  Dijkstra.java - reads and writes to files

  2 arguments
  The first is the file should be a list of edges that make up a graph,
  one edge per line, in the format:

  vertexname1,vertexname2=distance

  The second is a list of updates to the graph in the format:

  vertexname1,vertexname2=D
**/

public class Dijkstra {
  public static void main(String [] args) {
    Graph g = new Graph();
    Vertex v1 = new Vertex("A");
    Vertex v2 = new Vertex("B");
    Vertex v3 = new Vertex("C");

    g.addVertex(v1);
    g.addVertex(v2);
    g.addVertex(v3);

    g.addEdge(new Edge(v1, v3));
    g.addEdge(new Edge(v2, v3));
    
    g.printGraph();
  }
}
