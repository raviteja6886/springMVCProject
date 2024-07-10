package com.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entitiy.Book;
import com.bookstore.entitiy.MyBooks;
import com.bookstore.exception.BookNotFoundException;
import com.bookstore.repositories.BookRepository;
import com.bookstore.repositories.MyBooksRepository;

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
	public List<MyBooks> getMyBooks() throws BookNotFoundException {
		
		List<MyBooks>myBooksList=myBooksRepo.findAll();
		if(myBooksList.isEmpty()) {
			throw new BookNotFoundException("No books are available");
		}
		return myBooksList;
	}

	@Override
	public void deleteMyBook(Long id) {
		
		
		myBooksRepo.deleteById(id);
		
	}
}
