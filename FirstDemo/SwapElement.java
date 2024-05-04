package FirstTry.FirstDemo;

public class SwapElement {
	 
    public void swapelement(int x , int y) {
    	 int a = x;
         int b = y;
         
         System.out.println("Before swapping:");
         System.out.println("a = " + a);
         System.out.println("b = " + b);
         
         a = a + b;
         b = a - b;
         a = a - b;
         
         System.out.println("After swapping:");
         System.out.println("a = " + a);
         System.out.println("b = " + b);
    }
    
}
