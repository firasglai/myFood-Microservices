package com.firas.courtier.controller;

import com.firas.courtier.model.Courtier;
import com.firas.courtier.model.Location;
import com.firas.courtier.service.CourtierService;
import com.firas.courtier.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courtier")
@RequiredArgsConstructor
public class CourtierController {

private final CourtierService courtierService;
private final LocationService locationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourtier(@RequestBody Courtier courtier) {
        courtierService.createCourtier(courtier);
    }
    @PutMapping("/{id}")
    public void updateCourtier(@PathVariable Integer id, @RequestBody Courtier updatedCourtier) {
        courtierService.updateCourtier(id, updatedCourtier);
    }
    @GetMapping
    public ResponseEntity<List<Courtier>> getAllCourtiers() {
        List<Courtier> courtiers = courtierService.getAllCourtiers();
        return ResponseEntity.ok(courtiers);
    }

    @PostMapping("/location")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLocation(@RequestBody Location location) {
        locationService.create(location);
    }

    @PutMapping("/location/{id}")
    public void updateLocation(@PathVariable Integer id, @RequestBody Location updatedLocation) {
        locationService.updateLocation(id, updatedLocation);
    }
    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }

}
