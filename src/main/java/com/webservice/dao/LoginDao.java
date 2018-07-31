package com.webservice.dao;

import org.springframework.stereotype.Service;

import com.webservice.model.UserModelInfo;
@Service
public interface LoginDao {

	public UserModelInfo getUserInfo(String phone);

	public UserModelInfo saveUserInfo(UserModelInfo userModelInfo);
	
}
