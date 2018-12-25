package com.sdk.Dao;

import java.util.List;

import com.sdk.Domain.Friend;

public interface FriendDAO {
	
	public List<Friend> frienddetails();
	public boolean addfriendetails(Friend d);
	public boolean updatefriendetails(Friend d);
	public boolean deletefriendetails(Friend d);
	public Friend findfriendId(int friendId);
	public boolean Acceptedfriendrequest(int friendId);
	public boolean NotAcceptedfriendrequest(int friendId);	

}
