package com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entities.MyBooks;
@Repository
public interface MyBooksRepository extends JpaRepository<MyBooks, Long> {
	
	

}
