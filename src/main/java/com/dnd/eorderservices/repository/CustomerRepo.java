package com.dnd.eorderservices.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dnd.eorderservices.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Customer findByPhone(String phone);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Customer c set c.name =:name where c.customerId =:customerId")
	void updateCustomer(@Param("name") String name, @Param("customerId") Long customerId);
}
