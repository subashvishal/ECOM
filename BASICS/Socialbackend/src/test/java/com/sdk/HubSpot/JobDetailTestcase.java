package com.sdk.HubSpot;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sdk.Dao.JobDetailDAO;
import com.sdk.Domain.JobDetail;

public class JobDetailTestcase {

	@Autowired
	static JobDetailDAO jobDetailDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sdk.*");
		context.refresh();
		jobDetailDAO=(JobDetailDAO)context.getBean("jobDetailDAO");
	}
	
	@Test
	public void addjobdetails()
	{
		JobDetail j=new JobDetail();
		j.setCompanyName("Infosys");
		j.setCTC(25000);
		j.setDesigination("software Engineer");
		j.setId(14);
		j.setLastDate(new Date());
	
		j.setRolesresp("TeamLeader");
		j.setSkills("java");
	
 assertTrue("Problem in Creating jobdetails",jobDetailDAO.addjobdetails(j));
		System.out.println("JobDetails Successfully added");
		
	}
	
	@Test
	public void updatejobdetails()
	{
		JobDetail j=jobDetailDAO.findjobId(14);
		j.setCompanyName("wipro");
		assertTrue("Problem in Creating jobdetails",jobDetailDAO.updatejobdetails(j));
		System.out.println("JobDetails Updated Successfully added");
	}
	
@Ignore
	@Test
	public void deletejobdetails()
	{
		JobDetail j=jobDetailDAO.findjobId(14);
		 assertTrue("Problem in Creating Jobdetails",jobDetailDAO.deletejobdetails(j));
		System.out.println("JobDetails Deleted Successfully ");
	}
}
