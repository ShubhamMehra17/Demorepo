
public class Subject {
	private String sbname;
	private int sbmarks;
	
	
	public String getSbname() {
		return sbname;
	}
	public void setSbname(String sbname) {
		this.sbname = sbname;
	}
	public int getSbmarks() {
		return sbmarks;
	}
	public void setSbmarks(int sbmarks) {
		this.sbmarks = sbmarks;
	}
	@Override
	public String toString() {
		return "Subject [sbname=" + sbname + ", sbmarks=" + sbmarks + "]";
	}
	public Subject() {
		super();
	}
	public Subject(String sbname, int sbmarks) {
		super();
		this.sbname = sbname;
		this.sbmarks = sbmarks;
	}
	
}
