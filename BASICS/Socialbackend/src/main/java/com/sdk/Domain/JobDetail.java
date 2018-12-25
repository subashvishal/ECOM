package com.sdk.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class JobDetail {
	
	
	@Id
	private int Id;
	private String CompanyName;
	private String desigination;
	private int CTC;
	private String skills;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getDesigination() {
		return desigination;
	}
	public void setDesigination(String desigination) {
		this.desigination = desigination;
	}
	public int getCTC() {
		return CTC;
	}
	public void setCTC(int cTC) {
		CTC = cTC;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public String getRolesresp() {
		return rolesresp;
	}
	public void setRolesresp(String rolesresp) {
		this.rolesresp = rolesresp;
	}
	private Date lastDate;
	private String rolesresp;
	
	
	

}
