package com.bookstore.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.entitiy.Book;
import com.bookstore.exception.BookNotFoundException;
import com.bookstore.services.BookService;

@Controller
@RequestMapping("/")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	Logger logger=LoggerFactory.getLogger(BookController.class);
	
	
	@GetMapping("/home")
	public String home() {
		logger.info("successfully home page initialized");
		return "home-page";
	}
	@GetMapping("/booksList")
	public String showBooks(Model m) {
		
		
		List<Book> list;
		try {
			list = bookService.showBookList();
			
			m.addAttribute("books", list);
			
			logger.info("Books are retrieved from database successfully");
			
			return "booksList";
		
		} catch (BookNotFoundException e) {
			
			
			logger.error(e.getMessage()+e);
			
			m.addAttribute("error",Boolean.TRUE);
			return "booksList";
		}
		
	}
	@GetMapping("/booksList/new")
	public String addBook(Model m) {
		Book book = new Book();
		m.addAttribute("book", book);
		return "addbook";
	}
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book")Book book) {
		
		bookService.saveBook(book);
	
		return "redirect:/booksList";
	}
	@GetMapping("/booksList/edit/{id}")
	public String getBookById(@PathVariable Long id,Model m) {
		
		Book book=bookService.getBookById(id);
		
		m.addAttribute("book",book );
		
		return "editBook";
	}
	@PostMapping("/booksList/{id}")
	public String updateBook(@PathVariable Long id,@ModelAttribute("book")Book book) {
		
		bookService.saveBook(book);
		
		logger.info(book.getBookName()+"   book is updated successfully");
		
		return "redirect:/booksList";
		
	}
	@GetMapping("/booksList/{id}")
	public String deleteBook(@PathVariable Long id) {
		
		bookService.deleteBook(id);
		
		logger.warn(" book is deleted successfully");
		
		return "redirect:/booksList";
	}
	public String getByAuthorName(@PathVariable String name) {
		
		
		return "authors-bookList";
	}
	
}
