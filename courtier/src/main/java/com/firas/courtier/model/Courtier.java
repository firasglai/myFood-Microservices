package com.firas.courtier.model;

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
public class Courtier {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer cin;
    private Integer telephone;
    private Boolean isAvailable;



}
