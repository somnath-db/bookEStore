package com.example.bookEstore.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bookEstore.model.Book;
import com.example.bookEstore.dao.BookMapper;

@Repository
public class BookDaoImpl implements BookDao {
	private final static String SQL_SHOW_ALL_BOOKS = "select * from book";
	private final static String SQL_SRCH_BOOK_BY_NAME = "select * from book where bookname like concat('%',?,'%')";
	private final static String SQL_SRCH_BOOK_BY_AUTHOR = "select * from book where author like concat('%',?,'%')";
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Book> searchBookByName(String bookName) {
		List <Book> books = jdbcTemplate.query(SQL_SRCH_BOOK_BY_NAME, new BookMapper(),bookName);
	      return books;
	}
	@Override
	public List<Book> searchBookByAuthor(String bookAuthor) {
		List <Book> books = jdbcTemplate.query(SQL_SRCH_BOOK_BY_AUTHOR, new BookMapper(),bookAuthor);
	      return books;
	}
	@Override
	public List<Book> showAllBooks() {
		List <Book> books = jdbcTemplate.query(SQL_SHOW_ALL_BOOKS, new BookMapper());
	      return books;
	}

}
