package com.test.testcase;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.Dao.ProductDao;
import com.test.model.Product;

public class ProductDaoTest {

	static ProductDao productdao;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.test");
		context.refresh();
		
		productdao=(ProductDao)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Apache RR310");
		product.setProductDesc("Awesome vehicle");
		product.setPrice(250000);
		product.setCategoryId(1);
		product.setStock(24);
		product.setSupplierId(1);
		
		assertTrue("Problem in Adding Category",productdao.addProduct(product));
		System.out.println("----Successfully register----");
	}
}
