package com.firas.kitchen.service;

import com.firas.kitchen.model.LineItems;
import com.firas.kitchen.repository.LineItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineItemsService {

    private final LineItemsRepository lineItemsRepository;

    public LineItems createLineItems(LineItems lineItems) {
        return lineItemsRepository.save(lineItems);
    }

    // Add more methods as needed...

    public List<LineItems> getAllLineItems() {
        return lineItemsRepository.findAll();
    }

    public LineItems getLineItemsById(Long lineItemsId) {
        return lineItemsRepository.findById(Math.toIntExact(lineItemsId))
                .orElseThrow(() -> new RuntimeException("LineItems not found with id: " + lineItemsId));
    }
}
