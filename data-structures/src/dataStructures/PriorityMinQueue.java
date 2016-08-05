package dataStructures;

import java.util.HashMap;

public class PriorityMinQueue <T extends Comparable<T>> {
  private PQNode<T>[] arr;
  private int size;
  private HashMap<T, Integer> priorityMap;
  
  @SuppressWarnings("unchecked")
  public PriorityMinQueue(int size) {
    this.size = 0;
    this.arr = new PQNode[size + 1];
    priorityMap = new HashMap<T, Integer>();
  }
  
  public PriorityMinQueue() {
    this(10);
  }
  
  @SuppressWarnings("unchecked")
  private void ensureSize() {
    if (arr.length <= size + 1) {
      // increase capacity
      PQNode<T>[] largerArr = new PQNode[(size + 1) * 2];
      for(int i = 0; i < arr.length; i++) {
        largerArr[i] = arr[i];
      }
      arr = largerArr;
    }
    if (size < arr.length / 4) {
      PQNode<T>[] smallerArr = new PQNode[arr.length / 2];
      for (int i = 0; i <= size; i++) {
        smallerArr[i] = arr[i];
      }
      arr = smallerArr;
    }
  }

  public void insert(T elt, int priority) throws IllegalArgumentException {
    if (priorityMap.containsKey(elt)) {
      throw new IllegalArgumentException("Tried to add duplicate key " + elt.toString());
    } else {
      priorityMap.put(elt, priority);
    }
    ensureSize();
    arr[++size] = new PQNode<T>(elt, priority);
    swim(size);
  }
  
  public PQNode<T> removeMin() {
    swap(1, size);
    size--;
    sink(1);
    PQNode<T> savedVal = arr[size + 1];
    arr[size + 1] = null;
    priorityMap.remove(savedVal.key);
    ensureSize();
    return savedVal;
  }
  
  public boolean containsKey(T key) {
    return this.priorityMap.containsKey(key);
  }
  
  public void decreasePriority(T key, int priority) {
//    int oldPriority = priorityMap.get(key);
    int eltIndex = findElementIndex(1, key);
    System.out.println("found element " + key.toString() + " at index " + eltIndex);
    if (eltIndex == -1) {
      throw new IllegalArgumentException("Tried to decrease priority of nonexistent key");
    } else {
      arr[eltIndex].priority = priority;
      priorityMap.put(key, priority);
      swim(eltIndex);
    }
  }
  
  // Find the index of the searchKey in the queue
  private int findElementIndex(int index, T searchKey) {
    // TODO: improve this to log(n) time
    for(int i=1; i<=size; i++) {
      if (arr[i].key.equals(searchKey)) {
        return i;
      }
    }
    return -1;
//    System.out.println("Searching for " + searchKey + " at index " + index + " in array with " + size + " elements");
//    if (index > size) {
//      return -1;
//    }
//    PQNode<T> current = arr[index];
//    if (current.priority > oldPriority) {
//      // Passed the priority, stop
//      return -1;
//    } else if (current.priority < oldPriority && index <= size / 2) {
//      // Keep searching in left and right branches
//      int isInLeftTree = findElementIndex(index * 2, oldPriority, searchKey);
//      if (isInLeftTree > -1) {
//        return isInLeftTree;
//      }
//      int isInRightTree = findElementIndex(index * 2 + 1, oldPriority, searchKey);
//      return isInRightTree;
//    } else if (index <= size) {
//      // Correct priority, check keys
//      if (current.key.equals(searchKey)) {
//        return index;
//      } else {
//        // Keep searching in left and right branches
//        int isInLeftTree = findElementIndex(index * 2, oldPriority, searchKey);
//        if (isInLeftTree > -1) {
//          return isInLeftTree;
//        }
//        int isInRightTree = findElementIndex(index * 2 + 1, oldPriority, searchKey);
//        return isInRightTree;
//      }
//    } else {
//      return -1;
//    }
  }
  
  public boolean isEmpty() {
    return size == 0;
  }

  private void swap(int index1, int index2) {
    PQNode<T> temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
  
  private void swim(int index) {
    while (index > 1 && arr[index].priority < arr[index / 2].priority) {
      swap(index, index / 2);
      index /= 2;
    }
  }
  
  private void sink(int index) {
    int leftChildIndex;
    int rightChildIndex;
    PQNode<T> leftChild;
    PQNode<T> rightChild;
    PQNode<T> parent;
    while (index <= size / 2) {
      leftChildIndex = index * 2;
      rightChildIndex = index * 2 + 1;
      leftChild = leftChildIndex > size ? null : arr[leftChildIndex];
      rightChild = rightChildIndex > size ? null : arr[rightChildIndex];
      parent = arr[index];
      if (leftChild != null && rightChild == null && parent.priority > (leftChild.priority)) {
        swap(index, leftChildIndex);
        index = leftChildIndex;
      } else if ((leftChild != null && rightChild != null) &&
          ((parent.priority > leftChild.priority) || (parent.priority > rightChild.priority))) {
        int smallerChildIndex = leftChild.priority > rightChild.priority ? rightChildIndex : leftChildIndex;
        swap(index, smallerChildIndex);
        index = smallerChildIndex;
      } else {
        break;
      }
    }
  }
}
