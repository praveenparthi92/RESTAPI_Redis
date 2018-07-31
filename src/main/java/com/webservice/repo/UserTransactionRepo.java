package com.webservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.model.UserTransactionModel;

public interface UserTransactionRepo extends JpaRepository<UserTransactionModel,Integer>{
	

}
