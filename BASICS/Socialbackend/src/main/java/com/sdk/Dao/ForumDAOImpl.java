package com.sdk.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdk.Domain.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	//
	public List<Forum> getforumdetails() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}

	//
	public boolean addforumdetails(Forum f) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(f);
		return true;
	}

	//
	public boolean updateforumdetails(Forum f) {
		sessionFactory.getCurrentSession().update(f);
		return true;
	}

	//
	public boolean deleteforumdetails(Forum f) {
		sessionFactory.getCurrentSession().delete(f);
		return true;
	}

	//
	public Forum findforumId(int commentId) {
		try
		{
			Session session=sessionFactory.openSession();
			Forum forum1=(Forum)session.get(Forum.class, commentId);
			session.close();
			return forum1;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return null;
		}
	}

}
