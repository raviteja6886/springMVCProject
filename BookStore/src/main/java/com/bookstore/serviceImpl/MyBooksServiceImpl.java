package com.bookstore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entities.Book;
import com.bookstore.entities.MyBooks;
import com.bookstore.repositories.BookRepository;
import com.bookstore.repositories.MyBooksRepository;
import com.bookstore.services.MyBooksService;

@Service
public class MyBooksServiceImpl implements MyBooksService {

	@Autowired
	private MyBooksRepository myBooksRepo;
	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public MyBooks saveBook(Long id) {
		Book book = bookRepo.findById(id).get();
		MyBooks b = new MyBooks();
		b.setId(book.getId());
		b.setBookName(book.getBookName());
		b.setAuthorName(book.getAuthorName());
		b.setPrice(book.getPrice());
		
		return myBooksRepo.save(b);
	}

	@Override
	public List<MyBooks> getMyBooks() {
		
		return myBooksRepo.findAll();
	}

	@Override
	public void deleteMyBook(Long id) {
		
		
		MyBooks book=myBooksRepo.findById(id).get();
		
		myBooksRepo.deleteById(book.getId());
		
	}
}
