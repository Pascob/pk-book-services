package com.pascob.pkbookservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pascob.pkbookservices.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
