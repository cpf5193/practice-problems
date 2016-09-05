package practiceProblems;

import java.util.HashSet;

public class Duple {
  protected int index;
  private HashSet<Character> charSet;
  public Duple (String s, int index) {
      charSet = new HashSet<Character>();
      for(int i=0; i<s.length(); i++) {
          charSet.add(s.charAt(i));
      }
      this.index = index;
  }
  public boolean addChar(char c) {
      return charSet.add(c);
  }
  public void setIndex(int index) {
      this.index = index;
  }
  public int size() {
      return charSet.size();
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{ index: ");
    sb.append(index);
    sb.append(", {");
    for(char c : charSet) {
      sb.append(c);
      sb.append(", ");
    }
    if (charSet.size() > 0) {
      sb.delete(sb.length() - 2, sb.length()); 
    }
    sb.append("}}");
    return sb.toString();
  }
  
  public Duple clone() {
    StringBuilder sb = new StringBuilder();
    for (char c : charSet) {
      sb.append(c);
    }
    return new Duple(sb.toString(), index);
  }
}
