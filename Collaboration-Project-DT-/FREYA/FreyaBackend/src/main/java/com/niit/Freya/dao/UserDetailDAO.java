package com.niit.Freya.dao;

import java.util.List;

import com.niit.Freya.model.UserDetail;

public interface UserDetailDAO 
{public boolean registerUser(UserDetail userDetail);

public boolean deleteUserDetail(UserDetail userDetail);

public boolean updateUserDetail(UserDetail userDetail);

public UserDetail getUserDetail(String userID);

public List<UserDetail> listUser();
		
public boolean checkLogin(UserDetail userDetail);
public boolean updateOnlineStatus(String status,UserDetail userDetail);

}
