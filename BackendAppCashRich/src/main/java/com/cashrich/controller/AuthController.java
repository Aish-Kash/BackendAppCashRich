package com.cashrich.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashrich.dto.JWTResponse;
import com.cashrich.dto.LoginDTO;
import com.cashrich.model.CryptoResponse;
import com.cashrich.model.User;
import com.cashrich.service.UserService;
import com.cashrich.service.Impl.CoinService;
import com.cashrich.service.Impl.JwtService;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

	
	 @Autowired
	    private UserService userService;
	 
	 @Autowired
	 private CoinService coinService;
	 
	 @Autowired
	 private JwtService jwtService; 
	
	
	 
	 @PutMapping("/profile")
	    public ResponseEntity<String> updateUserProfile(@RequestBody User user) {
	        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        User existingUser = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
	        user.setId(existingUser.getId());
	        userService.updateUserProfile(user);
	        return new ResponseEntity<>("User profile updated successfully", HttpStatus.OK);
	    }

	    @GetMapping("/coin")
	    public ResponseEntity<CryptoResponse> getCoinDetails() {
	        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
	        CryptoResponse cryptoResponse = coinService.getCoinDetails(user.getId());
	        return ResponseEntity.ok(cryptoResponse);
	    }
	    
	   
}
