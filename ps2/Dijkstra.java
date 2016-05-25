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

    public HashSet<Edge> shortestEdgeSet;

    public HashMap<Vertex, Integer> distanceMap;

    private HashMap<Vertex, NodeStatus> visited;

    private Graph graph;

    private final Integer INFINITE = 99999999;

    public Dijkstra(Graph g) {
        shortestEdgeSet = new HashSet<Edge>();
        this.visited = new HashMap<Vertex, NodeStatus>();
        this.graph = g;
        distanceMap = initialize();
    }

    public HashMap<Vertex, Integer> createPaths(Vertex v1) {
        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(v1);
        visited.put(v1, NodeStatus.KNOWN);
        distanceMap.put(v1,0);
        while(!q.isEmpty()) {
            Vertex v = q.poll();
            visited.put(v, NodeStatus.COMPLETE);
            int distance = distanceMap.get(v);
            for(Edge e : graph.getAllEdgesForVertex(v)) {
                if(!visited.get(e.getTo()).equals(NodeStatus.COMPLETE)) {
                    distanceMap.put(e.getTo(), Math.min(distanceMap.get(e.getTo()), distance + e.getWeight()));
                    q.add(e.getTo());
                    visited.put(e.getTo(), NodeStatus.COMPLETE);
                }
            }
        }
        return distanceMap;
    }

    private HashMap<Vertex, Integer> initialize() {
        HashMap<Vertex, Integer> mapList = new HashMap<Vertex, Integer>();
        Set<Vertex> vertexList = this.graph.getAllVertices();
        for(Vertex v: vertexList) {
            mapList.put(v, INFINITE);
            this.visited.put(v, NodeStatus.UNKNOWN);
        }
        return mapList;
    }

    public String print() {
      String str = "";
      for (Map.Entry<Vertex, Integer> entry : this.distanceMap.entrySet()) {
        str += entry.getKey().getName() + "=" + entry.getValue() + ", ";
      }
      return str;
    }
}
