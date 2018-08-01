package com.webservice.redis.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditAmountLimit implements Serializable {

	private static final long serialVersionUID = 1L;

	private long mobileNo;
	private int creditAmountLimit;

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getCreditAmountLimit() {
		return creditAmountLimit;
	}

	public void setCreditAmountLimit(int creditAmountLimit) {
		this.creditAmountLimit = creditAmountLimit;
	}

	public CreditAmountLimit(@JsonProperty("mobileNo")long mobileNo,@JsonProperty("creditAmountLimit") int creditAmountLimit) {
		this.mobileNo = mobileNo;
		this.creditAmountLimit = creditAmountLimit;
	}

}