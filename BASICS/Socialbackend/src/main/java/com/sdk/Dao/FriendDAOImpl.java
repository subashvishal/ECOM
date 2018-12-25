package com.sdk.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdk.Domain.Friend;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	//
	public List<Friend> frienddetails() {
		
		return sessionFactory.getCurrentSession().createQuery("from Friend").list();
	}

	//
	public boolean addfriendetails(Friend d) {
		
		sessionFactory.getCurrentSession().save(d);
		return true;
	}

	//
	public boolean updatefriendetails(Friend d) {
		// TODO Auto-generated method stub
		return false;
	}

	//
	public boolean deletefriendetails(Friend d) {

		sessionFactory.getCurrentSession().delete(d);
		return true;
	}

	//
	public Friend findfriendId(int friendId) {
		
		try
		{
		Session session=sessionFactory.openSession();
		Friend friend=(Friend)session.get(Friend.class, friendId);
		session.close();
		return friend;
	}
	
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return null;
		}
	}

	//
	public boolean Acceptedfriendrequest(int friendId) {
		
		Friend f1=this.findfriendId(friendId);
		f1.setStatus("RequestAccepted");
		this.sessionFactory.getCurrentSession().update(f1);
		return true;
	}

	//
	public boolean NotAcceptedfriendrequest(int friendId) {
		
		Friend f1=this.findfriendId(friendId);
		f1.setStatus("RequestNotAccepted");
		this.sessionFactory.getCurrentSession().update(f1);
		return true;
	}

}
