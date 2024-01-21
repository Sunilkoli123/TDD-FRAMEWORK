package practice;

public class Solution  {
	public static void main(String[] args) {
		
	  String str= "Madam";
      str= str.toLowerCase();
      
	String reverse= Result.checkpalindrome(str);
	  if(reverse.equals(str)) {
		  System.out.println("given string is palindrome");
	  }
	  else {
		  System.out.println("given string is not a palindrome");
	  }
	
}
}