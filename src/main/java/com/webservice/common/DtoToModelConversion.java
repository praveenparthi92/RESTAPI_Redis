package com.webservice.common;

import com.webservice.dto.CreditDetailModelDto;
import com.webservice.dto.TransactionDto;
import com.webservice.dto.UsermodelinfoDto;
import com.webservice.model.UserTransactionModel;
import com.webservice.model.CreditDetailModel;
import com.webservice.model.User;

public class DtoToModelConversion {

	public User userModelInfoToDto(UsermodelinfoDto usermodelinfoDto) {
		User userModelInfo = new User();
		if(usermodelinfoDto.getId()!=null){
			userModelInfo.setId(usermodelinfoDto.getId());
		}
		userModelInfo.setPassword(usermodelinfoDto.getPassword());
		userModelInfo.setUsername(usermodelinfoDto.getUsername());
		userModelInfo.setPhoneNumber(usermodelinfoDto.getPhoneNumber());
		//userModelInfo.setTokenValue(usermodelinfoDto.getTokenValue());
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
		return creditDetailModel;
	}
}
