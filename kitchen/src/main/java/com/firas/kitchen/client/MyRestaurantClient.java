package com.firas.kitchen.client;

import org.springframework.stereotype.Component;

@Component
public class MyRestaurantClient implements RestaurantClient {
    @Override
    public void notifyDeliveryTime(Long ticketId, int deliveryTime) {
        // Your implementation here
        System.out.println("Notifying client about delivery time for ticket " + ticketId + ": " + deliveryTime + " minutes");
    }
}
