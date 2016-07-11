package dataStructures;

public class BinaryMaxHeap<T extends Comparable<T>> {
  private T[] arr;
  private int size;
  
  @SuppressWarnings("unchecked")
  public BinaryMaxHeap(int size) {
    this.size = size;
    this.arr = (T[]) new Comparable[size + 1];
  }
  
  public BinaryMaxHeap() {
    this(10);
  }
  
  @SuppressWarnings("unchecked")
  public BinaryMaxHeap(T[] array) {
    arr = (T[]) new Comparable[array.length + 1];
    for (int i = 1; i < arr.length; i++) {
      arr[i] = array[i - 1];
    }
    size = array.length;
    for (int i = size / 2; i > 0; i--) {
      sink(i);
    }
  }
  
  @SuppressWarnings("unchecked")
  private void ensureSize() {
    if (arr.length == size) {
      // increase capacity
      T[] largerArr = (T[]) new Comparable[size * 2];
      for(int i = 0; i < arr.length; i++) {
        largerArr[i] = arr[i];
      }
      arr = largerArr;
    }
    if (size < arr.length / 4) {
      T[] smallerArr = (T[]) new Comparable[arr.length / 2];
      for (int i = 0; i <= size; i++) {
        smallerArr[i] = arr[i];
      }
      arr = smallerArr;
    }
  }

  public void insert(T elt) {
    ensureSize();
    arr[size] = elt;
    swim(size++);
  }
  
  public T removeMax() {
    swap(1, size);
    size--;
    sink(1);
    T savedVal = arr[size + 1];
    arr[size + 1] = null;
    ensureSize();
    return savedVal;
  }
  
  private void swap(int index1, int index2) {
    T temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
  
  private void swim(int index) {
    while (index > 1 && arr[index].compareTo(arr[index / 2]) > 0) {
      swap(index, index / 2);
      index /= 2;
    }
  }
  
  private void sink(int index) {
    int leftChildIndex;
    int rightChildIndex;
    T leftChild;
    T rightChild;
    T parent;
    while (index <= size / 2) {
      leftChildIndex = index * 2;
      rightChildIndex = index * 2 + 1;
      leftChild = leftChildIndex > size ? null : arr[leftChildIndex];
      rightChild = rightChildIndex > size ? null : arr[rightChildIndex];
      parent = arr[index];
      if (leftChild != null && rightChild == null && parent.compareTo(leftChild) < 0) {
        swap(index, leftChildIndex);
        index = leftChildIndex;
      } else if ((leftChild != null && rightChild != null) && (parent.compareTo(leftChild) < 0 || parent.compareTo(rightChild) < 0)) {
        int biggerChildIndex = leftChild.compareTo(rightChild) < 0 ? rightChildIndex : leftChildIndex;
        swap(index, biggerChildIndex);
        index = biggerChildIndex;
      } else {
        break;
      }
    }
  }
}
