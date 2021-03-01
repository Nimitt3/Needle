package com.innovision.needle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovision.needle.models.Checkout;
import com.innovision.needle.services.CheckoutService;

@RestController
@RequestMapping("/member")
public class MemberController {
	
		@Autowired
		CheckoutService checkoutService;
	
		@PostMapping("{userId}/checkout/{bookId}")
		public Checkout checkoutBook(@PathVariable String bookId, @PathVariable int userId) {
			
	
			return checkoutService.checkoutBook(bookId, userId);
		}
		
		@PostMapping("/return")
		public Checkout returnBook(@RequestParam("checkoutId") int checkoutId, @RequestParam("bookId") String bookId) {
			
			return checkoutService.returnBook(checkoutId, bookId);
		}
	
}
