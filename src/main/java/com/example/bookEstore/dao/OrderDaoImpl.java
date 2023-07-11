package com.example.bookEstore.dao;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bookEstore.model.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	private final static String SQL_PLACE_ORDER= "insert into orderbook (email,barcode,bookname,author,quantity,orderdate,ordertime,deliverydate) select email ,b.barcode,b.bookname, b.author, count(c.quantity),current_date(),CAST(CURRENT_TIMESTAMP() AS time),adddate(current_date(),7)  from book b inner join central_cart c on c.barcode=b.barcode group by b.barcode, b.bookname, b.author,email having c.email=?";
	private final static String SQL_VIEW_ORDER="select barcode,bookname,author,sum(quantity)as quantity,email,orderdate,ordertime,deliverydate from orderbook group by  barcode,bookname,author,email,orderdate,ordertime,deliverydate having email=?";
	private final static String SQL_CANCEL_ITEM="delete from orderbook where email=? and orderdate=? and ordertime=? and barcode=?";
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int placeOrder(String email) {
		int noOfRow = jdbcTemplate.update(SQL_PLACE_ORDER,email);
		return noOfRow;
	}
	@Override
	public List<Order> viewOrder(String email) {
		List<Order> orders = jdbcTemplate.query(SQL_VIEW_ORDER,(rs,rowNum)->{
																		Order order = new Order();
																		order.setEmail(rs.getString("email"));
																		order.setBarcode(rs.getString("barcode"));
																		order.setBookName(rs.getString("bookname"));
																		order.setAuthor(rs.getString("author"));
																		order.setQuantity(rs.getInt("quantity"));
																		order.setOrderValue(0.0);
																		order.setOrderDate(rs.getDate("orderdate"));
																		order.setDeliveryDate(rs.getDate("deliverydate"));
																		order.setOrderTime(rs.getString("ordertime"));
																		return order;
																		},email);
		return orders;
	}
	@Override
	public int cancelItem(String email, Date orderDate, String orderTime, String barcode) {
		
		int noOfRow = jdbcTemplate.update(SQL_CANCEL_ITEM,email,orderDate,orderTime,barcode);
		return noOfRow;
	}

}
