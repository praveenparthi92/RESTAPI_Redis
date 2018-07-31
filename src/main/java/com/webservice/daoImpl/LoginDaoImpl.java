package com.webservice.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.webservice.dao.LoginDao;
import com.webservice.model.UserModelInfo;
import com.webservice.repo.UserModelInfoRepo;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	UserModelInfoRepo userModelInfoRepo;

	@Override
	public UserModelInfo getUserInfo(String phone) {
		return userModelInfoRepo.findByPhoneNumber(phone);
	}

	@Override
	public UserModelInfo saveUserInfo(UserModelInfo userModelInfo) {
		return userModelInfoRepo.save(userModelInfo);
	}

}
