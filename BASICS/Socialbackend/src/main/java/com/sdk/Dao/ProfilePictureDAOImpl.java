package com.sdk.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdk.Domain.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	//
	public boolean save(ProfilePicture profilePicture) {

		Session session=sessionFactory.openSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		session.close();
		
		return true;
	}

	//
	public ProfilePicture getProfilePicture(String username) {
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, username);
		session.close();
		return profilePicture;
	}

}
