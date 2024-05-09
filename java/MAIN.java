import java.util.Scanner;

public class MAIN {

		public static void main(String[]args) {
			//Using scanner class to take input from user 
			Scanner in = new Scanner (System.in);
			
			Student s1 = new Student();
			s1.setStname("Rohan");
			s1.setStroll(10);
			s1.setSchool(new School("Adrsh Sr School",10021));
			s1.setSubject(new Subject("Maths",98));
			//for printing student object 
			System.out.println(s1);
			//for printing student marks only 
			System.out.println(s1.getSubject().getSbmarks());
			
		 }
}
