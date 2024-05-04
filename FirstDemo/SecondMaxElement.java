package FirstTry.FirstDemo;

import java.util.Scanner;

public class SecondMaxElement {

	public void findSecondMax() {
		Scanner in = new Scanner(System.in);
    	System.out.print("Enter size of array : ");
    	int arrSize = in.nextInt();
    	int []arr = new int[arrSize];
    	
    	System.out.println("Enter " + arrSize + " elements:");

        for (int i = 0; i < arrSize; i++) {
            arr[i] = in.nextInt();
        }

    	 int firsthighElement=arr[0];
    	 int secondhighestelement = Integer.MIN_VALUE;
    	
    	 for(int num:arr) {
    		 if(firsthighElement<num) {
    			 secondhighestelement=firsthighElement;
    			 firsthighElement=num;
    		 }else if (num>secondhighestelement && num!=firsthighElement) {
    			 secondhighestelement=num;
    		 }
    	 }
    
    	 System.out.println("The Second highest element in given array : "+secondhighestelement);
	}
}
