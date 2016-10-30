package practiceProblems;

public class PalInfo {
  protected int palStart;
  protected int palEnd;
  protected boolean isPalindrome;
  protected int length;
  
  public PalInfo(int palStart, int palEnd, boolean isPalindrome) {
	this.palStart = palStart;
	this.palEnd = palEnd;
	this.isPalindrome = isPalindrome;
  }
  
  public PalInfo(int len, boolean isPalindrome, int palStart, int palEnd) {
    this.palStart = palStart;
    this.palEnd = palEnd;
    this.isPalindrome = isPalindrome;
    this.length = len;
  }
  
  public int getLength() {
	  return palEnd - palStart + 1;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder("{ ");
    sb.append("palindrome start index: ");
    sb.append(palStart);
    sb.append("palindrome end index: ");
    sb.append(palEnd);
    sb.append(", isPalindrome: ");
    sb.append(isPalindrome);
    sb.append(", length: ");
    sb.append(length);
    sb.append(" }");
    return sb.toString();
  }
}
