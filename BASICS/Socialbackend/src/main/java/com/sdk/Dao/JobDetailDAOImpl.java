package com.sdk.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdk.Domain.JobDetail;

@Repository("jobDetailDAO")
@Transactional
public class JobDetailDAOImpl implements JobDetailDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	//
	public List<JobDetail> getalljobdetails() {
		
		return sessionFactory.getCurrentSession().createQuery("from JobDetail").list();
	}

	//
	public boolean addjobdetails(JobDetail j) {
		try
		{
		sessionFactory.getCurrentSession().save(j);
		return true;
	}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return false;
		}
	}

	//
	public boolean updatejobdetails(JobDetail j) {
		try
		{
		sessionFactory.getCurrentSession().update(j);
		return true;
	}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return false;
		}
	}

	//
	public boolean deletejobdetails(JobDetail j) {
		
		sessionFactory.getCurrentSession().delete(j);
		return true;
	}

	//
	public JobDetail findjobId(int id) {
		try
		{
		Session session=sessionFactory.openSession();
		JobDetail job=(JobDetail)session.get(JobDetail.class,id);
		session.close();
		return job;
	}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return null;
			
		}
	}

}
