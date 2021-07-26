package com.pascob.pkbookservices.model;

import com.pascob.pkbookservices.domain.Author;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;

@Getter
public class AuthorModel extends RepresentationModel<AuthorModel> {
    private final Author author;

    public AuthorModel(final Author author){
        this.author = author;
    }
}
