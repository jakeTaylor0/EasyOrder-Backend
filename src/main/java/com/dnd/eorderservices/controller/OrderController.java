package com.dnd.eorderservices.controller;

import java.util.List;

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
import com.dnd.eorderservices.service.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order-services")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/allOrders")
	public List<Order> getAllOrders(){
		return this.orderService.findAllOrders();  
	}
	
	@PostMapping("/saveOrder")
	public ResponseEntity<Object> saveOrder(@RequestBody Order order){
		Order o = orderService.addOrder(order);
		return new ResponseEntity<Object>(orderService.addOrder(order), HttpStatus.OK);
	}
	
	@GetMapping("/orderHistory")
	public ResponseEntity<Object> orderHistory(@RequestParam(name = "customerId") long customerId){
		return new ResponseEntity<Object>(orderService.orderHistory(customerId), HttpStatus.OK);
	}
}
