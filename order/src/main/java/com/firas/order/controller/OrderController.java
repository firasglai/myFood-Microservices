package com.firas.order.controller;

import com.firas.order.dto.FullOrder;
import com.firas.order.model.Order;
import com.firas.order.service.DeliveryInfoService;
import com.firas.order.service.OrderItemsService;
import com.firas.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final DeliveryInfoService deliveryInfoService;
    private final OrderItemsService orderItemsService;


    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody FullOrder createOrderRequest) {
        Order savedOrder = orderService.saveOrder(
                createOrderRequest.getOrder(),
                createOrderRequest.getDeliveryInfo(),
                createOrderRequest.getOrderItemsList()
        );
        return ResponseEntity.ok(savedOrder);
    }
    @PostMapping("/cancel/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Integer orderId) {
        orderService.cancelOrderById(orderId);
        return ResponseEntity.ok("Order canceled successfully");
    }

    @PutMapping("/revise/{orderId}")
    public ResponseEntity<String> reviseOrder(@PathVariable Integer orderId, @RequestBody FullOrder revisedFullOrder) {
        orderService.reviseOrder(orderId, revisedFullOrder);
        return ResponseEntity.ok("Order revised successfully");
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAllOrders() {
        return ResponseEntity.ok(orderService.findAllOrders());
    }

}
