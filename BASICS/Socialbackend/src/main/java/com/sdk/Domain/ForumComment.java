package com.sdk.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ForumComment {

	@Id
	@SequenceGenerator(name = "forumcommentseq",sequenceName="forumcommentseq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forumcommentseq")
	private int commentId;
	private int forumId;
	private String discussiontext;
	private String loginname;
	private Date discussiondate;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getDiscussiontext() {
		return discussiontext;
	}
	public void setDiscussiontext(String discussiontext) {
		this.discussiontext = discussiontext;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public Date getDiscussiondate() {
		return discussiondate;
	}
	public void setDiscussiondate(Date discussiondate) {
		this.discussiondate = discussiondate;
	}
	
}
