package com.sdk.Dao;


import java.util.List;

import com.sdk.Domain.Forum;

public interface ForumDAO {
	
	public List<Forum> getforumdetails();
	public boolean addforumdetails(Forum f);
	public boolean updateforumdetails(Forum f);
	public boolean deleteforumdetails(Forum f);
	public Forum findforumId(int commentId);

}
