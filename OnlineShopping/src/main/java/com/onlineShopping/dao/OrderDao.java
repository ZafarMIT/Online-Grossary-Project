package com.onlineShopping.dao;

import java.util.List;

import com.onlineShopping.pojo.Order;

public interface OrderDao {

	boolean addOrder(Order order);
	List<Order> getAllOrder();
	
	List<Order> getOrderByUser(String userName);
	
	boolean deleteOrder(int orderId);
	
	
}
