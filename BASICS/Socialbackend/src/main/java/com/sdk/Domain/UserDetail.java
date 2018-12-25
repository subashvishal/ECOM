package com.sdk.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetail {
	
	private int Id;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	@Id
	private String loginname;
	private String password;
	private String Username;
	private String emailId;
	private String Mobile;
	private String Roles;
	private String Address;
	
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getRoles() {
		return Roles;
	}
	public void setRoles(String roles) {
		Roles = roles;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
