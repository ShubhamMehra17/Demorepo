import java.util.Scanner;

public class MAIN {

		public static void main(String[]args) {
			//Using scanner class to take input from user 
			Scanner in = new Scanner (System.in);
			System.out.print("Enter First no. : ");
			//taking first number from user 
			int a = in.nextInt();
			System.out.print("Enter Second no. : ");
			//taking second number from user
			int b = in.nextInt();
			
			//defining the abstract method body using lambda expression
			FirstInterface f = (x,y) -> {
				int sum = x+y;
				System.out.println("The sum of "+x+" and "+y+" is : "+sum);};
				//using abstract method to add two numbers
			f.add(a, b);
			
			//using default multiplication from FirstInterface
			f.multiplication(a, b);
			
			System.out.println("For finding largest number from 3 numbers...");
			System.out.print("Enter First no. : ");
			//taking first number from user 
			int i = in.nextInt();
			System.out.print("Enter Second  no. : ");
			//taking second number from user
			int j = in.nextInt();
			System.out.print("Enter Third no. : ");
			//taking third number from user
			int k = in.nextInt();
			
			findmax(i,j,k);
			
			
		}
		
		 static void findmax(int x, int y, int z) {
			 int a = x;
		        int b = y;
		        int c = z;

		        // Nested ternary operation to find the maximum among three numbers
		        int max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);

		        System.out.println("The maximum among " + a + ", " + b + ", and " + c + " is: " + max);
		 }
}
