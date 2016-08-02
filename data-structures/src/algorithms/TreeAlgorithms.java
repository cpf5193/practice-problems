package algorithms;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dataStructures.BST;

public class TreeAlgorithms {
  public static void main(String[] args) throws FileNotFoundException {
    Integer[] shortIntArray = {4, 13, 6, 3, 9, 10, 4, 8, 6, 5, -2, 9};
    String[] stringArray = {"orange", "apple", "grape", "banana", "peach", "strawberry"};
    Integer[] longIntArray = getLongIntArray();
    
    BST<Integer> intTree = new BST<Integer>();
    BST<Integer> bigIntTree = new BST<Integer>();
    BST<String> stringTree = new BST<String>();
    
    intTree.addAll(shortIntArray);
    bigIntTree.addAll(longIntArray);
    stringTree.addAll(stringArray);
    
    ArrayList<Integer> preorderIntOutput = intTree.preOrder();
    System.out.println("short int array preorder: " + preorderIntOutput.toString());
    System.out.println("short int array preorder expected: [4, 3, -2, 4, 13, 6, 6, 5, 9, 8, 9, 10]");
    ArrayList<Integer> inorderIntOutput = intTree.inOrder();
    System.out.println("short int array inorder: " + inorderIntOutput.toString());
    System.out.println("short int array inorder expected: [-2, 3, 4, 4, 5, 6, 6, 8, 9, 9, 10, 13]");
    ArrayList<Integer> postorderIntOutput = intTree.postOrder();
    System.out.println("short int array postorder: " + postorderIntOutput.toString());
    System.out.println("short int array postorder expected: [-2, 4, 3, 5, 6, 9, 8, 10, 9, 6, 13, 4]");
    ArrayList<String> preorderStringOutput = stringTree.preOrder();
    System.out.println("string array preorder: " + preorderStringOutput.toString());
    System.out.println("string array preorder expected: [orange, apple, grape, banana, peach, strawberry]");
    ArrayList<String> inorderStringOutput = stringTree.inOrder();
    System.out.println("string array inorder: " + inorderStringOutput.toString());
    System.out.println("string array inorder expected: [apple, banana, grape, orange, peach, strawberry]");
    ArrayList<String> postorderStringOutput = stringTree.postOrder();
    System.out.println("string array postorder: " + postorderStringOutput.toString());
    System.out.println("string array postorder expected: [banana, grape, apple, strawberry, peach, orange]");
  }
  
  private static Integer[] getLongIntArray() throws FileNotFoundException {
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
