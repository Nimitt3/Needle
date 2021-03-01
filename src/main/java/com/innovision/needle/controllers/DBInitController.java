package com.innovision.needle.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovision.needle.models.Book;
import com.innovision.needle.services.BookService;

@RestController
@RequestMapping("/dbinit")
public class DBInitController {
	
	 @Autowired
	 private BookService bookService;
	
	 @GetMapping
	 public void initialize() {
		 
		 Book book1 = Book.builder() 
			 				.id(UUID.randomUUID().toString())
				 			.name("Chicken Soup")
				 			.count(2)
				 			.authorName("Charles darwin")
				 			.build();
		 
		 
		 Book book2 = Book.builder() 
				 				.id(UUID.randomUUID().toString())
					 			.name("Think and grow rich")
					 			.count(5)
					 			.authorName("Napollean hill")
					 			.build();
		 
		 bookService.createBook(book1);
		 bookService.createBook(book2);
		 
	 }
	
	
}
