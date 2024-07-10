package com.bookstore.services;

import java.util.List;

import com.bookstore.entitiy.Book;
import com.bookstore.exception.BookNotFoundException;

public interface BookService {
	List<Book> showBookList() throws BookNotFoundException;
	Book saveBook(Book book);
	Book getBookById(Long id);
	Book updateBook(Book book);
	void deleteBook(Long id);

}
