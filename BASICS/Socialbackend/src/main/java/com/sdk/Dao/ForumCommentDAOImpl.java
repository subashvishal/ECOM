package com.sdk.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdk.Domain.ForumComment;

@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	
	public List<ForumComment> getforumcommentdetails() {
		
		return sessionFactory.getCurrentSession().createQuery("from ForumComment").list();
	}

	
	public boolean addforumcommentdetails(ForumComment fc) {
		
		sessionFactory.getCurrentSession().save(fc);
		return true;
	}

	
	public ForumComment findcommentId(int commentId) {
		try
		{
			Session session=sessionFactory.openSession();
			ForumComment forum=(ForumComment)session.get(ForumComment.class, commentId);
			session.close();
			return forum;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return null;
		}
			
		}
	

	
	public boolean updateforumcommentdetails(ForumComment fc) {
		sessionFactory.getCurrentSession().update(fc);
		return true;
	}

	
	public boolean deleteforumcommentdetails(ForumComment fc) {
		sessionFactory.getCurrentSession().delete(fc);
		return true;
	}

}
