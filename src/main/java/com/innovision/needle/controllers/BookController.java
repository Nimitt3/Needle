package com.innovision.needle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovision.needle.models.Book;
import com.innovision.needle.models.Checkout;
import com.innovision.needle.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	  @Autowired
	  private BookService bookService;
		
	  @GetMapping
	  public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	  }
	  
	  @GetMapping("/{id}")
	  public Book getBook(@PathVariable String id){
		return bookService.getBook(id);
	  }
	  
	  @PostMapping("/create")
	  public Book createBook(@RequestBody Book book) {
		  return bookService.createBook(book);
	  }
	  
	  @PutMapping("/update/{id}")
	  public Book updateBook(@PathVariable String id, @RequestBody Book book) {
		  return bookService.updateBook(id, book);
	  }
	  
	  @PostMapping("/delete/{id}")
	  public void updateBook(@PathVariable String id) {
		 bookService.deleteBook(id);
	  }
	  
	  @GetMapping("/search")
	  public List<Book>  searchBookByBookName(@RequestParam(value="bookName", required=false) String bookName,
			  						  @RequestParam(value="authorName", required=false) String authorName){
		  
		  return bookService.searchBook(bookName, authorName);
	  }
	  
	
	  @PostMapping("/extend")
	  public Checkout extendReturnTimeForBook(@RequestParam(value="checkoutId") int checkoutId, @RequestParam(value="days") int days) {
		 // extend the booking by no. of days.
		  
		  return bookService.extendReturnDate(checkoutId, days);
	  }
	  
	  @GetMapping("/{bookId}")
	  public boolean checkAvailability(@PathVariable String bookId) {
			
			return bookService.checkAvailability(bookId);
	  }
	
}
