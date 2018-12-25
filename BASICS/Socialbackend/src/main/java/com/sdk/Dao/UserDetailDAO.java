package com.sdk.Dao;

import com.sdk.Domain.UserDetail;

public interface UserDetailDAO {

	public boolean registerUser(UserDetail userdetail);
	public boolean updateUser(UserDetail userdetail);
	public UserDetail getUser(String loginname);
	public UserDetail checkUser(UserDetail userdetail);
	
}
