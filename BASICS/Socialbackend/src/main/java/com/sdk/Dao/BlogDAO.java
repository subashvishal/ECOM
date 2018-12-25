package com.sdk.Dao;

import java.util.List;

import com.sdk.Domain.Blog;

public interface BlogDAO {

	public List<Blog> findblogdetails();
	public Blog getBlogdetails(int id);
	public boolean addBlogdetails(Blog blog);
	public boolean updateBlogdetails(Blog blog);
	public boolean deleteBlogdetails(Blog blog);
	public boolean approvedBlogdetails(int id);
	public boolean rejectedBlogdetails(int id);
	public boolean incrementlikes(int id);
	public boolean decrementlikes(int id);
}
