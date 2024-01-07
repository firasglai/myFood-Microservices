package com.firas.restaurant.repository;

import com.firas.restaurant.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    List<Address> findAllByVille(String ville);
}
