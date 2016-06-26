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
  
  public T[] insertionSort(T[] arr) {
    T[] array = arr.clone();
    for(int i = 0; i < array.length; i++) {
      int j = i;
      T item = array[j];
      while (j > 0 && item.compareTo(array[j - 1]) < 0) {
        T temp = array[j - 1];
        array[j - 1] = item;
        array[j] = temp;
        j--;
      }
    }
    return array;
  }
}
