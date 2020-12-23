package com.grupouno.teatro.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

  TicketRepository repository;

  @Autowired
  public void setRepository(TicketRepository repository) {
    this.repository = repository;
  }


}
