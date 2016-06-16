import java.io.*;
import java.util.*;

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

      Dijkstra dijkstra = new Dijkstra(g);
      dijkstra.createPaths(g.getVertex("V0"));
      System.out.println(dijkstra.print());
      long start = System.nanoTime();

      Scanner input2 = new Scanner(new File(args[1]));
      ArrayList<Edge> downEdges = new ArrayList<Edge>();
      System.out.println("Time: 0");
      while (input2.hasNext()) {
        String tokens[] = input2.nextLine().split("=");
        String nodes[] = tokens[0].split(",");
        Vertex v1 = g.getVertex(nodes[0]);
        Vertex v2 = g.getVertex(nodes[1]);
        String status = tokens[1];

        if (status.equals("D")) {
          downEdges.add(g.removeEdgeBetweenVertex(v1, v2));
        }
        else {
          for (Edge e : downEdges) {
            if (e.getTo().getName().equals(v1.getName()) && e.getFrom().getName().equals(v2.getName())
            || e.getTo().getName().equals(v2.getName()) && e.getFrom().getName().equals(v1.getName()) ) {
              g.addEdge(e);
              downEdges.remove(downEdges.indexOf(e));
              break;
            }
          }
        }

        dijkstra.createPaths(g.getVertex("V0"));
        System.out.println(dijkstra.print());
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start));

      }
    } catch (FileNotFoundException ex) {
        System.err.println("Error loading file");
        return;
    }
  }
}
