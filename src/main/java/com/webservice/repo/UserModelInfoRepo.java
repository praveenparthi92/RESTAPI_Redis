package com.webservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.model.UserModelInfo;

@Repository
public interface UserModelInfoRepo extends JpaRepository<UserModelInfo,Integer>{

	UserModelInfo findByPhoneNumber(String phone);

}
