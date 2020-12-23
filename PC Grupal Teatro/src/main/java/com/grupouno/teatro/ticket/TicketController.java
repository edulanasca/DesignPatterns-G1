package com.grupouno.teatro.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

  TicketRepository ticketRepository;

  @Autowired
  public void setTicketRepository(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  @PostMapping
  public Ticket generarTicket(@RequestBody Cliente cliente) {

    // El objeto se guardará en la BD con nombre test en mongo
    // El json ejemplo de POST esta en resources/templates/cliente.json
    return ticketRepository.save(new FacadeTicket(cliente).generarTicket());
  }
}
