package com.test.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.CartItem;

@Repository("cartDAO")
@Transactional
public class CartDaoImpl implements CartDao{

	@Autowired
	SessionFactory sessionFactory;
	public boolean addToCart(CartItem cartItem) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(cartItem);	
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
		
	}

	public boolean deleteFromCart(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public boolean updateCart(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public CartItem getCartItem(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
		return cartItem;
	}

	public List<CartItem> listCartItems(String username) {
		Session session=sessionFactory.openSession();
		List<CartItem> listCartItems=(List<CartItem>)session.createQuery("from CartItem where username=:username and status='NP'").setParameter("username", username).list();
		return listCartItems;
	}

}
