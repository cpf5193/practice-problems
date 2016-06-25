package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortClient {

  public static void main(String[] args) throws FileNotFoundException {
    Integer[] shortIntArray = {4, 13, 6, 3, 9, 10, 4, 8, 6, 5, -2, 9};
    String[] stringArray = {"orange", "apple", "grape", "banana", "peach", "strawberry"};
    
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
    
    Sort<Integer> intSorter = new Sort<Integer>();
    long startShortIntSelectionSort = System.nanoTime();
    Integer[] sortedShortInts = intSorter.selectionSort(shortIntArray);
    double shortIntSelectionSortTime = (System.nanoTime() - startShortIntSelectionSort) / 1000000.0;
    System.out.println("Time to sort shortIntArray with selection sort: " + shortIntSelectionSortTime + "ms");
    System.out.println("expected: [-2, 3, 4, 4, 5, 6, 6, 8, 9, 9, 10, 13]");
    System.out.print("actual: [");
    for(i = 0; i < sortedShortInts.length - 1; i++) {
      System.out.print(sortedShortInts[i] + ", ");
    }
    System.out.println(sortedShortInts[sortedShortInts.length - 1] + "]");
   
    Sort<String> stringSorter = new Sort<String>();
    long startStringSelectionSort = System.nanoTime();
    String[] sortedStrings = stringSorter.selectionSort(stringArray);
    double stringSelectionSortTime = (System.nanoTime() - startStringSelectionSort) / 1000000.0;
    System.out.println("Time to sort stringArray with selection sort: " + stringSelectionSortTime + "ms");
    System.out.println("expected: [apple, banana, grape, orange, peach, strawberry]");
    System.out.print("actual: [");
    for(i = 0; i < sortedStrings.length - 1; i++) {
      System.out.print(sortedStrings[i] + ", ");
    }
    System.out.println(sortedStrings[sortedStrings.length - 1] + "]");
    
    long startLongIntSelectionSort = System.nanoTime();
    intSorter.selectionSort(longIntArray);
    double longIntSelectionSortTime = (System.nanoTime() - startLongIntSelectionSort) / 1000000.0;
    System.out.println("Time to sort longIntArray with selectionSort: " + longIntSelectionSortTime + "ms");
  }
}
