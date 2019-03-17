package com.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserDetail {
    @Id
	private String username=null;
    private String password=null;
	private String emailId=null;
	private String address=null;
	private String mobileNo=null;
	private String usingVehicle=null;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUsingVehicle() {
		return usingVehicle;
	}
	public void setUsingVehicle(String usingVehicle) {
		this.usingVehicle = usingVehicle;
	}
	
	
	
}
