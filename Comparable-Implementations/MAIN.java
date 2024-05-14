
import java.util.Scanner;

public class MAIN {

		public static void main(String[]args) {
			//Using scanner class to take input from user 
			Scanner in = new Scanner (System.in);
		
			Student s1 = new Student("Abcd",10,50);
			Student s2 = new Student ("xyz",11,60);
			
			if(s2.compareTo(s1)==1) {
				System.out.println("High");
			}else if(s2.compareTo(s1)==-1) {
				System.out.println("Less");
			}else if(s2.compareTo(s1)==0) {
				System.out.println("Equal");
			}
			
			
			
			
			}
}
