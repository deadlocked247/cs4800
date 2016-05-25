import java.util.*;

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

    public HashMap<Vertex, Integer> distanceMap;

    private HashMap<Vertex, Vertex> preMap;

    private Graph graph;

    private final int INFINITE = 99999999;

    public Dijkstra(Graph g) {
        this.graph = g;
        this.distanceMap = new HashMap<Vertex, Integer>();
        this.preMap = new HashMap<Vertex, Vertex>();

    }

    public void createPaths(Vertex startVertex) {

      PriorityHeap Q = new PriorityHeap(graph.getAllVertices().size());

      Q.insert(startVertex, 0);
      this.distanceMap.put(startVertex, 0);

      for (Vertex v : graph.getAllVertices()) {
        if (!v.equals(startVertex)) {
          this.distanceMap.put(v, INFINITE);
          Q.insert(v, INFINITE);
        }
      }



      while(!Q.isEmpty()) {

        HeapNode u = Q.extractMin();
        System.out.println(u.nodeVertex.getName());

        List<Edge> edgeList = this.graph.getAllEdgesForVertex(u.nodeVertex);
        for (Edge e : edgeList) {
          Vertex neighbor = e.getFrom();
          if (e.getFrom().equals(u.nodeVertex)) {
            neighbor = e.getTo();
          }
          System.out.println(this.distanceMap.get(neighbor) + " TO " + (u.minDist + e.getWeight()));

          if (this.distanceMap.get(neighbor) > u.minDist + e.getWeight()) {
            System.out.println("min dist: " + u.minDist + " " + e.print() + ": "+ e.getWeight());
            this.distanceMap.put(neighbor, u.minDist + e.getWeight());
            Q.changeKey(neighbor, u.minDist + e.getWeight());
            this.preMap.put(neighbor, u.nodeVertex);
          }
        }
        System.out.println();

      }
    }


    public String print() {
      String str = "";
      for (Map.Entry<Vertex, Integer> entry : this.distanceMap.entrySet()) {
        str += entry.getKey().getName() + "=" + entry.getValue() + ", ";
      }
      return str;
    }
}
