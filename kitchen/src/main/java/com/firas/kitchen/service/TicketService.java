package com.firas.kitchen.service;

import com.firas.kitchen.enums.State;
import com.firas.kitchen.model.Ticket;
import com.firas.kitchen.repository.LineItemsRepository;
import com.firas.kitchen.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import com.firas.kitchen.client.RestaurantClient;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final LineItemsRepository lineItemsRepository;
    private final RestaurantClient restaurantClient;

    public Ticket createTicket(Ticket ticket) {
        // Set Ticket State to created by default
        ticket.setState(State.created);
        return ticketRepository.save(ticket);

    }

    public void acceptTicket(Integer ticketId) {
        Ticket ticket = getTicketById(ticketId);
        // Update Ticket State to Accepted
        ticket.setState(State.accepted);
        ticketRepository.save(ticket);
    }

    public void readyForPickUp(Integer ticketId) {
        Ticket ticket = getTicketById(ticketId);
        // Update Ticket State to Ready
        ticket.setState(State.ready);
        ticketRepository.save(ticket);
        restaurantClient.notifyDeliveryTime(Long.valueOf(ticketId), 30);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Integer ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));
    }
}
