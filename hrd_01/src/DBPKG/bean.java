package DBPKG;

import java.io.Serializable;

public class bean implements Serializable{
	String custno;
	String custname;
	String phone;
	String address;
	String joindate;
	String grade;
	String city;
	
	public bean() {
		
	}
	public String getCustno() {
		return custno;
	}
	public void setCustno(String string) {
		this.custno = string;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
