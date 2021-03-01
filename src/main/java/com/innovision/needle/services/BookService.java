package com.innovision.needle.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovision.needle.models.Book;
import com.innovision.needle.models.Checkout;
import com.innovision.needle.repositories.BookRepository;
import com.innovision.needle.repositories.CheckoutRepository;


@Service
public class BookService {
	
	  @Autowired
	  private BookRepository bookRepository;
	  
	  @Autowired 
	  private CheckoutRepository checkoutRepository;
	
	  public List<Book> getAllBooks(){
		  return bookRepository.findAll();
	  }
	  
	  public Book getBook(String id){
		  return bookRepository.findById(id).get();
	  }
	  
	  public Book createBook(Book book){
		  book.setId(UUID.randomUUID().toString());
		  return bookRepository.save(book);
	  }
	  
	  public Book updateBook(String id, Book book){
		  
		  Book storedBook = bookRepository.findById(id).get();
		  
		  storedBook.setAuthorName(book.getAuthorName());
		  storedBook.setCount(book.getCount());
		  storedBook.setName(book.getName());
		  
		  return bookRepository.save(storedBook);
	  }
	  
	  public void deleteBook(String id){
		 bookRepository.deleteById(id);
	  }
	  
	  public List<Book> searchBook(String bookName,String authorName){
		  if(bookName == null && authorName == null) {
			  return null;
		  } else if(bookName != null && authorName != null) {
			  return bookRepository.findByBookAndAuthor(bookName, authorName);
		  } else if(bookName == null) {
			  return bookRepository.findByBookName(bookName);
		  }
		  
		  
		  return bookRepository.findByAuthorName(authorName);
	  }
	  
	  public Checkout extendReturnDate(int checkoutId,int days) {
		  
		  Checkout entry = checkoutRepository.findById(checkoutId).get();
		  Date returnDate = entry.getEstimatedReturnDate();
		  long ltime=returnDate.getTime()+days*24*60*60*1000;
		  
		  Date newEstimate = new Date(ltime);
		  entry.setEstimatedReturnDate(newEstimate);
		  
		  return checkoutRepository.save(entry);
	  }
	  
	  public boolean checkAvailability(String bookId) {
		  
		  Book bookCheck = bookRepository.checkAvailability(bookId);
		  
		  return bookCheck != null;
	  }
	  
}
