package com.sdk.Dao;

import java.util.List;

import com.sdk.Domain.BlogComment;

public interface BlogCommentDAO {
	
	public List<BlogComment> getblogcommentsdetails();
	public boolean addblogcomments(BlogComment bc);
	public boolean updateblogcomments(BlogComment bc);
	public boolean deleteblogcomments(BlogComment bc);
	public BlogComment getBlogComments(int blogId);

}
