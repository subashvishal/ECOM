package com.test.Dao;

import java.util.List;

import com.test.model.UserDetail;
public interface UserDao {
public boolean registerUser(UserDetail user);
public boolean updateUser(UserDetail user);
public UserDetail getUserDetails(String username);
public List<UserDetail> listUser();
//public UserDetail validate(String username,String password);
}
