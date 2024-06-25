package com.cashrich.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cashrich.model.User;
import com.cashrich.repository.UserRepository;
import com.cashrich.securityConfiguration.UserInfoUserDetails;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	 @Autowired
	    private UserRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<User> userInfo = repository.findByUsername(username);
	        return userInfo.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

	    }
}
