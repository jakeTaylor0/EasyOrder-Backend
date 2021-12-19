package com.dnd.eorderservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.eorderservices.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
