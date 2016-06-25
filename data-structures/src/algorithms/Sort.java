package algorithms;

public class Sort<T extends Comparable <T>> {
  
  public T[] selectionSort(T[] arr) {
    T[] array = arr.clone();
    for (int i = 0; i < array.length; i++) {
      T min = array[i];
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j].compareTo(min) < 0) {
          min = array[j];
          minIndex = j;
        }
      }
      // Swap
      if (min.compareTo(array[i]) < 0) {
        T temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
      }
    }
    return array;
  }
}
