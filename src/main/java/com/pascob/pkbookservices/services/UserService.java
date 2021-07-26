package com.pascob.pkbookservices.services;

import java.util.List;

import com.pascob.pkbookservices.domain.User;
import com.pascob.pkbookservices.request.UserRequest;


public interface UserService {
	public User save(UserRequest userRequest);
	public User update(Long id, UserRequest userRequest);
	public Boolean disable(Long id);
	public Boolean delete(Long id);
	public List<User> findAll();
	//public Boolean existsByUsername(String username);
	public Boolean existsByEmail(String email);

}
