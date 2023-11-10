package com.onlinepizza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinepizza.entity.PizzaOrder;


@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer> {

	PizzaOrder findBybookingOrderId(Integer pizzaOrderId);
	
	
//	@Query("select p from Product p where p.stock> :stk")  // custome querry
//	public List<PizzaOrder> findByDate(int stk);
   
//	List<PizzaOrder> findByCustomer(Customer customer); // check once
}
