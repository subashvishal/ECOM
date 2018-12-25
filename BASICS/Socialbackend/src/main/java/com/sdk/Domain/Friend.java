package com.sdk.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Friend {
	
	@Id
	@SequenceGenerator(name = "friendseq",sequenceName="friendseq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="friendseq")
	private int friendId;
	private String loginname;
	private String friendloginname;
	private String Status;
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getFriendloginname() {
		return friendloginname;
	}
	public void setFriendloginname(String friendloginname) {
		this.friendloginname = friendloginname;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

}
