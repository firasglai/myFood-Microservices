package com.firas.kitchen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineItems {
    @Id
    @GeneratedValue
    private Integer id ;
    private Integer quantity;
    //Restaurant Related
    private Integer idMenu;
    //ticket related
    private Integer idTicket;


}
