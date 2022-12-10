package com.dnd.eorderservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.dnd.eorderservices.model.Order;
import com.dnd.eorderservices.repository.OrderRepo;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderDAOImplTest {
	@InjectMocks
	private OrderDAOImpl orderDAO;
	
	@Mock
	private OrderRepo orderRepo;
	
	@Test
	public void testAddOrder() {
		Order o1 = new Order();
		o1.setOrderId(1L);
		
		Mockito.when(orderRepo.save(o1)).thenReturn(o1);
		orderDAO.addOrder(o1);
	}
	
	@Test
	public void testOrderHistory() {
		List<Order> orderHistory = new ArrayList<>();
		Order o1 = new Order();
		o1.setOrderId(1L);
		orderHistory.add(o1);
		Mockito.when(orderRepo.orderHistory(Mockito.anyLong())).thenReturn(orderHistory);
		orderDAO.orderHistory(Mockito.anyLong());
	}
}
