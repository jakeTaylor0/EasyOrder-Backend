package com.dnd.eorderservices.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.dnd.eorderservices.model.Customer;
import com.dnd.eorderservices.repository.CustomerRepo;

@Service("CustomerDAO")
@Repository
public class CustomerDAOImpl implements CustomerDAO {

		@Autowired
		private CustomerRepo customerRepo;
		
		@Override
		public Customer saveCustomer(Customer customer) {
			return customerRepo.save(customer);
		}
		
		@Override
		public List<Customer> findAllCustomers(){
			return customerRepo.findAll();
		}

		@Override
		public Customer getCustomerById(String customerId) {
			long id = Long.parseLong(customerId);
			return customerRepo.findById(id).get();
		}


		@Override
		public void updateCustomer(Customer customer) {
			customerRepo.updateCustomer(customer.getName(), customer.getCustomerId());
		}

		@Override
		public Customer getCustomerByPhone(String phone) {
			return customerRepo.findByPhone(phone);
		}
}
