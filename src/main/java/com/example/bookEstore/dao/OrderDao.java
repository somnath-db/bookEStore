package com.example.bookEstore.dao;

import java.sql.Date;
import java.util.List;

import com.example.bookEstore.model.Order;

public interface OrderDao {
	int placeOrder(String email);
	int updateQuantityAfterOrderPlace(String email);
	int updateQuantityAfterOrderCancel(String email, Date orderDate, String orderTime, String barcode);
	List<Order> viewOrder(String email);
	int cancelItem(String email,Date orderDate,String orderTime,String barcode);
}
