package com.firas.kitchen.controller;

import com.firas.kitchen.model.LineItems;
import com.firas.kitchen.model.Ticket;
import com.firas.kitchen.service.LineItemsService;
import com.firas.kitchen.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kitchen")
@RequiredArgsConstructor
public class KitchenController {

    private final TicketService ticketService;
    private final LineItemsService lineItemsService;

    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.ok(createdTicket);
    }

    @PatchMapping("/tickets/{ticketId}/accept")
    public ResponseEntity<Void> acceptTicket(@PathVariable Integer ticketId) {
        ticketService.acceptTicket(ticketId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/tickets/{ticketId}/ready")
    public ResponseEntity<Void> readyForPickUp(@PathVariable Integer ticketId) {
        ticketService.readyForPickUp(ticketId);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/tickets/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Integer ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/lineitems")
    public ResponseEntity<List<LineItems>> getAllLineItems() {
        List<LineItems> lineItems = lineItemsService.getAllLineItems();
        return ResponseEntity.ok(lineItems);
    }
}
