package com.webservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.model.CreditDetailModel;
import com.webservice.model.UserTransactionModel;

@Repository
public interface CreditDetailRepo extends JpaRepository<CreditDetailModel,Integer>{
	

}
