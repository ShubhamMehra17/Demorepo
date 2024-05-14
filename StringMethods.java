import java.util.Arrays;

public class StringMethods {
	
	public void stringMethods() {
	            // Intializing string variable
				String string = "  Hello ";
				// Concatinating the word 'world' to string varibale and storing in s2 variable
				String s2 = string.concat("World  ");
				System.out.println(string);
				System.out.println(s2);
				 
				//removing the extra spaces from front and end of the string using .trim method and storing the string to s3 variable
				String s3 = s2.trim();
				System.out.println(s3);
				
				//changing string to array using .split method 
				String []s4 = s3.split(" ");
				System.out.println(Arrays.toString(s4));
				
				String s5 = "hello world";
				 // checking if 2 strings value is equal or not ignoring the case(upperCase or lowerCase) using .equalIgnoreCase
				boolean stringEqualsOrNot=s5.equalsIgnoreCase(s3);
				System.out.println(stringEqualsOrNot);
				
				String s6 = s3.replace("e", "a");
				System.out.println(s6);
				
				String s7 = s3.substring(6);
				System.out.println(s7);
				
				String s8 = s3.substring(6,8);
				System.out.println(s8);
				
				char [] carr = s3.toCharArray();
				System.out.println(carr);
				
				char c = s3.charAt(4);
				System.out.println(c);
	}
}
