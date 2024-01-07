package com.firas.order.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "delivery_info")
public class DeliveryInfo {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime deliveryTime;
    private String deliveryAddress;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order idOrder;
}
