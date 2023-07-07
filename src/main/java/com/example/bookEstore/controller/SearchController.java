package com.example.bookEstore.controller;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.bookEstore.model.Book;
import com.example.bookEstore.service.BookService;

@Controller
public class SearchController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/search")
	public String search() {
		LOGGER.info("Sucessfully retuned searchpage");
		return "searchpage";
	}
	
	@RequestMapping("/searchhandler")
	
	public String searchhandler(
			Model model,
			@RequestParam("filter") String filter, 
			@RequestParam("query") String query
			) {
		
		System.out.println(filter);
		List<Book> bookList= new ArrayList<>();
		
		if(filter.equals("title")) {
			bookList = bookService.searchBookByName(query);
			
		}
		else {
			bookList = bookService.searchBookByAuthor(query);
		}
		
		model.addAttribute("booklist",bookList);
		return "searchpage";
	}
}
