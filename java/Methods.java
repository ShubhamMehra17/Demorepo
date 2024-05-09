import java.util.Arrays;
import java.util.Scanner;

public class Methods {
	public void findmax(int[]arr) {
		
		int[]arr1 = arr;
		Arrays.sort(arr1);
		System.out.println("The peak element in given array is : "+arr1[arr1.length-1]);
	}
	
	public void findPeakElement(int []arr) {
		int[] arr1=arr;
		for(int i=1;i<arr1.length-1;i++) {
			if(arr1[i]>arr1[i-1] && arr1[i]>arr1[i+1] ){
				System.out.println("Peak Element in given array is : "+arr1[i]);
			}
		}
	}
	
	public void setArray() {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter Size of array ");
		int size = in.nextInt();
		
		int [] arr = new int[size];
		System.out.print("Enter array elements ");
		for(int i=0;i<arr.length-1;i++) {
			arr[i]=in.nextInt();
		}
	}
}
