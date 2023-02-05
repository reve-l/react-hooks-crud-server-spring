package com.cdev.reacthookscrudserver.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cdev.reacthookscrudserver.repository.UserRepository;
//import com.cdev.reacthookscrudserver.model.User;
import com.cdev.reacthookscrudserver.model.User;


@Service
public class UserDetailsServiceImpl {
	@Autowired
	  UserRepository userRepository;

	  //@Override
	  @Transactional
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = userRepository.findByUsername(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

	    return UserDetailsImpl.build(user);
	  }
}
