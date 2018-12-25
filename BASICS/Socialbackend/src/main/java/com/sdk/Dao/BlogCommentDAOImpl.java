package com.sdk.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdk.Domain.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List<BlogComment> getblogcommentsdetails() {
		
		return sessionFactory.getCurrentSession().createQuery("from BlogComment").list();
	}

	
	public boolean addblogcomments(BlogComment bc) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(bc);
			return true;
		}catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public boolean updateblogcomments(BlogComment bc) {
		try
		{
		sessionFactory.getCurrentSession().update(bc);
		return true;
	}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public boolean deleteblogcomments(BlogComment bc) {
		
		try
		{
		sessionFactory.getCurrentSession().delete(bc);
		return true;
	}
catch(Exception e)
		{
	System.out.println("Exception Arised:"+e);
	return false;
		}
	}

	
	public BlogComment getBlogComments(int blogId) {
		try
		{
		Session session=sessionFactory.openSession();
		BlogComment blogcomments=(BlogComment)session.get(BlogComment.class,blogId);
		session.close();
		return blogcomments;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return null;
		
		}
	}

}
