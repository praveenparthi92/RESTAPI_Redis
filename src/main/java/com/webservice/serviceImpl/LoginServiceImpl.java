package com.webservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.common.DtoToModelConversion;
import com.webservice.common.ModelToDtoConversion;
import com.webservice.dao.LoginDao;
import com.webservice.dto.UsermodelinfoDto;
import com.webservice.model.User;
import com.webservice.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	
	@Override
	public UsermodelinfoDto getUserInfo(String phone) {
		User userModelInfo =  loginDao.getUserInfo(phone);
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
		User userModelInfo = dtoToModelConversion.userModelInfoToDto(usermodelinfodto);
		User userModel= loginDao.saveUserInfo(userModelInfo);
		if(userModel != null){
			return true;
		}else{
			return false;
		}
	}

}
