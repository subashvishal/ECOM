package com.test.testcase;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.Dao.CategoryDao;
import com.test.model.Category;

public class CategoryDaoTest {

	static CategoryDao categoryDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sdk");
		context.refresh();
		
		categoryDAO=(CategoryDao)context.getBean("categoryDAO");
	}
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Bike Brands");
		category.setCategoryDesc("Performance and mileage");
		
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
		System.out.println("----Successfully register----");
	}
}
