package com.webservice.dao;

import com.webservice.model.CreditDetailModel;
import com.webservice.model.UserTransactionModel;

public interface UserTransactionDao {

	UserTransactionModel saveTransaction(UserTransactionModel userTransactionModel);
	
	CreditDetailModel saveCreditDetail(CreditDetailModel creditDetailModel);
	
}
