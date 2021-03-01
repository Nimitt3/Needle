package com.innovision.needle.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Book {

	@Id
	@Column(name="book_id")
	private String id;
	
	private String name;
	
	private int count;
	
	private String authorName;
	
}
