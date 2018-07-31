package com.webservice.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.dao.UserTransactionDao;
import com.webservice.model.CreditDetailModel;
import com.webservice.model.UserTransactionModel;
import com.webservice.repo.CreditDetailRepo;
import com.webservice.repo.UserTransactionRepo;

@Service
public class UserTransactionDaoImpl implements UserTransactionDao{
	
	@Autowired
	UserTransactionRepo userTransactionRepo;
	
	@Autowired
	CreditDetailRepo creditDetailRepo;

	@Override
	public UserTransactionModel saveTransaction(UserTransactionModel transaction) {
		
		UserTransactionModel trans = userTransactionRepo.save(transaction);
		return trans;
	}

	@Override
	public CreditDetailModel saveCreditDetail(CreditDetailModel creditDetailModel) {
		// TODO Auto-generated method stub
		return creditDetailRepo.save(creditDetailModel);
	}

}
