package com.pascob.pkbookservices.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String nom;
	
	@NotBlank
	private String prenom;
	
	@NotBlank
	private Boolean fgActif=true;
	
	private Set<String> roles;
	

}
