package com.sdk.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdk.Domain.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List<Blog> findblogdetails() {
		
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}
	

	
	public Blog getBlogdetails(int id) {
		
		try
		{
			Session session = sessionFactory.openSession();
			Blog blog = (Blog) session.get(Blog.class, id);
			session.close();
			return blog;
			
		}catch(Exception e)
		{
			System.out.println("Exception:"+e);
			return null;
		}
	}

	
	public boolean addBlogdetails(Blog blog) {
		
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
			
		}catch(Exception e)
		{
			System.out.println("Exception arised:"+e);
			return false;
		}
	}

	
	public boolean updateBlogdetails(Blog blog) {
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}

	
	public boolean deleteBlogdetails(Blog blog) {
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}

	
	public boolean approvedBlogdetails(int id) {
		
		Blog b=this.getBlogdetails(id);
		b.setStatus("Approved");
		this.sessionFactory.getCurrentSession().update(b);
		return true;
	}

	
	public boolean rejectedBlogdetails(int id) {
		
		Blog b=this.getBlogdetails(id);
		b.setStatus("Not Approved");
		this.sessionFactory.getCurrentSession().update(b);
		return true;
	}

	
	public boolean incrementlikes(int id) {
		
		Blog b=this.getBlogdetails(id);
		b.setLikes(b.getLikes()+1);
		this.sessionFactory.getCurrentSession().update(b);
		return true;
	}

	
	public boolean decrementlikes(int id) {

		Blog b=this.getBlogdetails(id);
		b.setDislikes(b.getDislikes()-1);
		this.sessionFactory.getCurrentSession().update(b);
		return true;
	}

}
