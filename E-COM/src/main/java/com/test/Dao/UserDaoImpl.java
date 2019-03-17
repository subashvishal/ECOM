package com.test.Dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDaoImpl implements UserDao {
@Autowired
SessionFactory sessionFactory;
	public boolean registerUser(UserDetail user) {
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	public boolean updateUser(UserDetail user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	public UserDetail getUserDetails(String username) {
		Session session = sessionFactory.openSession();
		UserDetail user = (UserDetail)session.get(UserDetail.class,username);
		session.close();
		return user;
	}

	public List<UserDetail> listUser() {
		Session session = sessionFactory.openSession();
		Query query = (Query) session.createQuery("from UserDetail");
		List<UserDetail> listUser=query.list();
		session.close();
		return listUser;
	}

//	public UserDetail validate(String username, String password) {
		// TODO Auto-generated method stub
	//	return null;
	//}

	/*public UserDetail validate(String username, String password) {
		
		return null;
	}*/

}
