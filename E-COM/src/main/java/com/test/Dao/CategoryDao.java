package com.test.Dao;

import java.util.List;

import com.test.model.Category;

public interface CategoryDao 
{
	public boolean addCategory(Category category);
	public Category getCategory(int categoryId);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public List<Category> getCategories();
}
