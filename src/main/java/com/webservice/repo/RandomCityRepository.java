package com.webservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.webservice.model.RandomCity;

/**
 * Created by nydiarra on 10/05/17.
 */
public interface RandomCityRepository extends CrudRepository<RandomCity, Long> {
}
