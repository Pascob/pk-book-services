package com.pascob.pkbookservices.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pascob.pkbookservices.model.BookModel;
import com.pascob.pkbookservices.repository.BookRepository;

@RestController
@RequestMapping(value = "/api/books", produces = "application/hal+json")
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping
	public ResponseEntity<CollectionModel<BookModel>> books(){
		List<BookModel> bookModels = bookRepository.findAll().stream().map(BookModel::new).collect(Collectors.toList());
		CollectionModel<BookModel> collectionModel = CollectionModel.of(bookModels, Link.of(ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString(), "self"));
		return ResponseEntity.ok(collectionModel);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookModel> get(@PathVariable Long id){
		return null;
	}

}
