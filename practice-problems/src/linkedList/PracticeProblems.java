package linkedList;

import java.util.HashMap;

public class PracticeProblems {

	public boolean isStrobogrammatic(String s) {
	  HashMap<Character, Character> map = new HashMap<Character, Character>();
	  map.put('6', '9');
	  map.put('9', '6');
	  map.put('8', '8');
	  map.put('0', '0');
	  map.put('1', '1');
	  int stopIndex = s.length() / 2;
	  for(int i = 0; i < stopIndex; i++) {
	    char currentChar = s.charAt(i);
	    if (!map.containsKey(currentChar) || map.get(currentChar) != s.charAt(s.length() - 1 - i)) {
	      return false;
	    }
	  }
	  if (s.length() % 2 == 1) {
	    char lastChar = s.charAt(stopIndex + 1);
	    return map.containsKey(lastChar) && map.get(lastChar) == lastChar;
	  }
	  return true;
	}
}
