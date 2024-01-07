package com.firas.order.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "restaurant-service" , url = "${application.config.restaurant-url}")
public interface RestaurantClient {

}
