package dataStructures;

public class Edge<T> {
  protected T dest;
  protected int weight;
  
  public Edge(T dest, int weight) {
    this.dest = dest;
    this.weight = weight;
  }
}
