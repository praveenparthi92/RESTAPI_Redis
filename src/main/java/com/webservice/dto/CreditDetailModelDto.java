package com.webservice.dto;

import com.webservice.model.User;

public class CreditDetailModelDto {

	private Integer id;
	private String phoneNum;
	private Double creditAmount;
	private User userModelForCredit;
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
	public User getUserModelForCredit() {
		return userModelForCredit;
	}
	public void setUserModelForCredit(User userModelForCredit) {
		this.userModelForCredit = userModelForCredit;
	}
	
	
	
}
