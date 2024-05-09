
public class School {
	private String sname;
	private int sid;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "School [sname=" + sname + ", sid=" + sid + "]";
	}
	public School(String sname, int sid) {
		super();
		this.sname = sname;
		this.sid = sid;
	}
	public School() {
		super();

	}
	
}
