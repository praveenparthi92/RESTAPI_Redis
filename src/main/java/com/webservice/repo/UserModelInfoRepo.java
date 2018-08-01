package com.webservice.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.model.User;

@Repository
public interface UserModelInfoRepo extends JpaRepository<User,Integer>{

	User findByPhoneNumber(String phone);

}
