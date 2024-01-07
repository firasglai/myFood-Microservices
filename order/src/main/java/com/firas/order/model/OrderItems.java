package com.firas.order.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer quantity;
    //restaurant
    private Integer idMenu;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
