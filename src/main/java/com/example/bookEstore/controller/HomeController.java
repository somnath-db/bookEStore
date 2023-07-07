package com.example.bookEstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookEstore.model.Book;
import com.example.bookEstore.service.BookService;

@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		LOGGER.info("Sucessfully retuned homepage");
		
		List<Book> bookList = bookService.showAllBooks();
		model.addAttribute("booklist",bookList);
		return "homepage";
	}

}
