package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Function;

public class SortClient {

  public static void main(String[] args) throws FileNotFoundException {
    Integer[] shortIntArray = {4, 13, 6, 3, 9, 10, 4, 8, 6, 5, -2, 9};
    String expectedShortIntString = "[-2, 3, 4, 4, 5, 6, 6, 8, 9, 9, 10, 13]";
    String expectedSortedStrings = "[apple, banana, grape, orange, peach, strawberry]";
    String[] stringArray = {"orange", "apple", "grape", "banana", "peach", "strawberry"};
    Integer[] longIntArray = getLongIntArray();
    
    Sort<Integer> intSorter = new Sort<Integer>();
    Function<Integer[], Integer[]> intSelectionSort = (Integer[] arr) -> { return intSorter.selectionSort(arr); };
    Function<Integer[], Integer[]> intInsertionSort = (Integer[] arr) -> { return intSorter.insertionSort(arr); };
    Function<Integer[], Integer[]> intRecursiveMergeSort = (Integer[] arr) -> { return intSorter.recursiveMergeSort(arr); };
    Function<Integer[], Integer[]> intIterativeMergeSort = (Integer[] arr) -> { return intSorter.iterativeMergeSort(arr); };
    Function<Integer[], Integer[]> intQuickSort = (Integer[] arr) -> { return intSorter.quickSort(arr); };
    Function<Integer[], Integer[]> intTriQuickSort = (Integer[] arr) -> { return intSorter.triPartitionQuickSort(arr); };
    Function<Integer[], Integer[]> intHeapSort = (Integer[] arr) -> { return intSorter.heapSort(arr); };

    integerSort(intSelectionSort, shortIntArray, expectedShortIntString, "selection sort", false);
    integerSort(intInsertionSort, shortIntArray, expectedShortIntString, "insertion sort", false);
    integerSort(intRecursiveMergeSort, shortIntArray, expectedShortIntString, "recursive merge sort", false);
    integerSort(intIterativeMergeSort, shortIntArray, expectedShortIntString, "iterative merge sort", false);
    integerSort(intQuickSort, shortIntArray, expectedShortIntString, "quick sort", false);
    integerSort(intTriQuickSort, shortIntArray, expectedShortIntString, "triple partition quick sort", false);
    integerSort(intHeapSort, shortIntArray, expectedShortIntString, "heap sort", true);

    Sort<String> stringSorter = new Sort<String>();
    Function<String[], String[]> stringSelectionSort = (String[] arr) -> { return stringSorter.selectionSort(arr); };
    Function<String[], String[]> stringInsertionSort = (String[] arr) -> { return stringSorter.insertionSort(arr); };
    Function<String[], String[]> stringRecursiveMergeSort = (String[] arr) -> { return stringSorter.recursiveMergeSort(arr); };
    Function<String[], String[]> stringIterativeMergeSort = (String[] arr) -> { return stringSorter.iterativeMergeSort(arr); };
    Function<String[], String[]> stringQuickSort = (String[] arr) -> { return stringSorter.quickSort(arr); };
    Function<String[], String[]> stringTriQuickSort = (String[] arr) -> { return stringSorter.triPartitionQuickSort(arr); };
    Function<String[], String[]> stringHeapSort = (String[] arr) -> { return stringSorter.heapSort(arr); };

    stringSort(stringSelectionSort, stringArray, expectedSortedStrings, "selection sort", false);
    stringSort(stringInsertionSort, stringArray, expectedSortedStrings, "insertion sort", false);
    stringSort(stringRecursiveMergeSort, stringArray, expectedSortedStrings, "recursive merge sort", false);
    stringSort(stringIterativeMergeSort, stringArray, expectedSortedStrings, "iterative merge sort", false);
    stringSort(stringQuickSort, stringArray, expectedSortedStrings, "quick sort", false);
    stringSort(stringTriQuickSort, stringArray, expectedSortedStrings, "triple partition quick sort", false);
    stringSort(stringHeapSort, stringArray, expectedSortedStrings, "heap sort", true);

    integerSort(intSelectionSort, longIntArray, null, "selection sort", false);
    integerSort(intInsertionSort, longIntArray, null, "insertion sort", false);
    integerSort(intRecursiveMergeSort, longIntArray, null, "recursive merge sort", false);
    integerSort(intIterativeMergeSort, longIntArray, null, "iterative merge sort", false);
    integerSort(intQuickSort, longIntArray, null, "quick sort", false);
    integerSort(intHeapSort, longIntArray, null, "heap sort", false);
  }
  
  public static void integerSort(Function<Integer[], Integer[]> sortFunction, Integer[] arrToSort,
      String expected, String sortType, boolean printExpectedActual) {
    long startIntSelectionSort = System.nanoTime();
    Integer[] sortedInts = sortFunction.apply(arrToSort);
    double intSortTime = (System.nanoTime() - startIntSelectionSort) / 1000000.0;
    System.out.println("Time to sort integer array with " + sortType + ": " + intSortTime + "ms");
    
    if (printExpectedActual) {
      System.out.println("expected: " + expected);
      System.out.print("actual: [");
      for(int i = 0; i < sortedInts.length - 1; i++) {
        System.out.print(sortedInts[i] + ", ");
      }
      System.out.println(sortedInts[sortedInts.length - 1] + "]");
    }
  }
  
  public static void stringSort(Function<String[], String[]> sortFunction, String[] arrToSort,
      String expected, String sortType, boolean printExpectedActual) {
    long startStringSelectionSort = System.nanoTime();
    String[] sortedStrings = sortFunction.apply(arrToSort);
    double stringSelectionSortTime = (System.nanoTime() - startStringSelectionSort) / 1000000.0;
    System.out.println("Time to sort string array with " + sortType + ": " + stringSelectionSortTime + "ms");
    if (printExpectedActual) {
      System.out.println("expected: " + expected);
      System.out.print("actual: [");
      for(int i = 0; i < sortedStrings.length - 1; i++) {
        System.out.print(sortedStrings[i] + ", ");
      }
      System.out.println(sortedStrings[sortedStrings.length - 1] + "]");
    }
  }
  
  public static Integer[] getLongIntArray() throws FileNotFoundException {
    Integer[] longIntArray = new Integer[10000];
    File file = new File("src/algorithms/randomInts.txt");
    Scanner fileScanner = new Scanner(file);
    Scanner randomInts = fileScanner.useDelimiter(",\\s*");
    Integer randomInt;
    int i = 0;
    while (randomInts.hasNext()) {
      // find next line
      randomInt = Integer.parseInt(randomInts.next());
      longIntArray[i] = randomInt;
      i++;
    }
    fileScanner.close();
    randomInts.close();
    return longIntArray;
  }
}
