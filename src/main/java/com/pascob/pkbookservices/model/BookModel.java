package com.pascob.pkbookservices.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.pascob.pkbookservices.controller.BookController;
import com.pascob.pkbookservices.domain.Book;

import lombok.Getter;

@Getter
public class BookModel extends RepresentationModel<BookModel>{
	
	private final Book book;

	public BookModel(final Book book) {
		this.book = book;
		final long id = book.getId();
		add(WebMvcLinkBuilder.linkTo(BookController.class).withRel("people"));
		add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).get(id)).withSelfRel());
		
	}

}
