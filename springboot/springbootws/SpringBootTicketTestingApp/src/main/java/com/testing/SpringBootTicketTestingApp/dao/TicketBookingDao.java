package com.testing.SpringBootTicketTestingApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testing.SpringBootTicketTestingApp.entities.Ticket;


@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{
	Ticket findByEmail(String email);
}
