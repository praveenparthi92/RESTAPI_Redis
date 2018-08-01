package com.webservice.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.dao.LoginDao;
import com.webservice.model.User;
import com.webservice.repo.UserModelInfoRepo;

@Service
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	UserModelInfoRepo userModelInfoRepo;

	@Override
	public User getUserInfo(String phone) {
		return userModelInfoRepo.findByPhoneNumber(phone);
	}

	@Override
	public User saveUserInfo(User userModelInfo) {
		return userModelInfoRepo.save(userModelInfo);
	}

}
