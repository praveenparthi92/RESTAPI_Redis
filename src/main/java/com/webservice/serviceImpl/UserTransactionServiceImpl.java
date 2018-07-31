package com.webservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.common.DtoToModelConversion;
import com.webservice.dao.UserTransactionDao;
import com.webservice.dto.CreditDetailModelDto;
import com.webservice.dto.TransactionDto;
import com.webservice.model.CreditDetailModel;
import com.webservice.model.UserTransactionModel;
import com.webservice.service.UserTransactionService;

@Service
public class UserTransactionServiceImpl implements UserTransactionService{
	
	@Autowired
	UserTransactionDao userTransactionDao;

	@Override
	public boolean saveTransaction(TransactionDto transactionDto) {
		DtoToModelConversion dtoToModelConversion = new  DtoToModelConversion();
		UserTransactionModel userTransactionModel = dtoToModelConversion.TransactionToDto(transactionDto);
		UserTransactionModel userTrans = userTransactionDao.saveTransaction(userTransactionModel);
		if(userTrans != null){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean saveCreditDetail(CreditDetailModelDto creditDetailModelDto) {
		DtoToModelConversion dtoToModelConversion = new  DtoToModelConversion();
		CreditDetailModel creditDetailModel = dtoToModelConversion.CreditDetailToDto(creditDetailModelDto);
		CreditDetailModel creditDetail = userTransactionDao.saveCreditDetail(creditDetailModel);
		if(creditDetail !=null){
			return true;
		}else{
			return false;
		}
	}

}
