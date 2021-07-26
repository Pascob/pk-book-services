package com.pascob.pkbookservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pascob.pkbookservices.domain.ERole;
import com.pascob.pkbookservices.domain.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(ERole name);

}
