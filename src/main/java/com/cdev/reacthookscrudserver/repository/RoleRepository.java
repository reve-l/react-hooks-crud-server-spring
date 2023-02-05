package com.cdev.reacthookscrudserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;


import com.cdev.reacthookscrudserver.model.Role;
import com.cdev.reacthookscrudserver.model.ERole;

//@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERole name);

}
