package com.webservice.service;

import org.springframework.stereotype.Service;

import com.webservice.dto.UsermodelinfoDto;
@Service
public interface LoginService {

	public UsermodelinfoDto getUserInfo(String phone);
	
	public boolean saveUserInfp(UsermodelinfoDto usermodelinfodto);
}
