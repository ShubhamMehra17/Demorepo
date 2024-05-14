
public class Student implements Comparable<Student>{
String name;
int rollNo;
int marks;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public Student(String name, int rollNo, int marks) {
	super();
	this.name = name;
	this.rollNo = rollNo;
	this.marks = marks;
}
public Student() {
	super();
}

@Override
public int compareTo(Student student) {
	
	if(marks>student.marks) {
		return 1;
	}else if(marks<student.marks) {
		return -1;
	}
		return 0;
	
}

}
