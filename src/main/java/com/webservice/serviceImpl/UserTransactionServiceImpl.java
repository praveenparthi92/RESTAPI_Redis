package com.webservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.common.DtoToModelConversion;
import com.webservice.dao.UserTransactionDao;
import com.webservice.dto.CreditDetailModelDto;
import com.webservice.dto.TransactionDto;
import com.webservice.model.CreditDetailModel;
import com.webservice.model.UserTransactionModel;
import com.webservice.repo.CreditDetailRepo;
import com.webservice.service.UserTransactionService;

@Service
public class UserTransactionServiceImpl implements UserTransactionService{
	
	@Autowired
	UserTransactionDao userTransactionDao;
	
	@Autowired
	CreditDetailRepo creditDetailRepo;

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
		CreditDetailModel creditDetail = null;
		Double dbAmount = 0.0;
		CreditDetailModel creditDetailModelList = creditDetailRepo.findByPhoneNum(creditDetailModelDto.getPhoneNum());
		if(creditDetailModelList!=null) {
			if(creditDetailModelList.getCreditAmount()==null || creditDetailModelList.getCreditAmount()==0) {
				dbAmount = 0.0;
			}else {
				dbAmount = creditDetailModelList.getCreditAmount();	
			}
			
			Double totalAmount = dbAmount+creditDetailModelDto.getCreditAmount();
			creditDetailModelList.setCreditAmount(totalAmount);
			creditDetail = userTransactionDao.saveCreditDetail(creditDetailModelList);
		}else {
			DtoToModelConversion dtoToModelConversion = new  DtoToModelConversion();
			CreditDetailModel creditDetailModel = dtoToModelConversion.CreditDetailToDto(creditDetailModelDto);
			creditDetail = userTransactionDao.saveCreditDetail(creditDetailModel);
		}
		
		if(creditDetail !=null){
			return true;
			
		}else{
			return false;
		}
	}

}
