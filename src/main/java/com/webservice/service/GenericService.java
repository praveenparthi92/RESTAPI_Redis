package com.webservice.service;


import java.util.List;

import com.webservice.model.RandomCity;
import com.webservice.model.User;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
}
