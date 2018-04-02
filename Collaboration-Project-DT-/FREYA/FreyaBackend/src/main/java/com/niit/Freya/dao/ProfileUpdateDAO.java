package com.niit.Freya.dao;

import com.niit.Freya.model.ProfilePicture;

public interface ProfileUpdateDAO
{
	public boolean save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String userName);


}
