package com.webservice.common;

import com.webservice.dto.UsermodelinfoDto;
import com.webservice.model.User;

public class ModelToDtoConversion {
	
	public UsermodelinfoDto UserModelInfoToDto(User userModelInfo) {
		UsermodelinfoDto usermodelinfoDto = new UsermodelinfoDto();
		usermodelinfoDto.setPassword(userModelInfo.getPassword());
		usermodelinfoDto.setUsername(userModelInfo.getUsername());
		usermodelinfoDto.setPhoneNumber(userModelInfo.getPhoneNumber());
		return usermodelinfoDto;
		
			
	}
	
}
