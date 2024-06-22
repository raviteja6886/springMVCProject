package com.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookstore.entities.Book;
import com.bookstore.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	

	@GetMapping("/home")
	public String home() {
		return "home-page";
	}
	@GetMapping("/booksList")
	public String showBooks(Model m) {
		
		List<Book> list = bookService.showBookList();
		if (list.size() <= 0) {
			
			String message = "No books are available";
			m.addAttribute("message", message);
			return "booksList";
		} 
		m.addAttribute("books", list);
		return "booksList";
	}
	@GetMapping("/booksList/new")
	public String addBook(Model m) {
		Book book = new Book();
		m.addAttribute("book", book);
		return "addbook";
	}
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book")Book book,Model m) {
		
		bookService.saveBook(book);
		m.addAttribute("message","Book is added successfully");
		return "redirect:/booksList/new";
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
		
		return "redirect:/booksList";
		
	}
	@GetMapping("/booksList/{id}")
	public String deleteBook(@PathVariable Long id) {
		
		bookService.deleteBook(id);
		
		return "redirect:/booksList";
	}
	
}
