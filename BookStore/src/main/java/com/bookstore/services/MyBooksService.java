package com.bookstore.services;

import java.util.List;

import com.bookstore.entitiy.MyBooks;
import com.bookstore.exception.BookNotFoundException;

public interface MyBooksService {
	
	
	MyBooks saveBook(Long id) ;

	List<MyBooks> getMyBooks() throws BookNotFoundException;
	
	void deleteMyBook(Long id);

}
