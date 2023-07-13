package com.example.bookEstore.service;

import java.util.List;
import java.util.ArrayList;

import com.example.bookEstore.dao.BookDao;
import com.example.bookEstore.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> searchBookByName(String bookName) {

		List<Book> books = bookDao.searchBookByName(bookName);


		return books;
	}

	@Override
	public List<Book> searchBookByAuthor(String bookAuthor) {
		List<Book> books = bookDao.searchBookByName(bookAuthor);

	
		return books;
	}

	@Override
	public List<Book> showAllBooks() {
		List<Book> books = bookDao.showAllBooks();
		return books;
	}

}
