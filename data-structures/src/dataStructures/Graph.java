package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph<T> {
  
  /*
   * A graph is represented by a map of nodes to edges. Values of nodes must be unique.
   */
  private HashMap<T, HashSet<Edge<T>>> edges;
  
  public Graph() {
    edges = new HashMap<T, HashSet<Edge<T>>>();
  }
  
  public Graph(T[] values) {
    this();
    for(T value : values) {
      addNode(value);
    }
  }
  
  public void addEdge(T from, T to, int weight) throws IllegalArgumentException {
    if (!edges.containsKey(from) || !edges.containsKey(to)) {
      throw new IllegalArgumentException("both nodes of an edge must exist in the graph before adding");
    } else {
      HashSet<Edge<T>> bucketEdges = edges.get(from);
      boolean edgeExists = bucketEdges.stream().filter(e -> e.dest.equals(to)).findFirst().isPresent();
      boolean loopExists = bucketEdges.stream().filter(e -> e.dest.equals(from)).findFirst().isPresent();
      if (edgeExists) {
        throw new IllegalArgumentException("Cannot add duplicate edge");
      } else if (loopExists) {
        throw new IllegalArgumentException("No loops allowed");
      } else {
        bucketEdges.add(new Edge<T>(to, weight));
        edges.put(from, bucketEdges);
      }
    }
    
  }
  
  public void addNode(T value) throws IllegalArgumentException {
    if (edges.containsKey(value)) {
      throw new IllegalArgumentException("No duplicate node values allowed");
    } else {
      edges.put(value, new HashSet<Edge<T>>());
    }
  }
  
  public ArrayList<T> adjacentNodes(T source) {
    ArrayList<T> neighbors = new ArrayList<T>();
    for(Edge<T> edge : edges.get(source)) {
      neighbors.add(edge.dest);
    }
    return neighbors;
  }
  
  public ArrayList<Edge<T>> outgoingEdges(T source) {
    ArrayList<Edge<T>> edges = new ArrayList<Edge<T>>();
    edges.addAll(this.edges.get(source));
    return edges;
  }
  
  public String toString() {
    StringBuilder toReturn = new StringBuilder();
    for(T key : edges.keySet()) {
      toReturn.append(key.toString());
      toReturn.append(" -> [");
      for(Edge<T> edge : edges.get(key)) {
        toReturn.append(edge.dest.toString());
        toReturn.append("(");
        toReturn.append(edge.weight);
        toReturn.append("), ");
      }
      if (edges.get(key).size() > 0) {
        toReturn.delete(toReturn.length() - 2, toReturn.length());
      }
      toReturn.append("]\n");
    }
    return toReturn.toString();
  }
  
  public T bfs(T searchVal) {
    return null;
  }
  
  public T dfs(T searchVal) {
    return null;
  }
}
