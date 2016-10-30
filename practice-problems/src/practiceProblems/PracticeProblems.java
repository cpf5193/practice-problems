package practiceProblems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PracticeProblems {

	public boolean isStrobogrammatic(String s) {
	  HashMap<Character, Character> map = new HashMap<Character, Character>();
	  map.put('6', '9');
	  map.put('9', '6');
	  map.put('8', '8');
	  map.put('0', '0');
	  map.put('1', '1');
	  int stopIndex = s.length() / 2;
	  for(int i = 0; i <= stopIndex; i++) {
	    char currentChar = s.charAt(i);
	    if (!map.containsKey(currentChar) || map.get(currentChar) != s.charAt(s.length() - 1 - i)) {
	      return false;
	    }
	  }
	  return true;
	}
	
	public int[] sumDigits(int[] a, int[] b) {
	  int carry = 0;
	  int[] shorter = (a.length <= b.length) ? a : b;
	  int[] longer = (a.length <= b.length) ? b : a;
	  ArrayList<Integer> list = new ArrayList<Integer>();
	  for(int i=shorter.length - 1; i >= 0; i--) {
	    int sum = shorter[i] + longer[i + (longer.length - shorter.length)] + carry;
	    if (sum > 9) {
	      carry = 1;
	      sum -= 10;
	    } else {
	      carry = 0;
	    }
	    list.add(sum);
	  }
	  // all in shorter have been added, longer may have more elts or carry may exist
	  for (int i = longer.length - shorter.length - 1; i >= 0; i--) {
	    int sum = longer[i] + carry;
	    if (sum > 9) {
	      carry = 1;
	      sum -= 10;
	    } else {
	      carry = 0;
	    }
	    list.add(sum);
	  }
	  if (carry == 1) {
	    list.add(carry);
	  }
	  int[] sumArr = new int[list.size()];
	  for( int i = list.size() - 1; i >= 0; i--) {
	    sumArr[list.size() - 1 - i] = list.get(i);
	  }
	  return sumArr;
	}
	
	public int lengthOfLongestSubstring(String s) {
    Duple largest = new Duple("", 0);
    Duple current = new Duple("", 0);
    for(int i=0; i<s.length(); i++) {
        char currentChar = s.charAt(i);
        boolean isDuplicate = !current.addChar(currentChar);
        if (isDuplicate) {
          i = i - current.size();
          current = new Duple("", i);
        } else if (current.size() > largest.size()) {
          largest = current.clone();
        }
        current.setIndex(i);
    }
    // At this point, we should have the largest substring stored as a set in a Duple
    return largest.size();
  }
  
	public String longestPalindrome(String s) {
    int size = s.length();
    PalInfo[][] m = new PalInfo[size][size];
    LPSHelper(0, size-1, m, s);
    return s.substring(m[0][size-1].palStart, m[0][size-1].palEnd + 1);
  }
    
  private void LPSHelper(int i, int j, PalInfo[][] m, String s) {
    if (m[i][j] != null) {
      // Already calculated this slot, return
      return;
    }
    if (i == j) {
      // Base case, only considering one character
      m[i][j] = new PalInfo(1, true, i, i);
    } else if (j - i == 1) {
      // Base case 2, considering 2 characters
      LPSHelper(i+1, j, m, s);
      LPSHelper(i, j-1, m, s);
      boolean equal = s.charAt(i) == s.charAt(j);
      m[i][j] = (equal ? new PalInfo(2, true, i, j) : new PalInfo(1, false, m[i][j-1].palStart, m[i][j-1].palEnd));
    } else {
      LPSHelper(i+1, j-1, m, s);
      if (s.charAt(i) == s.charAt(j) && m[i+1][j-1].isPalindrome) {
        // Found equal characters around an existing palindrome
        m[i][j] = new PalInfo(m[i+1][j-1].length + 2, true, i, j);
      } else {
        // Take max length palindrome from bottom and left neighbors in the matrix
        LPSHelper(i+1, j, m, s);
        LPSHelper(i, j-1, m, s);
        int maxLen = Math.max(m[i+1][j].length, m[i][j-1].length);
        int start = m[i+1][j].length > m[i][j-1].length ? m[i+1][j].palStart : m[i][j-1].palStart;
        int end = m[i+1][j].length > m[i][j-1].length ? m[i+1][j].palEnd : m[i][j-1].palEnd;
        m[i][j] = new PalInfo(maxLen, false, start, end);
      }
    }
  }
  
  public int removeDuplicates(int[] nums) {
    if (nums.length < 2) {
        return nums.length;
    }
    int i = 1, j = 1, curr = 0;
    while (j < nums.length) {
        while(nums[j] == nums[curr]) {
            j++;
            if (j == nums.length) {
                return i;
            }
        }
        nums[i] = nums[j];
        i++;
        curr++;
        j++;
    }
    return i;
  }
  
  public char findTheDifference(String s, String t) {
    HashMap<Character, Integer> letterCounts = new HashMap<Character, Integer>();
    char c;
    for(int i=0; i<s.length(); i++) {
        c = s.charAt(i);
        letterCounts.put(c, letterCounts.containsKey(c) ? letterCounts.get(c) + 1 : 1);
    }
    
    for(int i=0; i<t.length(); i++) {
        c = t.charAt(i);
        if (!letterCounts.containsKey(c) || letterCounts.get(c) == 0) {
            return c;
        }
        letterCounts.put(c, letterCounts.get(c) - 1);
    }
    return 'a';
  }
  
  private boolean isOutOfBounds(int i, int j) {
    return i > j || i < 0 || j < 0;
  }
  
  private PalInfo fillCells(int i, int j, String s, PalInfo[][] grid) {
      if (isOutOfBounds(i, j))
          return null;
      if (i == j) {
          grid[i][j] = new PalInfo(i, j, true);
          return grid[i][j];
      }
      PalInfo bottomPalInfo = grid[i+1][j];
      PalInfo leftPalInfo = grid[i][j-1];
      PalInfo bottomLeftPalInfo = (isOutOfBounds(i + 1, j - 1) ? new PalInfo(0, -1, true) : grid[i+1][j-1]);
      bottomPalInfo = bottomPalInfo == null ? fillCells(i + 1, j, s, grid) : bottomPalInfo;
      leftPalInfo = leftPalInfo == null ? fillCells(i, j - 1, s, grid) : leftPalInfo;
      bottomLeftPalInfo = bottomLeftPalInfo == null ? fillCells(i - 1, j - 1, s, grid) : bottomLeftPalInfo;
      int bottomLeftVal = bottomLeftPalInfo.getLength();
      if (s.charAt(i) == s.charAt(j) && (bottomLeftPalInfo.isPalindrome)) {
          bottomLeftVal += 2;
      }
      int maxOfLeftAndBottom = Math.max(leftPalInfo.getLength(), bottomPalInfo.getLength());
      if (maxOfLeftAndBottom > bottomLeftVal) {
          PalInfo maxInfo = bottomPalInfo.getLength() > leftPalInfo.getLength() ? bottomPalInfo : leftPalInfo;
          grid[i][j] = new PalInfo(maxInfo.minIndex, maxInfo.maxIndex, false);
      } else {
          grid[i][j] = new PalInfo(i, j, true);
      }
      return grid[i][j];
  }
  
  public String longestPalindrome(String s) {
	PalInfo[][] palInfoGrid = new PalInfo[s.length()][s.length()];
    PalInfo largestPalInfo = fillCells(0, s.length() - 1, s, palInfoGrid);
	return s.substring(largestPalInfo.minIndex, largestPalInfo.maxIndex + 1);
  }
}
