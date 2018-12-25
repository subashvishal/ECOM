package com.sdk.HubSpot;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sdk.Dao.ForumCommentDAO;
import com.sdk.Domain.ForumComment;

public class ForumCommentTestcase {

	@Autowired
	static ForumCommentDAO forumCommentDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sdk.*");
		context.refresh();
		forumCommentDAO=(ForumCommentDAO)context.getBean("forumCommentDAO");
	}
	
	@Test
	public void addforumCommentdetails()
	{
		ForumComment fc=new ForumComment();
		fc.setCommentId(11);
		fc.setDiscussiondate(new Date());
		fc.setDiscussiontext("Very nice");
		fc.setForumId(12);
		fc.setLoginname("BaluYogi");
		assertTrue("Problem in Creating forumComment",forumCommentDAO.addforumcommentdetails(fc));
		System.out.println("forumCommentsDetails Successfully added");
	}
	@Ignore
	@Test
	public void deleteforumCommentdetails()
	{
		ForumComment fc=forumCommentDAO.findcommentId(50);
		assertTrue("Problem in Creating forumComment",forumCommentDAO.deleteforumcommentdetails(fc));
		System.out.println("forumCommentsDetails Deleted Successfully ");
	}
	
	@Test
	public void updateforumCommentdetails()
	{
		ForumComment fc=forumCommentDAO.findcommentId(50);
		fc.setForumId(15);
		fc.setDiscussiontext("good");
		assertTrue("Problem in Creating forumComment",forumCommentDAO.updateforumcommentdetails(fc));
		System.out.println("forumCommentsDetails Updated Successfully added");
		

}
}
