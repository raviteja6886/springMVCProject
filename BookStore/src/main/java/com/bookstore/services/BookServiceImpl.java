package com.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entitiy.Book;
import com.bookstore.exception.BookNotFoundException;
import com.bookstore.repositories.BookRepository;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public List<Book> showBookList() throws BookNotFoundException{
		
		List<Book>list=bookRepo.findAll();
		if(list.isEmpty()) {
			 
			throw new BookNotFoundException("No books are available.......");
		}
		
		return list;
	}
	@Override
	public Book saveBook(Book book) {
		
		return bookRepo.save(book);
	}
	@Override
	public Book getBookById(Long id) {
		
		return bookRepo.findById(id).get();
	}
	@Override
	public Book updateBook(Book book) {
		
		Book oldbook=bookRepo.findById(book.getId()).get();
		
		oldbook.setId(book.getId());
		oldbook.setBookName(book.getBookName());
		oldbook.setPrice(book.getPrice());
		oldbook.setAuthorName(book.getAuthorName());
		
		
		return bookRepo.save(book);
	}
	@Override
	public void deleteBook(Long id){
		
		bookRepo.deleteById(id);
		
	}


}
