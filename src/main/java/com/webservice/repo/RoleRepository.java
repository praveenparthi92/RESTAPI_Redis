package com.webservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.webservice.model.Role;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
