package com.innovision.needle.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Checkout {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="checkout_id")
	private int id;
	
	@ManyToMany
	@JoinTable(name="user_checkout",
				joinColumns=@JoinColumn(name="checkout_id"),
				inverseJoinColumns=@JoinColumn(name="member_id")
			) 
	private List<Member> member;
	
	@OneToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	private Date borrowedAt;
	
	private Date estimatedReturnDate;
	
	private Date returnedDate;
	
	
}
