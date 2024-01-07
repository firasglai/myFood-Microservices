package com.firas.kitchen.model;

import com.firas.kitchen.enums.State;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    //Comes from the Client Order
    @Id
    @GeneratedValue
    private Integer id;
    private State state;
    private Integer restaurantId;
    private Integer preparingTime;
    private LocalDateTime pickedUpTime;
}
