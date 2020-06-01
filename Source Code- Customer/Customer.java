package org.jewellery3;

//import javax.annotation.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//@ManagedBean(value="customer")
//@SessionScoped
//@Entity
public class Customer {
	private String Fname;
	private String Lname;
	private int phone;
	private String gender;  
	private String address;
	private int id;
	
 	public Customer() {}
 	public Customer(String Fname,String Lname,int phone,String gender,String address) {
 		this.Fname=Fname;
 		this.Lname=Lname;
 		this.phone=phone;
 		this.gender=gender;
 		this.address=address;
 	}
	public Customer(int id,String Fname,String Lname,int phone,String gender,String address) {
 		this.id=id;
		this.Fname=Fname;
 		this.Lname=Lname;
 		this.phone=phone;
 		this.gender=gender;
 		this.address=address;
 	}
// 	 @Id
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}      


	
}
