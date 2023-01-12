package com.dnd.eorderservices.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dnd.eorderservices.model.Order;
import com.dnd.eorderservices.repository.OrderRepo;

@Service("OrderDAO")
@Repository
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public Order addOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public List<Order> findAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(long id) {
		return orderRepo.findById(id);
	}

	@Override
	public List<Order> orderHistory(long customerId) {
		return orderRepo.orderHistory(customerId);
	}
}
