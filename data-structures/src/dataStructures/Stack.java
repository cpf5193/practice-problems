package dataStructures;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
  private LinkedListNode<T> head;
  private int size;
  
  public Stack () {
    this.head = null;
    this.size = 0;
  }

  public void push(T item) {
    this.head = new LinkedListNode<T>(item, this.head);
    this.size++;
  }
  
  public T pop() {
    LinkedListNode<T> oldHead = this.head;
    this.head = oldHead.next;
    oldHead.next = null;
    this.size--;
    return oldHead.value;
  }
  
  public int size() {
    return this.size;
  }
  
  public boolean isEmpty() {
    return this.head == null;
  }

  @Override
  public Iterator<T> iterator() {
    return new StackIterator();
  }
  
  private class StackIterator implements Iterator<T> {
    LinkedListNode<T> current = head;
    
    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      T val = current.value;
      current = current.next;
      return val;
    }
  }
}
