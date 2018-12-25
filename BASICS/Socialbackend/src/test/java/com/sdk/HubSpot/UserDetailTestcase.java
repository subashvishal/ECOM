package com.sdk.HubSpot;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sdk.Dao.UserDetailDAO;
import com.sdk.Domain.UserDetail;

public class UserDetailTestcase {
	
	@Autowired
	static UserDetailDAO userDetailDAO;
	@Autowired
	static UserDetailDAO u;
	
	@BeforeClass
	public static void intialisation()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sdk.*");
		context.refresh();
		userDetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
	}
	
	
	@Test
	public void registerUserTestCase()
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setId(12);
		userDetail.setLoginname("dinesh");
		userDetail.setPassword("kumar");
		userDetail.setUsername("DineshKumar");
		userDetail.setEmailId("sdkkumar9797@gmail.com");
		userDetail.setRoles("ROLE_USER");
		userDetail.setAddress("chennai");
		userDetail.setMobile("7401271035");
		
		assertTrue("Problem in Registering the User:",userDetailDAO.registerUser(userDetail));
	}
    @Ignore
	@Test
	public void updateUserTestCase()
	{
		UserDetail userDetail=userDetailDAO.getUser("dinesh");
		userDetail.setMobile("94443568289");
		assertTrue("Problem in Updating User:",userDetailDAO.updateUser(userDetail));
	}

	@Ignore
	@Test
	public void checkLoginTestCase()
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setLoginname("dinesh");
		userDetail.setPassword("kumar");
		
		UserDetail userDetail1=userDetailDAO.checkUser(userDetail);
		
		assertNotNull("Problem in loginCheck",userDetail1);
		
		System.out.println("User Name:"+userDetail1.getUsername());
	}

}
