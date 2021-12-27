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
		public void saveCustomer(Customer customer) {
			customerRepo.save(customer);
		}
		
		@Override
		public List<Customer> findAllCustomers(){
			return customerRepo.findAll();
		}
}
