package com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entitiy.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
	
	

}
