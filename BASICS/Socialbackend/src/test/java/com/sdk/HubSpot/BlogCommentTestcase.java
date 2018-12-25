package com.sdk.HubSpot;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sdk.Dao.BlogCommentDAO;
import com.sdk.Domain.BlogComment;

public class BlogCommentTestcase {
	
	@Autowired
	static BlogCommentDAO blogCommentDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sdk.*");
		context.refresh();
		blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
	}
	
		@Test
		public void addBlogComment()
		{
			BlogComment b=new BlogComment();
			b.setCommentDate(new Date());
			b.setCommentId(121);
			b.setCommentText("yahoo");
			b.setLoginName("yogesh");
			
			assertTrue("Problem in adding blogcomment",blogCommentDAO.addblogcomments(b));
			
			System.out.println("BlogCommentsDetails Successfully added");
		}
		
		@Ignore
		@Test
		public void updateBlogComment()
		{
			BlogComment b=blogCommentDAO.getBlogComments(50);
			b.setCommentText("microsoft");
			assertTrue("Problem in Creating BlogComment",blogCommentDAO.updateblogcomments(b));
			System.out.println("BlogCommentsDetails updated successfully");
		
		
	}
		@Ignore
		@Test
		public void deleteBlogComment()
		{
			BlogComment b=blogCommentDAO.getBlogComments(50);
			assertTrue("Problem in Creating BlogComment",blogCommentDAO.deleteblogcomments(b));
			System.out.println("BlogCommentsDetails deleted successfully");
		
	}

}
