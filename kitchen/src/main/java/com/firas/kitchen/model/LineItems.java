package com.firas.kitchen.model;

import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;
}
