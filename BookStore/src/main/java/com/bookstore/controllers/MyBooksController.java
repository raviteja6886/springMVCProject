package com.bookstore.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookstore.entitiy.MyBooks;
import com.bookstore.exception.BookNotFoundException;
import com.bookstore.services.MyBooksService;

@Controller
public class MyBooksController {

	@Autowired
	private MyBooksService service;
	
	Logger logger=LoggerFactory.getLogger(MyBooksController.class);

	@GetMapping("/myBooks")
	public String getMyBooks(Model m) {

		List<MyBooks> list;
		try {
			list = service.getMyBooks();
			
			m.addAttribute("myBooks", list);
			
			logger.info(" My favourite Books are retrieved from database successfully");
			
			return "/myBooks-page";
		
		} catch (BookNotFoundException e) {
			
			
			logger.error(e.getMessage()+e);
			
			m.addAttribute("error",Boolean.TRUE);
			return "/myBooks-page";
		}

	}

	@GetMapping("/saveBook/{id}")
	public String saveBook(@PathVariable Long id) {

		service.saveBook(id);

		return "redirect:/myBooks";
	}

	@GetMapping("/myBooks/{id}")
	public String deleteBook(@PathVariable Long id) {
		System.out.println(id);
		service.deleteMyBook(id);
		return "redirect:/myBooks";
	}

}
	