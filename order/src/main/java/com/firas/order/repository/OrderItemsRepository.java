package com.firas.order.repository;

import com.firas.order.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItems,Integer> {
}
