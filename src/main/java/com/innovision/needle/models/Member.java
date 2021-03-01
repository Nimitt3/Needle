package com.innovision.needle.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@OneToMany(mappedBy="member")
	@JsonManagedReference
	private List<Checkout> checkout;
	
	
}
