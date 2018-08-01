package com.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.webservice.common.StatusResponseDTO;
import com.webservice.dto.CreditDetailModelDto;
import com.webservice.dto.TransactionDto;
import com.webservice.service.UserTransactionService;


@RestController
@CrossOrigin
public class TransactionController {

	@Autowired
	UserTransactionService userTransactionService;
	
	@CrossOrigin
	@RequestMapping(value = "/saveTransaction", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<String> saveUserInfo(@RequestBody TransactionDto transactionDto) {
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
			boolean isSave = userTransactionService.saveTransaction(transactionDto);
			if(isSave){
				statusResponseDTO.setStatus("Success");
				statusResponseDTO.setMessage("Record Saved Successfully");
			}else{
				statusResponseDTO.setStatus("Failure");
				statusResponseDTO.setMessage("Failed To Saved Record");
			}
			return new ResponseEntity<String>(new Gson().toJson(statusResponseDTO), HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/saveCreditDetail", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<String> saveCreditDetail(@RequestBody CreditDetailModelDto creditDetailModelDto) {
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
			boolean isSave = userTransactionService.saveCreditDetail(creditDetailModelDto);
			if(isSave){
				statusResponseDTO.setStatus("Success");
				statusResponseDTO.setMessage("Record Saved Successfully");
			}else{
				statusResponseDTO.setStatus("Failure");
				statusResponseDTO.setMessage("Failed To Saved Record");
			}
			return new ResponseEntity<String>(new Gson().toJson(statusResponseDTO), HttpStatus.OK);
		
	}
}
