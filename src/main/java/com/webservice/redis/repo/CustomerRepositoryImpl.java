package com.webservice.redis.repo;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.webservice.redis.model.CreditAmountLimit;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private static final String KEY = "User";
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Long, CreditAmountLimit> hashOperations;

	
	public CustomerRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(CreditAmountLimit customer) {
		hashOperations.put(KEY, customer.getMobileNo(), customer);
	}

	@Override
	public CreditAmountLimit find(Long id) {
		return hashOperations.get(KEY, id);
	}

	@Override
	public Map<Long, CreditAmountLimit> findAll() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void update(CreditAmountLimit customer) {
		hashOperations.put(KEY, customer.getMobileNo(), customer);
	}

	@Override
	public void delete(Long id) {
		hashOperations.delete(KEY, id);
	}

}
