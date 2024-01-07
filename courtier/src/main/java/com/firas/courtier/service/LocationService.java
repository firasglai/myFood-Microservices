package com.firas.courtier.service;

import com.firas.courtier.model.Location;
import com.firas.courtier.repository.LocationRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;


    public void create(Location location){
        locationRepository.save(location);
    }


    public Optional<Location> getById(Integer id) {
        return locationRepository.findById(id);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public void updateLocation(Integer id, Location updatedLocation) {
        Optional<Location> existingLocation = locationRepository.findById(id);

        if (existingLocation.isPresent()) {
            Location locationToUpdate = existingLocation.get();
            // Update fields as needed
            locationToUpdate.setLongitude(updatedLocation.getLongitude());
            locationToUpdate.setLatitude(updatedLocation.getLatitude());
            // Save the updated location
            locationRepository.save(locationToUpdate);
        }
        else {
            throw new IllegalArgumentException("Location with ID " + id + " not found");
        }
    }

    public void deleteById(Integer id) {
        locationRepository.deleteById(id);
    }

}
