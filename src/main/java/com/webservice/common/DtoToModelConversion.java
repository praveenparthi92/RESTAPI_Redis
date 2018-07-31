package com.webservice.common;

import com.webservice.dto.CreditDetailModelDto;
import com.webservice.dto.TransactionDto;
import com.webservice.dto.UsermodelinfoDto;
import com.webservice.model.UserTransactionModel;
import com.webservice.model.CreditDetailModel;
import com.webservice.model.UserModelInfo;

public class DtoToModelConversion {

	public UserModelInfo userModelInfoToDto(UsermodelinfoDto usermodelinfoDto) {
		UserModelInfo userModelInfo = new UserModelInfo();
		if(usermodelinfoDto.getId()!=null){
			userModelInfo.setId(usermodelinfoDto.getId());
		}
		userModelInfo.setPhoneNumber(usermodelinfoDto.getPhoneNumber());
		userModelInfo.setTokenValue(usermodelinfoDto.getTokenValue());
		return userModelInfo;
	}
	
	
	public UserTransactionModel TransactionToDto(TransactionDto transactionDto) {
		UserTransactionModel transaction=new UserTransactionModel();
		if(transactionDto.getId() != null){
			transaction.setId(transactionDto.getId());
		}
		transaction.setAmount(transactionDto.getAmount());
		transaction.setBonus(transactionDto.getBonus());
		transaction.setDescription(transactionDto.getDescription());
		transaction.setTransDate(transactionDto.getTransDate());
		//transaction.setUserModelForTrans(transactionDto.getUserModelForTrans());
		return transaction;
	}
	
	public CreditDetailModel CreditDetailToDto(CreditDetailModelDto creditDetailModelDto) {
		CreditDetailModel creditDetailModel=new CreditDetailModel();
		if(creditDetailModelDto.getId() != null){
			creditDetailModel.setId(creditDetailModelDto.getId());
		}
		creditDetailModel.setCreditAmount(creditDetailModelDto.getCreditAmount());
		creditDetailModel.setPhoneNum(creditDetailModelDto.getPhoneNum());
		creditDetailModel.setUserModelForCredit(creditDetailModelDto.getUserModelForCredit());
		return creditDetailModel;
	}
}
