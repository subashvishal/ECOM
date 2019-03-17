package com.test.Dao;



import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.OrderDetails;

@Repository
@Transactional

public class OrderDaoImpl implements OrderDao
{

	@Autowired
	SessionFactory sessionFactory;

	public boolean receiptGenerate(OrderDetails orderDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean updateCartItemStatus(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("update CartItem set status='P' where username=:username");
		query.setParameter("username", username);
		int row_eff=query.executeUpdate();
		return row_eff>0;
	}
	
}
