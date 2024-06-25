package com.cashrich.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashrich.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	 Optional<User> findByUsername(String username);
	 boolean existsByEmail(String email);
	 boolean existsByUsername(String username);
}
