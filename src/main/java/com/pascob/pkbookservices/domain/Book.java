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
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String synopsis;
	
	private String urlPageGarde;
	
	private String urlBook;

	private Integer nbLike = 0;

	private Integer nbDownload = 0;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "book_authors",
		joinColumns = @JoinColumn(name="book_id"),
		inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();

	@ManyToOne
	//@JsonIgnoreProperties(value = "commandes", allowSetters = true)
	private User user;

	public Book (String title, String synopsis, String urlPageGarde, String urlBook){
		super();
		this.title = title;
		this.synopsis = synopsis;
		this.urlPageGarde = urlPageGarde;
		this.urlBook = urlBook;
	}
	

}
