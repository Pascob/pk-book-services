package com.pascob.pkbookservices.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pascob.pkbookservices.domain.ERole;
import com.pascob.pkbookservices.domain.Role;
import com.pascob.pkbookservices.domain.User;
import com.pascob.pkbookservices.repository.RoleRepository;
import com.pascob.pkbookservices.repository.UserRepository;
import com.pascob.pkbookservices.request.UserRequest;
import com.pascob.pkbookservices.services.UserService;


@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public User save(UserRequest userRequest) {
		User user = new User();
		BeanUtils.copyProperties(userRequest, user);
		user.setPassword(encoder.encode(userRequest.getPassword()));
		Set<String> strRoles = userRequest.getRoles();
		Set<Role> roles = new HashSet<>();
		
		
		if(strRoles == null) {
			//Role par defaut
			roles.add(roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
		}else {
			strRoles.forEach(role ->{
				
			});
			
		}
		
		user.setRoles(roles);
		return userRepository.save(user);
	}

	@Override
	public User update(Long id, UserRequest userRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean disable(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

//	@Override
//	public Boolean existsByUsername(String username) {
//		return userRepository.existsByEmail(username);
//	}

	@Override
	public Boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

}
