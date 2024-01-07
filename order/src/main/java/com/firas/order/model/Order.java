package com.firas.order.model;

import com.firas.order.enums.State;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    @Enumerated(EnumType.STRING)
    private State state;
    //client Id
    private Integer consumerId;
    //restaurant
    private Integer restaurantId;

    @OneToOne(mappedBy = "idOrder", cascade = CascadeType.ALL)
    private DeliveryInfo deliveryInfo;
}
