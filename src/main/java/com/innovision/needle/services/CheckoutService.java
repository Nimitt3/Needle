package com.innovision.needle.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.innovision.needle.models.Book;
import com.innovision.needle.models.Checkout;
import com.innovision.needle.models.Member;
import com.innovision.needle.repositories.BookRepository;
import com.innovision.needle.repositories.CheckoutRepository;
import com.innovision.needle.repositories.MemberRepository;


@Service
public class CheckoutService {
	
	@Autowired 
	private CheckoutRepository checkoutRepository;

	
	 @Autowired
	 private BookRepository bookRepository;
	 
	 @Autowired
	 private MemberRepository memberRepository;
	 
	
	public Checkout checkoutBook(@PathVariable String bookId, @PathVariable int userId) {
		
		Book book = bookRepository.findById(bookId).get();
		book.setCount(book.getCount()-1);
		bookRepository.save(book);
		
		Member member  = memberRepository.findById(userId).get();
		
		
		Date date = new Date();
		long ltime=date.getTime()+7*24*60*60*1000;
		  
		Date estimate = new Date(ltime);
		
		
		//set default return date to 7 days after.
		Checkout entry = Checkout.builder() 
									.member(member)
									.book(book)
									.estimatedReturnDate(estimate)
									.build();
									
		
		
		
	
		return checkoutRepository.save(entry);
	}	
	
	public Checkout returnBook(int checkoutId, String bookId) {
		
		//can return at any time.
		Date returnDate = new Date();
		
		Checkout entry = checkoutRepository.findById(checkoutId).get();
		entry.setEstimatedReturnDate(returnDate);
		
		Book book = bookRepository.findById(bookId).get();
		book.setCount(book.getCount()+1);
		bookRepository.save(book);
		
		return checkoutRepository.save(entry);
	}

}
