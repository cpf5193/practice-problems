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
}
