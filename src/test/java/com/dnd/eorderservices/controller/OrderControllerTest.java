package com.dnd.eorderservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.dnd.eorderservices.model.Order;
import com.dnd.eorderservices.service.OrderService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderControllerTest {

	@InjectMocks
	private OrderController orderController;
	
	@Mock
	private OrderService orderService;
	
	@Test
	public void testAllOrders() {
		List<Order> orderList = new ArrayList<Order>();
		Order o1 = new Order();
		o1.setOrderId(1L);
		orderList.add(o1);
		Mockito.when(orderService.findAllOrders()).thenReturn(orderList);
		orderController.getAllOrders();
	}
	
	@Test
	public void testSaveOrder() {
		Order o1 = new Order();
		Mockito.when(orderService.addOrder(o1)).thenReturn(o1);
		orderController.saveOrder(o1);
	}
	
	@Test
	public void testOrderHistoryWithOrder() {
		List<Order> orderList = new ArrayList<Order>();
		Order o1 = new Order();
		o1.setOrderId(1L);
		orderList.add(o1);
		Mockito.when(orderService.orderHistory(Mockito.anyLong())).thenReturn(orderList);
		orderController.orderHistory(1L);
	}
	
	@Test
	public void testOrderHistoryWithoutOrder() {
		List<Order> orderList = new ArrayList<Order>();
		Mockito.when(orderService.orderHistory(Mockito.anyLong())).thenReturn(orderList);
		orderController.orderHistory(1L);
	}
	
	@Test(expected = Exception.class)
	public void testSaveOrderWithException() throws Exception{
		Mockito.when(orderService.addOrder(Mockito.any())).thenThrow(new Exception());
		orderController.saveOrder(Mockito.any());
	}
}
