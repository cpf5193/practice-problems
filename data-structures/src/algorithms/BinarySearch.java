package algorithms;

public class BinarySearch {

  public static void main(String[] args) {
    int[] testArr = {-5, -3, -2, -1, -1, 0, 2, 3, 5, 6, 6, 8, 9, 11, 14};
    int res1 = binarySearch(testArr, 2);
    int res2 = binarySearch(testArr, 9);
    int res3 = binarySearch(testArr, 1);
    int res4 = iterativeBinarySearch(testArr, 2);
    int res5 = iterativeBinarySearch(testArr, 9);
    int res6 = iterativeBinarySearch(testArr, 1);
    System.out.println("Searching for 2...");
    System.out.println("expected: 6");
    System.out.println("iterative result: " + res4);
    System.out.println("recursive result: " + res1);
    System.out.println("Searching for 9...");
    System.out.println("expected: 12");
    System.out.println("iterative result: " + res5);
    System.out.println("recursive result: " + res2);
    System.out.println("Searching for 1...");
    System.out.println("expected: -1");
    System.out.println("iterative result: " + res6);
    System.out.println("recursive result: " + res3);
  }

  public static int binarySearch(int[] arr, int key) {
    return binarySearch(arr, 0, arr.length - 1, key);
  }
  
  private static int binarySearch(int[] arr, int lower, int upper, int key) {
    if (lower > upper) {
      return -1;
    }
    int mid = lower + (upper - lower) / 2;
    if (arr[mid] == key) {
      return mid;
    } else if (arr[mid] > key) {
      return binarySearch(arr, lower, mid - 1, key);
    } else {
      return binarySearch(arr, mid + 1, upper, key);
    }
  }
  
  public static int iterativeBinarySearch(int[] arr, int key) {
    int lower = 0;
    int upper = arr.length - 1;
    int mid = 0;
    int midVal = 0;
    while (lower <= upper) {
      mid = lower + (upper - lower) / 2;
      midVal = arr[mid];
      if (midVal == key) {
        return mid;
      } else if (midVal > key) {
        upper = mid - 1;
      } else {
        lower = mid + 1;
      }
    }
    return -1;
  }
}
