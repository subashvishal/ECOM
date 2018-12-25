package com.sdk.HubSpot;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sdk.Dao.FriendDAO;
import com.sdk.Domain.Friend;

public class FriendTestcase {

	@Autowired
	static FriendDAO friendDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sdk.*");
		context.refresh();
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}

	@Test
	public void addfrienddetails()
	{
	Friend s=new Friend();
	s.setFriendId(21);
	s.setFriendloginname("Yogeshwar");
	s.setLoginname("Mani");
	s.setStatus("P");
	assertTrue("Problem in Creating Friend",friendDAO.addfriendetails(s));
	System.out.println("friendDetails Successfully added");
	}
	
	
}
