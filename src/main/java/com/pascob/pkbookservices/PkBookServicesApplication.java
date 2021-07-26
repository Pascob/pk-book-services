package com.pascob.pkbookservices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pascob.pkbookservices.domain.Book;
import com.pascob.pkbookservices.domain.ERole;
import com.pascob.pkbookservices.domain.Role;
import com.pascob.pkbookservices.domain.User;
import com.pascob.pkbookservices.repository.BookRepository;
import com.pascob.pkbookservices.repository.RoleRepository;
import com.pascob.pkbookservices.repository.UserRepository;

@SpringBootApplication
public class PkBookServicesApplication implements CommandLineRunner{
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(PkBookServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		if(! userRepository.existsByEmail("pascob.pk@gmail.com")) {
			Role admin = roleRepository.save(
					new Role(null, ERole.ROLE_ADMIN)
					);
			
			User user = new User("pascob.pk@gmail.com", encoder.encode("123456789"), "KABORE", "Pascal", true);
			Set<Role> roles = new HashSet<>();
			roles.add(admin);
			user.setRoles(roles);
			userRepository.save(user);
			
		}
		
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
