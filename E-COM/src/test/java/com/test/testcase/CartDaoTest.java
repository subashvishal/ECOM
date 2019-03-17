package com.test.testcase;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.Dao.CartDao;
import com.test.model.CartItem;

public class CartDaoTest {

	static CartDao cartdao;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sdk");
		context.refresh();
		
		cartdao=(CartDao)context.getBean("cartDAO");
	}
	@Test
	public void addCartTest()
	{
		CartItem cartItem=new CartItem();
		
		cartItem.setProductId(01);
		cartItem.setProductName("Apache RR310");
		cartItem.setQuantity(2);
		cartItem.setStatus("NP");
		cartItem.setPrice(250000);
		
		assertTrue("Problem in Creating CartItem",cartdao.addToCart(cartItem));
		System.out.println("----Successfully register----");
	}
}
