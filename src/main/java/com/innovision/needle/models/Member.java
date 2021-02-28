package com.innovision.needle.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_id")
	private int id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="user_checkout",
				joinColumns=@JoinColumn(name="member_id"),
				inverseJoinColumns=@JoinColumn(name="checkout_id")
			) 
	private List<Checkout> checkout;
	
	
}
