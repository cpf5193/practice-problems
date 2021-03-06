package practiceProblems;

import static org.junit.Assert.*;

import org.junit.Test;

public class PracticeProblemsTest {


  @Test
  public void testIsStroboGrammatic() {
    PracticeProblems pp = new PracticeProblems();
    boolean[] testResults = {false, false, true, true, false};
    String[] testStrings = {"69880", "880180", "61089868019", "6108968019", "401104"};
    for(int i=0; i<testStrings.length; i++) {
      boolean result = pp.isStrobogrammatic(testStrings[i]);
      assertEquals(testResults[i], result);
    }
  }
  
  @Test
  public void testSumDigits () {
    PracticeProblems pp = new PracticeProblems();
    int[] input1a = {9, 9, 9, 9};
    int[] input1b = {9, 9, 9, 9};
    int[] expected1 = {1, 9, 9, 9, 8};
    int[] result1 = pp.sumDigits(input1a, input1b);
    assertArrayEquals(expected1, result1);
    
    int[] input2a = {9, 9, 8, 1};
    int[] input2b = {3, 4, 5, 6, 7, 8, 9};
    int[] expected2 = {3, 4, 6, 6, 7, 7, 0};
    int[] result2 = pp.sumDigits(input2a, input2b);
    assertArrayEquals(expected2, result2);
    
    int[] input3a = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] input3b = {9, 8, 7, 6};
    int[] expected3 = {1, 2, 3, 5, 5, 5, 5, 4};
    int[] result3 = pp.sumDigits(input3a, input3b);
    assertArrayEquals(expected3, result3);
  }
  
  @Test
  public void testLengthOfLongestSubstring() {
    PracticeProblems pp = new PracticeProblems();
    String testInput1 = "abcabcbb";
    String testInput2 = "bbbbb";
    String testInput3 = "pwwkew";
    String testInput4 = "aab";
    String testInput5 = "dvdf";
    
    int[] expected = {3, 1, 3, 2, 3};
    int[] results = {
        pp.lengthOfLongestSubstring(testInput1),
        pp.lengthOfLongestSubstring(testInput2),
        pp.lengthOfLongestSubstring(testInput3),
        pp.lengthOfLongestSubstring(testInput4),
        pp.lengthOfLongestSubstring(testInput5)
    };
    assertArrayEquals(expected, results);
  }
  
  @Test
  public void testLongestPalindrome() {
    PracticeProblems pp = new PracticeProblems();
    String testInput1 = "abaca";
    String testInput2 = "ba";
    String testInput3 = "bb";
    String testInput4 = "x";
    String testInput5 = "a racecar a";
    String testInput6 = "potato salad";
    String testInput7 = "lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc";
    
    String[] expected = {
      "aba",
      "b",
      "bb",
      "x",
      "a racecar a",
      "otato",
      "lbabl"
    };
    
    String[] results = {
      pp.longestPalindrome(testInput1),
      pp.longestPalindrome(testInput2),
      pp.longestPalindrome(testInput3),
      pp.longestPalindrome(testInput4),
      pp.longestPalindrome(testInput5),
      pp.longestPalindrome(testInput6),
      pp.longestPalindrome(testInput7)
    };
    
    assertArrayEquals(results, expected);
  }
  
  @Test
  public void testRemoveDuplicates() {
    PracticeProblems pp = new PracticeProblems();
    int[][] inputs = {
        {},
        {1},
        {1, 2},
        {1, 1},
        {1, 2, 3, 4, 4},
        {1, 2, 2, 3, 4, 4, 4, 8},
        {-1, 0, 0, 0, 0, 3, 3}
    };
    
    
    int[] expectedLengths = {0, 1, 2, 1, 4, 5, 3};
    int[] resultLengths = new int[inputs.length];
    for(int i=0; i<inputs.length; i++) {
      resultLengths[i] = pp.removeDuplicates(inputs[i]);
    }
    assertArrayEquals(expectedLengths, resultLengths);
    
    int[][] expectedArrays = {
        {},
        {1},
        {1, 2},
        {1},
        {1, 2, 3, 4},
        {1, 2, 3, 4, 8},
        {-1, 0, 3}
    };
    
    int[][] resultArrays = new int[inputs.length][];
    for(int i=0; i<resultArrays.length; i++) {
      resultArrays[i] = new int[expectedArrays[i].length];
      for(int j=0; j<resultLengths[i]; j++) {
        resultArrays[i][j] = inputs[i][j];
      }
    }
    
    for(int i=0; i<resultArrays.length; i++) {
      assertArrayEquals(resultArrays[i], expectedArrays[i]);
    }
  }
  
  @Test
  public void testFindTheDifference() {
    PracticeProblems pp = new PracticeProblems();
    String testInput1s = "aebcd";
    String testInput1t = "abeccd";
    char[] expected = {'c'};
    char[] results = {
        pp.findTheDifference(testInput1s, testInput1t)
    };
    assertArrayEquals(expected, results);
  }
  
  @Test
  public void testLongestPalindrome() {
	PracticeProblems pp = new PracticeProblems();
	String[] testInputs = {"a", "bb", "bc", "bab", "dabbacad", "cbabbad"};
	String[] expected = {"a", "bb", "b", "bab", "abba", "abba"};
	String[] results = new String[testInputs.length];
	for ( int i = 0; i < results.length; i++) {
		results[i] = pp.longestPalindrome(testInputs[i]);
	}
	assertArrayEquals(expected, results);
  }

}
