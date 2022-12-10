package com.dnd.eorderservices.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.dnd.eorderservices.dao.OrderDAO;
import com.dnd.eorderservices.model.Order;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderServiceImplTest {
	@InjectMocks
	private OrderServiceImpl orderService;
	
	@Mock
	private OrderDAO orderDAO;
	
	@Test
	public void testAddOrder() {
		Order o1 = new Order();
		o1.setOrderId(1L);
		Mockito.when(orderDAO.addOrder(o1)).thenReturn(o1);
		orderService.addOrder(o1);
	}
	
	@Test
	public void testOrderHistory() {
		List<Order> orderHistory = new ArrayList<>();
		Order o1 = new Order();
		o1.setOrderId(1L);
		orderHistory.add(o1);
		Mockito.when(orderService.orderHistory(Mockito.anyLong())).thenReturn(orderHistory);
		orderService.orderHistory(Mockito.anyLong());
	}
}
