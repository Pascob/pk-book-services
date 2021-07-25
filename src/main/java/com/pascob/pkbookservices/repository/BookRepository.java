package com.pascob.pkbookservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pascob.pkbookservices.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
