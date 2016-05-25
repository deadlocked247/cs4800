import java.io.*;
import java.util.Scanner;

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
    try {
      Scanner input = new Scanner(new File(args[0]));
      while (input.hasNext()) {
        String str = input.next().split("=");
        String nodes = str[0].split(",");
        Vertex v1 = g.getVertex(nodes[0]);
        Vertex v2 = g.getVertex(nodes[1]);
        if (!v1) v1 = new Vertex(nodes[0]);
        if (!v2) v2 = new Vertex(nodes[1]);
        Edge e = g.getEdgeBetweenVertex(v1, v2);
        if (!e) e = new Edge(v1, v2, str[1]);
        g.addEdge(e);
      }
    } catch (FileNotFoundException ex) {
        System.out.println("Error loading file");
        return;
    }
    g.printGraph();
  }
}
