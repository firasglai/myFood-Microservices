package com.firas.courtier.service;

import com.firas.courtier.model.Courtier;
import com.firas.courtier.repository.CourtierRepository;
import com.firas.courtier.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourtierService {
    private final CourtierRepository courtierRepository;
    private final LocationRepository locationRepository;


    public void createCourtier(Courtier courtier) {
        courtierRepository.save(courtier);
    }

    public Optional<Courtier> getCourtierById(Integer id) {
        return courtierRepository.findById(id);
    }

    public List<Courtier> getAllCourtiers() {
        return courtierRepository.findAll();
    }


    public void updateCourtier(Courtier updatedCourtier) {
        Integer id = updatedCourtier.getId();
        Optional<Courtier> existingCourtier = courtierRepository.findById(id);

        if (existingCourtier.isPresent()) {
            Courtier courtierToUpdate = existingCourtier.get();
            // Update fields as needed
            courtierToUpdate.setCin(updatedCourtier.getCin());
            courtierToUpdate.setTelephone(updatedCourtier.getTelephone());
            courtierToUpdate.setIsAvailable(updatedCourtier.getIsAvailable());
            // Save the updated courtier
            courtierRepository.save(courtierToUpdate);
        } else {
            // Handle the case where the courtier with the given ID is not found
            throw new IllegalArgumentException("Courtier with ID " + id + " not found");
        }
    }

    public void deleteCourtierById(Integer id) {
        courtierRepository.deleteById(id);
    }


}
