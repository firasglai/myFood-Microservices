package com.firas.kitchen.repository;

import com.firas.kitchen.model.LineItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemsRepository extends JpaRepository<LineItems,Integer> {
}
