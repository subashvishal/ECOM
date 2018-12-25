package com.sdk.HubSpot;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sdk.Dao.BlogDAO;
import com.sdk.Domain.Blog;

public class BlogTestcase {
	
	@Autowired
	static BlogDAO blogDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sdk");
		context.refresh();
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}

	@Test
		public void addBlogdetails()
	{
		Blog l=new Blog();
		l.setBlogcontent("Numerical");
	
		l.setBlogName("Advanced technology");
		l.setCreatedDate(new Date());
		l.setDislikes(1);
		l.setLikes(2);
		l.setLoginName("yogishoban");
		l.setStatus("P");
		assertTrue("Problem in Creating Blog",blogDAO.addBlogdetails(l));
		System.out.println("BlogDetails Successfully added");
	}

	@Ignore
	@Test
	public void updateBlogdetails()
	{
		 Blog blog=blogDAO.getBlogdetails(2002);
			blog.setBlogName("sivateja");
			blog.setLikes(2);
			assertTrue("Problem in Blog Updation",blogDAO.updateBlogdetails(blog));
	System.out.println("BlogDetails Updated Successfully added");
	}
	@Ignore
	@Test
	public void deleteBlogdetails()
	{
		Blog blog=blogDAO.getBlogdetails(1);
		assertTrue("problem in deleting blog",blogDAO.deleteBlogdetails(blog));
		System.out.println("blog details deleted");
	}


}
