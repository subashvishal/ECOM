package com.sdk.HubSpot;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sdk.Dao.ProfilePictureDAO;
import com.sdk.Domain.ProfilePicture;

public class ProfilePictureTestcase {
	
	@Autowired
	static ProfilePictureDAO profilePictureDAO;

	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sdk.*");
		context.refresh();
		profilePictureDAO=(ProfilePictureDAO)context.getBean("profilePictureDAO");
	}

	@Test
	public void addprofiledetails()
	{
		ProfilePicture pf=new ProfilePicture();
		pf.setLoginName("Shoban");
		assertTrue("Problem in Creating ProfilePicture",profilePictureDAO.save(pf));
		System.out.println("ProfileDetails Successfully added");
	}
	
	@Ignore
	@Test
	public void updateUserDetails()
	{

		ProfilePicture pf=profilePictureDAO.getProfilePicture("Shoban");
		pf.setLoginName("Balushoban");
		assertTrue("Problem in Creating ProfilePicture",profilePictureDAO.save(pf));
		System.out.println("ProfileDetails Updated Successfully added");
		
	}

}
