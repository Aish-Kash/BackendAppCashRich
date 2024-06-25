package com.cashrich.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashrich.dto.LoginDTO;
import com.cashrich.dto.UserDTO;
import com.cashrich.model.User;
import com.cashrich.service.UserService;
import com.cashrich.service.Impl.CoinService;
import com.cashrich.service.Impl.JwtService;

@RestController
@RequestMapping("api/v1/User/")
public class UserController {

	 @Autowired
	    private UserService userService;
	 
	 @Autowired
	 private CoinService coinService;

	 
	 @Autowired
	 private JwtService jwtService; 
	 
	 @Autowired
	    private AuthenticationManager authenticationManager;
	 
	    @PostMapping("/signup")
	    public ResponseEntity<String> registerUser(@RequestBody UserDTO user) {
	       

	        if (!isValidUsername(user.getUserName()) || !isValidPassword(user.getPassword())) {
	            return new ResponseEntity<>("Invalid username or password", HttpStatus.BAD_REQUEST);
	        }
	        
	        userService.saveUser(user);
	        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<String> authenticateAndGetToken(@RequestBody LoginDTO authRequest) {
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
	 
	           
	            if (authentication.isAuthenticated()) {
	            	String token = jwtService.generateToken(authRequest.getUserName());
	            	return ResponseEntity.ok(token);
	            }
	         else {
	            throw new UsernameNotFoundException("invalid user request !");
	        }
	    }
	   

	    private boolean isValidUsername(String username) {
	        return username != null && username.matches("^[a-zA-Z0-9]{4,15}$");
	    }

	    private boolean isValidPassword(String password) {
	        if (password == null || password.length() < 8 || password.length() > 15) {
	            return false;
	        }

	        String upperCasePattern = ".*[A-Z].*";
	        String lowerCasePattern = ".*[a-z].*";
	        String digitPattern = ".*[0-9].*";
	        String specialCharPattern = ".*[^a-zA-Z0-9].*";

	        return password.matches(upperCasePattern) &&
	                password.matches(lowerCasePattern) &&
	                password.matches(digitPattern) &&
	                password.matches(specialCharPattern);
	    }
}
