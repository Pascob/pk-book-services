package com.pascob.pkbookservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pascob.pkbookservices.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	//Optional<User> findByUsername(String username);
	Boolean existsByEmail(String email);
	//Boolean existsByUsername(String username);
}
