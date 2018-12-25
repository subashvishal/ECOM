package com.sdk.Dao;

import java.util.List;

import com.sdk.Domain.JobDetail;

public interface JobDetailDAO {

	public List<JobDetail>getalljobdetails();
	public boolean addjobdetails(JobDetail j);
	public boolean updatejobdetails(JobDetail j);
	public boolean deletejobdetails(JobDetail j);
	public JobDetail findjobId(int id);
}
