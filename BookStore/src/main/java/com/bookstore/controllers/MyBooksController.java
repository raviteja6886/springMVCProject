package com.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookstore.services.MyBooksService;

@Controller
public class MyBooksController {

	@Autowired
	private MyBooksService service;
	
	

	@GetMapping("/myBooks")
	public String getMyBooks(Model model) {

		model.addAttribute("myBooks", service.getMyBooks());

		return "/myBooks-page";
	}

	@GetMapping("/saveBook/{id}")
	public String saveBook(@PathVariable Long id) {

		service.saveBook(id);

		return "redirect:/myBooks";
	}

	@GetMapping("/myBooks/{id}")
	public String deleteBook(@PathVariable Long id) {
		
		service.deleteMyBook(id);
		return "redirect:/myBooks";
	}

}
