package com.webservice.service;

import com.webservice.dto.CreditDetailModelDto;
import com.webservice.dto.TransactionDto;

public interface UserTransactionService {
	
	boolean saveTransaction(TransactionDto transactionDto);
	boolean saveCreditDetail(CreditDetailModelDto creditDetailModelDto);

}
