package dataStructures;

public class LinkedListNode<T> {
  protected T value; // Value of this node
  protected LinkedListNode<T> next; // Pointer to next node
  
  public LinkedListNode (T value, LinkedListNode<T> next) {
    this.value = value;
    this.next = next;
  }
  
  public LinkedListNode(T val) {
    this(val, null);
  }
  
  public LinkedListNode() {
    this(null, null);
  }
  
  public T getValue () {
    return this.value;
  }
  
  public LinkedListNode<T> getNext() {
    return this.next;
  }
  
  public void setValue (T val) {
    this.value = val;
  }
  
  public void setNext (LinkedListNode<T> next) {
    this.next = next;
  }
  
  public String toString() {
    return "[" + this.value.toString() + "] ->" + this.next.toString();
  }
}
