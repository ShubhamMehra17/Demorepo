import java.util.Arrays;
import java.util.Scanner;

public class Methods {
	public void palindrome(String str) {
		String string = str;
		String s ="" ;
		
		for(int i=string.length()-1;i>=0;i--) {
			s+=(string.charAt(i));
		}
		
		if(s.equalsIgnoreCase(string)) {
			System.out.println("String is palindrome.");
		}else {
			System.out.println("String is not palindrome.");
		}
	}
	
	public void factorial(int num) {
		int number = num;
		int result=1;
		for (int i=1;i<=number;i++) {
			result = result*i;
		}
		System.out.println("Factorial of "+number+" is : "+result);
	}
}
