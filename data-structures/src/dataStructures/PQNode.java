package dataStructures;

public class PQNode<T extends Comparable<T>> {
  T key;
  int priority;
  
  public PQNode(T key, int priority) {
    this.key = key;
    this.priority = priority;
  }
  
  public String toString() {
    StringBuilder toReturn = new StringBuilder("{ ");
    toReturn.append("key: ");
    toReturn.append(key.toString());
    toReturn.append(", priority: ");
    toReturn.append(priority);
    toReturn.append(" }");
    return toReturn.toString();
  }
}
