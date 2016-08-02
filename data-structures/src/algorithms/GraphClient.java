package algorithms;

import dataStructures.Graph;

public class GraphClient {

  public static void main(String[] args) {
    Integer[] intNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] stringNodes = {"orange", "apple", "grape", "banana", "peach", "strawberry"};
    
    Integer[][] intEdges = {{9, 1}, {7, 3}, {7, 6}, {5, 7}, {5, 4}, {5, 1}, {4, 1}, {3, 5}, {2, 3}, {2, 6}, {1, 8}};
    int[] weights = {6, 1, 4, 6, 9, 3, 4, 2, 5, 6, 2};
    String[][] stringEdges = {{"orange", "apple"}, {"apple", "banana"}, {"strawberry", "apple"}, {"strawberry", "banana"},
      {"strawberry", "grape"}, {"peach", "orange"}, {"grape", "apple"}, {"peach", "banana"}};
    
    Graph<Integer> intGraph = new Graph<Integer>(intNodes);
    Graph<String> stringGraph = new Graph<String>(stringNodes);
    
    for(int i=0; i<intEdges.length; i++) {
      intGraph.addEdge(intEdges[i][0], intEdges[i][1], weights[i]);
    }
    System.out.println("intGraph: ");
    System.out.println(intGraph.toString());
    for(int i=0; i<stringEdges.length; i++) {
      stringGraph.addEdge(stringEdges[i][0], stringEdges[i][1], weights[i]);
    }
    System.out.println("stringGraph: ");
    System.out.println(stringGraph.toString());
    
    // dfs, bfs, dijkstra's
  }

}
