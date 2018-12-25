package com.sdk.Dao;

import com.sdk.Domain.ProfilePicture;

public interface ProfilePictureDAO {

	public boolean save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
