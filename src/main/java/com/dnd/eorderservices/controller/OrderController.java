package com.dnd.eorderservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.eorderservices.model.Customer;
import com.dnd.eorderservices.model.Order;
import com.dnd.eorderservices.model.Response;
import com.dnd.eorderservices.service.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order-services")
public class OrderController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/allOrders")
	public List<Order> getAllOrders(){
		return this.orderService.findAllOrders();  
	}
	
	@PostMapping("/saveOrder")
	public ResponseEntity<Response> saveOrder(@RequestBody Order order){
		Order o = orderService.addOrder(order);
		try {
			return new ResponseEntity<Response>(new Response("200", "Order Saved Successfully", o), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Response>(new Response("500", "Something went wrong", null), HttpStatus.OK);
		}
		
		
	}
	
	@GetMapping("/orderHistory")
	public ResponseEntity<Response> orderHistory(@RequestParam(name = "customerId") long customerId){
		List<Order> customerOrderHistory = orderService.orderHistory(customerId);
		if(!customerOrderHistory.isEmpty())
			return new ResponseEntity<Response>(new Response("200", "Order history retrieved for customer", customerOrderHistory), HttpStatus.OK);
		else
			return new ResponseEntity<Response>(new Response("404", "No Orders found", customerOrderHistory), HttpStatus.OK);
	}
}
