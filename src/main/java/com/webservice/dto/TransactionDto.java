package com.webservice.dto;

import java.util.Date;

public class TransactionDto {
	private Integer id;
	private Date transDate;
	private String description;
	private Double amount;
	private Double bonus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

}
