package com.cashrich.service;

import java.util.Optional;

import com.cashrich.dto.UserDTO;
import com.cashrich.model.User;

public interface UserService {
	public User saveUser(UserDTO user);
	Optional<User> findByUsername(String username);
	void updateUserProfile(User user);
	
}
