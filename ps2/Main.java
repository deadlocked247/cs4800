import java.io.*;
import java.util.Scanner;

public class Main {
  public static void main(String [] args) {
    Graph g = new Graph();
    try {
      Scanner input = new Scanner(new File(args[0]));
      while (input.hasNext()) {
        String tokens[] = input.nextLine().split("=");
        String nodes[] = tokens[0].split(",");
        Vertex v1 = g.getVertex(nodes[0]);
        Vertex v2 = g.getVertex(nodes[1]);
        if (v1 == null) v1 = new Vertex(nodes[0]);
        if (v2 == null) v2 = new Vertex(nodes[1]);
        g.addVertex(v1);
        g.addVertex(v2);
        Edge e = g.getEdgeBetweenVertex(v1, v2);
        if (e == null) e = new Edge(v1, v2, Integer.parseInt(tokens[1]));
        g.addEdge(e);
      }
    } catch (FileNotFoundException ex) {
        System.out.println("Error loading file");
        return;
    }

    Dijkstra dijkstra = new Dijkstra(g);
    dijkstra.createPaths(g.getVertex("V0"));
    System.out.println(dijkstra.print());


  }
}
