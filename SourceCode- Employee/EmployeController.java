package ewel;

//import java.util.ArrayList;
//import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

public class EmployeController {

	private int id;
	private String fname;
	private String lname;
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
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	
	
	
	public String addEmp() throws Exception{
		EmployeManager bkMgr = new EmployeManager();
		bkMgr.addEmployee(fname, lname, gender, address, pNum, position);
		return "add";
	}
	
	public String deleteEmp() throws Exception{
		EmployeManager bkMgr = new EmployeManager();
		bkMgr.deleteEmployee(fname);
		return "delete";
	}
	
	public String updateEmp() throws Exception{
		EmployeManager bkMgr = new EmployeManager();
		bkMgr.updateEmployee(fname, lname, gender, address, pNum, position);
		return "update";
	}
	
	public String getUser() throws Exception{
		try {
			EmployeManager bkMgr = new EmployeManager();
			Employee e=bkMgr.getUser(id);
			//setId((e.getId()));
			setFname(e.getFname());
			setLname(e.getLname());
		}
		catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		
		return "getUser";
	}
	
//	public ArrayList<Employee> getid() throws Exception{
//		EmployeManager bkMgr = new EmployeManager();
//		return bkMgr.getid();
//	}
	

}
