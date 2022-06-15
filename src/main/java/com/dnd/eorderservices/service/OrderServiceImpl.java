package com.dnd.eorderservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.eorderservices.dao.OrderDAO;
import com.dnd.eorderservices.model.Order;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public Order addOrder(Order order){
		
		return orderDAO.addOrder(order);
	}

	@Override
	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> orderHistory(long customerId) {
		return orderDAO.orderHistory(customerId);
	}
}
