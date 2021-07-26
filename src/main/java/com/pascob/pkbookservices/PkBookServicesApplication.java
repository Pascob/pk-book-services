package com.pascob.pkbookservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pascob.pkbookservices.domain.Book;
import com.pascob.pkbookservices.repository.BookRepository;

@SpringBootApplication
public class PkBookServicesApplication implements CommandLineRunner{
	@Autowired
	private BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(PkBookServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(bookRepository.count() == 0) {
			List<Book> books = new ArrayList<Book>();
			books.add(new Book("Apprendre angular", "", "", ""));
			books.add(new Book("Apprendre React", "", "", ""));
			books.add(new Book("Apprendre Arduino", "", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1TjiB_mqwGL4T5ggTNmtY5I4faI0QidXfpQ&usqp=CAU", ""));
			books.add(new Book("Apprendre Laravel", "", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJvizj9dvW3OTKlVty06Qk7xWylplwM3Uw5A&usqp=CAU", ""));
			
			bookRepository.saveAll(books);
		}
		
	}

}
