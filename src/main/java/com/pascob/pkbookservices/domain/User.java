package com.pascob.pkbookservices.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "email"),
		//@UniqueConstraint(columnNames = "telephone")
})
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    private String nom;

    private String prenom;
    
    private String email;

    private String password;
    
    private Boolean fgActif=true;

    @OneToMany(mappedBy = "user")
    private Set<Book> books = new HashSet<>();
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_roles",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
    
    public User(String email, String password, String nom, String prenom, Boolean fgActif) {
		super();
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.fgActif = fgActif;
	}
}
