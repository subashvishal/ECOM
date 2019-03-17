package com.test.testcase;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.Dao.UserDao;
import com.test.model.UserDetail;

public class userDaoTest {
	static UserDao userdao;

@BeforeClass
public static void preExecution()
{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.test");
	context.refresh();
	
	userdao=(UserDao)context.getBean("userDAO");
}
@Test
public void addProductTest()
{
	UserDetail user = new UserDetail();
	user.setUsername("subash");
	user.setEmailId("subashvishal64@gmail.com");
	user.setMobileNo("9042931728");
	user.setAddress("Chennai");
	user.setPassword("lonesurvivor");
	user.setUsingVehicle("RR310");
	
	assertTrue("Problem in Adding Category",userdao.registerUser(user));  //
	System.out.println("----Successfully register----");
	
			
	
	
}
}
