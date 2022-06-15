package com.dnd.eorderservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dnd.eorderservices.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

	@Query("select o from Order o where o.customerId =:customerId")
	List<Order> orderHistory(@Param("customerId") Long customerId);

}
