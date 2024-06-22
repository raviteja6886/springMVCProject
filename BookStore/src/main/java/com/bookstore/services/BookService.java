package com.bookstore.services;

import java.util.List;

import com.bookstore.entities.Book;

public interface BookService {
	List<Book> showBookList();
	Book saveBook(Book book);
	Book getBookById(Long id);
	Book updateBook(Book book);
	void deleteBook(Long id);

}
