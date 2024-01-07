package com.firas.order.repository;

import com.firas.order.model.DeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo,Integer> {
}
