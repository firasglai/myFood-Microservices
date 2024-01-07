package com.firas.order.dto;

import com.firas.order.model.DeliveryInfo;
import com.firas.order.model.Order;
import com.firas.order.model.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FullOrder {
    private Order order;
    private DeliveryInfo deliveryInfo;
    private List<OrderItems> orderItemsList;
}
