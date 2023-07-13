package com.example.bookEstore.dao;

import com.example.bookEstore.model.Customer;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	private final static String SQL_ADD_CUST = "insert into customer (fname,lname,addrs,email,pass)  values(?,?,?,?,?)";
	private final static String SQL_SRCH_CUST_BYEMAIL= "select pass from customer where email=?";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int addCustomer(Customer customer) {
		int noOfRow = jdbcTemplate.update(SQL_ADD_CUST, customer.getFirstName(), customer.getLastName(),
				customer.getAddress(), customer.getEmail(), customer.getPassword());

		return noOfRow;
	}

	@Override
	public String loginCustomer(String email, String pass) {
		
		return jdbcTemplate.queryForObject(SQL_SRCH_CUST_BYEMAIL,String.class,email);
	      
	}

}
