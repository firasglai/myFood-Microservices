package com.firas.restaurant.controller;

import com.firas.restaurant.model.Menu;
import com.firas.restaurant.model.Address;
import com.firas.restaurant.service.MenuService;
import com.firas.restaurant.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final MenuService menuService;
    private final AddressService addressService;


    // Menu Endpoints
    @PostMapping("/menus")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMenu(@RequestBody Menu menu) {
        menuService.saveMenu(menu);
    }

    @GetMapping("/menus")
    public ResponseEntity<List<Menu>> getAllMenus() {
        return ResponseEntity.ok(menuService.getAllMenus());
    }

    @GetMapping("/menus/{keyword}")
    public ResponseEntity<List<Menu>> findMenusByKeyword(@PathVariable String keyword) {
        return ResponseEntity.ok(menuService.findMenusByKeyword(keyword));
    }

    // Address Endpoints

    @PostMapping("/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAddress(@RequestBody Address address) {
        addressService.saveAddress(address);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/addresses/{ville}")
    public ResponseEntity<List<Address>> findAddressesByCivility(@PathVariable String ville) {
        return ResponseEntity.ok(addressService.findAddressesByVille(ville));
    }





}