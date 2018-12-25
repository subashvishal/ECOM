package com.sdk.Dao;

import java.util.List;

import com.sdk.Domain.ForumComment;

public interface ForumCommentDAO {

	public List<ForumComment> getforumcommentdetails();
	public boolean addforumcommentdetails(ForumComment fc);
	public ForumComment findcommentId(int commentId);
	public boolean updateforumcommentdetails(ForumComment fc);
	public boolean deleteforumcommentdetails(ForumComment fc);
}
