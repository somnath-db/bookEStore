package com.example.bookEstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookEstore.dao.CentralCartDao;
import com.example.bookEstore.dao.OrderDao;
import com.example.bookEstore.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	private CentralCartDao centralCartDao;

	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao=orderDao;
	}
	@Autowired
	public void setCentralCartDao(CentralCartDao centralCartDao) {
		this.centralCartDao=centralCartDao;
	}
	@Override
	public int placeOrder(String email) {
		int noOfRow = orderDao.placeOrder(email);
		centralCartDao.deleteAllFromCart(email);
		return noOfRow ;
	}
	@Override
	public List<Order> viewOrder(String email) {
		List<Order> orders = orderDao.viewOrder(email);
		return orders;
	}

}
