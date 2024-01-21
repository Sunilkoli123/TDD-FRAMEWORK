package practice;

public class Result {    
	  
	  public static String checkpalindrome(String strString) {
		  String rev = "";
	        for (int i = strString.length() - 1; i >= 0; i--) {
	            rev = rev + strString.charAt(i);
	        }
		return rev;
		  
	  }
}
