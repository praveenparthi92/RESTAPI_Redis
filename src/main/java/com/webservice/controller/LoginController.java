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
import com.webservice.dto.UsermodelinfoDto;
import com.webservice.service.LoginService;

@RestController
@CrossOrigin

public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@CrossOrigin
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<String> saveUserInfo(@RequestBody UsermodelinfoDto usermodelinfodto) {
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		UsermodelinfoDto usermodelinfoDto = loginService.getUserInfo(usermodelinfodto.getPhoneNumber());
		if(usermodelinfoDto == null){
			boolean isSave = loginService.saveUserInfp(usermodelinfodto);
			if(isSave){
				statusResponseDTO.setStatus("Success");
				statusResponseDTO.setMessage("Record Saved Successfully");
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
