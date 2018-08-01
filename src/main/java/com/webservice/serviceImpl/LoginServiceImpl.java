package com.webservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.common.DtoToModelConversion;
import com.webservice.common.ModelToDtoConversion;
import com.webservice.dao.LoginDao;
import com.webservice.dto.UsermodelinfoDto;
import com.webservice.model.UserModelInfo;
import com.webservice.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	
	@Override
	public UsermodelinfoDto getUserInfo(String phone) {
		UserModelInfo userModelInfo =  loginDao.getUserInfo(phone);
		if(userModelInfo != null) {
			ModelToDtoConversion modelToDtoConversion = new ModelToDtoConversion();
			UsermodelinfoDto usermodelinfoDto = modelToDtoConversion.UserModelInfoToDto(userModelInfo);
			return usermodelinfoDto;
		}else {
			return null;
		}
		
	}

	@Override
	public boolean saveUserInfp(UsermodelinfoDto usermodelinfodto) {
		DtoToModelConversion dtoToModelConversion = new DtoToModelConversion(); 
		UserModelInfo userModelInfo = dtoToModelConversion.userModelInfoToDto(usermodelinfodto);
		UserModelInfo userModel= loginDao.saveUserInfo(userModelInfo);
		if(userModel != null){
			return true;
		}else{
			return false;
		}
	}

}
