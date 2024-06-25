package com.cashrich.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cashrich.dto.UserDTO;
import com.cashrich.model.User;
import com.cashrich.repository.UserRepository;
import com.cashrich.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User saveUser(UserDTO userdto) {
    	
    	User user = new User();
    	user.setFirstName(userdto.getFirstName());
    	user.setLastName(userdto.getLastName());
    	user.setEmail(userdto.getEmail());
    	user.setMobile(userdto.getMobile());
    	user.setUserName(userdto.getUserName());
    	user.setPassword(userdto.getPassword());
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }
        if (userRepository.existsByUsername(user.getUserName())) {
            throw new IllegalArgumentException("Username is already in use");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void updateUserProfile(User user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setMobile(user.getMobile());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(existingUser);
    }

	
}
