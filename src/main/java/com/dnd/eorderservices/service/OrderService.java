package com.dnd.eorderservices.service;

import java.util.List;

import com.dnd.eorderservices.model.Order;

public interface OrderService {
	
	Order addOrder(Order order);
	
	List<Order> findAllOrders();
	
	Order getOrderById(long id);

}
