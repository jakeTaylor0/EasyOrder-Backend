package com.dnd.eorderservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.eorderservices.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
