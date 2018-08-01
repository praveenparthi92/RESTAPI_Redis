package com.webservice.redis.repo;

import java.util.Map;

import com.webservice.redis.model.CreditAmountLimit;


public interface CustomerRepository {

	void save(CreditAmountLimit customer);
	CreditAmountLimit find(Long id);
	Map<Long, CreditAmountLimit> findAll();
	void update(CreditAmountLimit customer);
	void delete(Long id);
}
