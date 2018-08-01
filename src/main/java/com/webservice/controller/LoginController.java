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
import com.webservice.common.CommonUtils;
import com.webservice.common.StatusResponseDTO;
import com.webservice.dto.CreditDetailModelDto;
import com.webservice.dto.UsermodelinfoDto;
import com.webservice.redis.model.CreditAmountLimit;
import com.webservice.redis.service.WebController;
import com.webservice.service.LoginService;
import com.webservice.service.UserTransactionService;
import com.webservice.serviceImpl.AppUserDetailsService;

@RestController
@CrossOrigin

public class LoginController {
	
	@Autowired
	LoginService loginService;
	@Autowired
	WebController webController;
	
	@Autowired 
	UserTransactionService userTransactionService;
	
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	CommonUtils commonUtils;
	
	@CrossOrigin
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<String> saveUserInfo(@RequestBody UsermodelinfoDto usermodelinfodto) {
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		
		//appUserDetailsService.loadUserByUsername(usermodelinfodto)
		UsermodelinfoDto usermodelinfoDto = loginService.getUserInfo(usermodelinfodto.getPhoneNumber());
		String password = commonUtils.shaPassEncoAndDec(usermodelinfodto.getPassword());
		usermodelinfodto.setPassword(password);
		if(usermodelinfoDto == null){
			boolean isSave = loginService.saveUserInfp(usermodelinfodto);
			if(isSave){
				statusResponseDTO.setStatus("Success");
				statusResponseDTO.setMessage("Record Saved Successfully");
				CreditDetailModelDto creditDetailModelDto = new CreditDetailModelDto();
				creditDetailModelDto.setPhoneNum(usermodelinfodto.getPhoneNumber());
				creditDetailModelDto.setCreditAmount(0.0);
				userTransactionService.saveCreditDetail(creditDetailModelDto);
				
				CreditAmountLimit amountLimit = new CreditAmountLimit(Long.valueOf(usermodelinfodto.getPhoneNumber()), 5000);
				webController.save(amountLimit);
				System.out.println("Saved successfully in Redis");
			}else{
				statusResponseDTO.setStatus("Failure");
				statusResponseDTO.setMessage("Failed To Saved Record");
			}
			return new ResponseEntity<String>(new Gson().toJson(statusResponseDTO), HttpStatus.OK);
		}else{
			statusResponseDTO.setStatus("Already");
			statusResponseDTO.setMessage("Record Already Exist");
		}
		
		return null;
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<String> getUserInfoByPhone(@RequestBody UsermodelinfoDto usermodelinfodto) {
		UsermodelinfoDto usermodelinfoDto = loginService.getUserInfo(usermodelinfodto.getPhoneNumber());
		return new ResponseEntity<String>(new Gson().toJson(usermodelinfoDto), HttpStatus.OK);
	}
	
}
