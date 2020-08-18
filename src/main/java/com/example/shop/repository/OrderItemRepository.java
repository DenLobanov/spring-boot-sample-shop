package com.example.shop.repository;

import com.example.shop.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

	List<OrderItem> findByIdOrder(Long idOrder);
}
