package com.pascob.pkbookservices.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    private String nom;

    private String prenom;
    
    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Book> books = new HashSet<>();
}
