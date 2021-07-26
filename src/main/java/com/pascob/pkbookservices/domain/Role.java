package com.pascob.pkbookservices.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Role {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Enumerated(EnumType.STRING)
	private ERole name;
	
	
	public Role() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public ERole getName() {
		return name;
	}


	public void setName(ERole name) {
		this.name = name;
	}
	
	

}
