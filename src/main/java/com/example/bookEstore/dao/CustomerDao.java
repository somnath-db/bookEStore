package com.example.bookEstore.dao;


import com.example.bookEstore.model.Customer;

public interface CustomerDao {
	int addCustomer(Customer customer);
	String loginCustomer(String email, String pass);
}
