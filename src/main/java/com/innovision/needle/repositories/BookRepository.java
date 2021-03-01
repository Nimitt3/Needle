package com.innovision.needle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innovision.needle.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{
		
	 	@Query("SELECT b FROM Book b WHERE b.name = ?1")
		List<Book> findByBookName(String bookName);
	
	 	
	 	@Query("SELECT b FROM Book b WHERE b.authorName = ?1")
		List<Book> findByAuthorName(String authorName);
	 	
		@Query("SELECT b FROM Book b WHERE  b.name = ?1 AND b.authorName = ?2")
		List<Book> findByBookAndAuthor(String bookName, String authorName);
	 	
		
		@Query("SELECT b FROM Book b WHERE  b.book_id = ?1 AND b.count > 0")
		Book checkAvailability(String bookId);
	 	
}
