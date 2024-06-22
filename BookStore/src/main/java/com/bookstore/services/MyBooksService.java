package com.bookstore.services;

import java.util.List;

import com.bookstore.entities.MyBooks;

public interface MyBooksService {
	
	
	MyBooks saveBook(Long id);

	List<MyBooks> getMyBooks();
	
	void deleteMyBook(Long id);

}
