package com.innovision.needle.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Checkout {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="checkout_id")
	private int id;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="member_id")
	private Member member;
	
	@OneToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)  
    @CreatedDate 
    @NotNull
	private Date borrowedAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date estimatedReturnDate;
	
	private Date returnedDate;
	
	
	 
	
	
}
