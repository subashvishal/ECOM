package com.sdk.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdk.Domain.UserDetail;

@Repository("userDetailDAO")
@Transactional 
public class UserDetailDAOImpl implements UserDetailDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	//
	public boolean registerUser(UserDetail userdetail) {
		
		try
		{
			sessionFactory.getCurrentSession().save(userdetail);
			return true;
		}catch(Exception e)
		{
			System.out.println("Exception Arrised:"+e);
			return false;
		}
	}

	//
	public boolean updateUser(UserDetail userdetail) {
		
		try
		{
			sessionFactory.getCurrentSession().update(userdetail);
			return true;
		}catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	//
	public UserDetail getUser(String loginname) {
		
		Session session = sessionFactory.openSession();
		UserDetail userdetail = (UserDetail) session.get(UserDetail.class,loginname);
		session.close();
		return userdetail;
	}

	//
	public UserDetail checkUser(UserDetail userdetail) {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail where loginname=:myloginname and password=:password");
		query.setParameter("myloginname", userdetail.getLoginname());
		query.setParameter("password",userdetail.getPassword());
		List<UserDetail> listUserDetail=query.list();
		UserDetail userDetail1=listUserDetail.get(0);
		session.close();
		return userDetail1;
	}

}
