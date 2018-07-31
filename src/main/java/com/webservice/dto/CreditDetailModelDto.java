package com.webservice.dto;

import com.webservice.model.UserModelInfo;

public class CreditDetailModelDto {

	private Integer id;
	private String phoneNum;
	private Double creditAmount;
	private UserModelInfo userModelForCredit;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Double getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}
	public UserModelInfo getUserModelForCredit() {
		return userModelForCredit;
	}
	public void setUserModelForCredit(UserModelInfo userModelForCredit) {
		this.userModelForCredit = userModelForCredit;
	}
	
	
	
}
