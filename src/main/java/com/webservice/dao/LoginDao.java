package com.webservice.dao;

import com.webservice.model.User;

public interface LoginDao {

	public User getUserInfo(String phone);

	public User saveUserInfo(User userModelInfo);
	
}
