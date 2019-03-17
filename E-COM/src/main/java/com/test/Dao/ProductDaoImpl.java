package com.test.Dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}

	@Transactional
	
	public boolean deleteProduct(Product product) {
		try
		{
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	}
	
	public boolean updateProduct(Product product) {
		try
		{
		sessionFactory.getCurrentSession().update(product);
		return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	public Product getProduct(int productId) 
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		session.close();
		return product;
	}

	
	public List<Product> listProduct()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProducts=query.list();
		session.close();
		return listProducts;
		
	}

}
