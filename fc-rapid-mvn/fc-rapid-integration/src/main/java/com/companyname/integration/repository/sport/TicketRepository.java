package com.companyname.integration.repository.sport;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyname.persitence.entity.sport.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
