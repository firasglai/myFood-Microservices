package com.firas.courtier.repository;

import com.firas.courtier.model.Courtier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtierRepository extends JpaRepository<Courtier,Integer> {
}
