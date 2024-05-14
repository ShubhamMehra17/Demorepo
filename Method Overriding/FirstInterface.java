@FunctionalInterface
public interface FirstInterface {

	 void add(int a,int b);
	
	default void multiplication(int a, int b) {
			long result = a*b;
		 System.out.println("The multiplication of "+a+" and "+b+" is : "+result);
		 
		

	}
}
