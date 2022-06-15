package com.dnd.eorderservices.dao;

import java.util.List;

import com.dnd.eorderservices.model.Order;

public interface OrderDAO {
	
	Order addOrder(Order order);
	
	List<Order> findAllOrders();
	
	Order getOrderById(long id);

	List<Order> orderHistory(long customerId);

}
