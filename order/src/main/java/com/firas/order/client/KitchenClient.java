package com.firas.order.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order-service")
public interface KitchenClient {
}
