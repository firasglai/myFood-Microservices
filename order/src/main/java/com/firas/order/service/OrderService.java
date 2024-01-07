package com.firas.order.service;

import com.firas.order.dto.FullOrder;
import com.firas.order.enums.State;
import com.firas.order.model.DeliveryInfo;
import com.firas.order.model.Order;
import com.firas.order.model.OrderItems;
import com.firas.order.repository.DeliveryInfoRepository;
import com.firas.order.repository.OrderItemsRepository;
import com.firas.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final DeliveryInfoRepository deliveryInfoRepository;

    public Order saveOrder(Order order, DeliveryInfo deliveryInfo, List<OrderItems> orderItemsList) {
        // Save the order to get the generated ID
        Order savedOrder = orderRepository.save(order);

        // Associate the order with deliveryInfo
        deliveryInfo.setIdOrder(savedOrder);
        deliveryInfoRepository.save(deliveryInfo);

        // Associate the order with orderItems
        for (OrderItems orderItems : orderItemsList) {
            orderItems.setOrder(savedOrder);
            orderItemsRepository.save(orderItems);
        }

        // Return the saved order with associated entities
        return savedOrder;
    }


    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }



    @Transactional
    public void cancelOrderById(Integer orderId) {
        // Retrieve the order by ID
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + orderId));


        // Check if the order is cancellable (you might have additional business logic here)

        // Update the order status to "canceled"
        order.setState(State.canceled);

        // Save the updated order
        orderRepository.save(order);
    }


    @Transactional
    public void reviseOrder(Integer orderId, FullOrder revisedFullOrder) {
        // Retrieve the existing order by ID
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + orderId));

        // Check if the order is in a state that allows revision (add additional business logic if needed)

        // Update the order data with the revised order
        existingOrder.setConsumerId(revisedFullOrder.getOrder().getConsumerId());
        existingOrder.setRestaurantId(revisedFullOrder.getOrder().getRestaurantId());
        // Update other fields as needed

        // Update the delivery info
        DeliveryInfo revisedDeliveryInfo = revisedFullOrder.getDeliveryInfo();
        if (revisedDeliveryInfo != null) {
            existingOrder.getDeliveryInfo().setDeliveryTime(revisedDeliveryInfo.getDeliveryTime());
            existingOrder.getDeliveryInfo().setDeliveryAddress(revisedDeliveryInfo.getDeliveryAddress());
        }

        // Save the updated order
        orderRepository.save(existingOrder);
    }

    public void reviseOrder() {
    }
}
