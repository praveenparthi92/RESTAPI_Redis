package com.webservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="user_info")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserModelInfo {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String phoneNumber;
	private String tokenValue;
	
	@OneToMany(mappedBy="userModelForTrans", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<UserTransactionModel> transInfo;
	
	@OneToOne(mappedBy="userModelForCredit", cascade=CascadeType.PERSIST)
	private CreditDetailModel creditDetailModel;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTokenValue() {
		return tokenValue;
	}
	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	
	
}
