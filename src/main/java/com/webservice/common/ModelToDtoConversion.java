package com.webservice.common;

import com.webservice.dto.UsermodelinfoDto;
import com.webservice.model.UserModelInfo;

public class ModelToDtoConversion {
	
	public UsermodelinfoDto UserModelInfoToDto(UserModelInfo userModelInfo) {
		UsermodelinfoDto usermodelinfoDto = new UsermodelinfoDto();

		usermodelinfoDto.setPhoneNumber(userModelInfo.getPhoneNumber());
		usermodelinfoDto.setTokenValue(userModelInfo.getTokenValue());
		return usermodelinfoDto;
		
			
	}
	
}
