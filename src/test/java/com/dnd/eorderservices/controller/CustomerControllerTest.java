package com.dnd.eorderservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.platform.commons.logging.Logger;
import com.dnd.eorderservices.model.Customer;
import com.dnd.eorderservices.service.CustomerService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerControllerTest {
	
	@InjectMocks
	private CustomerController customerController;
	
	@Mock
	private CustomerService customerService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerControllerTest.class);
	
	@Test
	public void testAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("1231231234");
		customerList.add(c1);
		Mockito.when(customerService.findAllCustomers()).thenReturn(customerList);
		customerController.getAllCustomers();
	}
	
	@Test
	public void testGetCustomerByIdWithValidId() {
		Customer c1 = new Customer();
		c1.setCustomerId(1);
		c1.setName("John Doe");
		c1.setPhone("1231231234");
		Mockito.when(customerService.getCustomerById(Mockito.anyString())).thenReturn(c1);
		customerController.getCustomerById(Mockito.anyString());
	}
	
	@Test
	public void testGetCustomerByIdWithInvalidId() {
		Mockito.when(customerService.getCustomerById(Mockito.anyString())).thenReturn(null);
		customerController.getCustomerById(Mockito.anyString());
	}
	
	@Test
	public void testSaveCustomerNewCustomer() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("1231231234");
		Mockito.when(customerService.getCustomerByPhone(Mockito.anyString())).thenReturn(null);
		Mockito.when(customerService.addCustomer(Mockito.any())).thenReturn(c1);
		customerController.saveCustomer(c1);
	}
	
	@Test
	public void testSaveCustomerWithNoDetails() {
		Customer c1 = new Customer();
		c1.setCustomerId(0);
		c1.setName("");
		c1.setPhone("");
		Mockito.when(customerService.getCustomerByPhone(Mockito.anyString())).thenReturn(null);
		Mockito.when(customerService.addCustomer(Mockito.any())).thenReturn(c1);
		customerController.saveCustomer(c1);
	}
	
	@Test
	public void testSaveCustomerExistingCustomer() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("1231231234");
		Mockito.when(customerService.getCustomerByPhone(Mockito.anyString())).thenReturn(c1);
		Mockito.when(customerService.addCustomer(Mockito.any())).thenReturn(c1);
		customerController.saveCustomer(c1);
	}
	
	@Test
	public void testSaveCustomerExistingCustomerUpdateName() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("1231231234");
		
		Customer c2 = new Customer();
		c2.setCustomerId(1L);
		c2.setName("Jane Doe");
		c2.setPhone("1231231234");
		
		Mockito.when(customerService.getCustomerByPhone(Mockito.anyString())).thenReturn(c1);
		Mockito.doNothing().when(customerService).updateCustomer(c2);
		customerController.saveCustomer(c2);
	}
	
	@Test
	public void testGetCustomerByPhone() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("1231231234");
		
		Mockito.when(customerService.getCustomerByPhone(Mockito.anyString())).thenReturn(c1);
		customerController.getCustomerByPhone(c1.getPhone());
	}
	
	@Test
	public void testGetCustomerByPhoneWithInvalidPhone() {	
		Mockito.when(customerService.getCustomerByPhone(Mockito.anyString())).thenReturn(null);
		customerController.getCustomerByPhone(Mockito.anyString());
	}

	@Test
	public void testUpdateCustomer() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("1231231234");
		Mockito.doNothing().when(customerService).updateCustomer(c1);
		customerController.updateCustomerNameByPhone(c1);
	}
}
