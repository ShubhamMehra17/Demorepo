
public class BillGenerator {
	public void billGenerator(int unitCosumed) {
		int consumedUnits=unitCosumed;
		
		int billAmount = (consumedUnits <=100)? consumedUnits*2:
			       	  ( consumedUnits<=150 && consumedUnits>100)? 200+(consumedUnits-100)*3 :
			       		  (consumedUnits<=200 && consumedUnits>150)? 350 +(consumedUnits-150)*4:
			       			  (consumedUnits<=250 && consumedUnits>200)? 550 + (consumedUnits-200)*5:
			       				  (consumedUnits<=300 && consumedUnits>250)? 800 + (consumedUnits-250)*6:
			       					  (consumedUnits<=500 && consumedUnits>300)? 1100 + (consumedUnits-300)*7:
			       						   2500 +(consumedUnits-500)*8;
		
		System.out.println("Your total electricity bill for "+consumedUnits+" units is : "+billAmount);
	}
}
