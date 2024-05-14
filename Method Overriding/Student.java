
public class Student {
	private  String stname;
	private int stroll;
	private School school;
	private Subject subject;
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public int getStroll() {
		return stroll;
	}
	public void setStroll(int stroll) {
		this.stroll = stroll;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Student(String stname, int stroll, School school, Subject subject) {
		super();
		this.stname = stname;
		this.stroll = stroll;
		this.school = school;
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [stname=" + stname + ", stroll=" + stroll + ", school=" + school + ", subject=" + subject + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
