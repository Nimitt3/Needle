package com.innovision.needle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovision.needle.models.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Integer>{
		
	

}


