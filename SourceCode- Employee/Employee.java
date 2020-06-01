package ewel;

//import javax.persistence.Entity;
//import javax.persistence.Id;


public class Employee {
	
	private int id;
	private String Fname;
	private String Lname;
	private String  gender;
	private String address;
	private int pNum;
	private String position;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		this.Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		this.Lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
