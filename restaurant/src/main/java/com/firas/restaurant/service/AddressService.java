package com.firas.restaurant.service;

import com.firas.restaurant.model.Address;
import com.firas.restaurant.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }



    public List<Address> findAddressesByVille(String ville) {
        return addressRepository.findAllByVille(ville);
    }
}
