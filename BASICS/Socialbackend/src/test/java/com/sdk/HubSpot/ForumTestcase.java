package com.sdk.HubSpot;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sdk.Dao.ForumDAO;
import com.sdk.Domain.Forum;

public class ForumTestcase {

	@Autowired
	static ForumDAO forumDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sdk.*");
		context.refresh();
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
			
@Test
public void addforumdetails()
{
	Forum f=new Forum();
	f.setCommentId(55);
	f.setDiscussiondate(new Date());
	f.setDiscussiontext("verygood");
	f.setForumId(132);
	f.setLoginname("yogishoban");
	assertTrue("Problem in Creating forum",forumDAO.addforumdetails(f));
	System.out.println("forumDetails Successfully added");
}

@Ignore
@Test
public void updateforumdetails()
{
	Forum f=forumDAO.findforumId(50);
	f.setForumId(145);
	f.setLoginname("shoban");
	assertTrue("Problem in Creating forum",forumDAO.updateforumdetails(f));
	System.out.println("forumDetails Updated Successfully added");
	

}
@Ignore
@Test
public void deleteforumdetails()
{
	Forum f=forumDAO.findforumId(132);
	assertTrue("Problem in Creating forum",forumDAO.deleteforumdetails(f));
	System.out.println("forumDetails Deleted Successfully ");
	
	
}
}
