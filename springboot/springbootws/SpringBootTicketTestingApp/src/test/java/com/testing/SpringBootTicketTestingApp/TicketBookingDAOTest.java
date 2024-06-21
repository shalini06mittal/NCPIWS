package com.testing.SpringBootTicketTestingApp;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.testing.SpringBootTicketTestingApp.dao.TicketBookingDao;
import com.testing.SpringBootTicketTestingApp.entities.Ticket;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TicketBookingDAOTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private TicketBookingDao ticketBookingDao;
	@Test
	public void testSaveTicket()
	{
		Ticket ticket = getTicket();
		Ticket savedindb = entityManager.persist(ticket);		
		Ticket getfromdb = ticketBookingDao.findById(savedindb.getTicketId()).get();
		assertThat(getfromdb).isEqualTo(savedindb);
	}
	private Ticket getTicket() {
		Ticket ticket = new Ticket();
		ticket.setPassengerName("Shalini");
		ticket.setSourceStation("Delhi");
		ticket.setDestStation("Mumbai");
		ticket.setEmail("shalini@gmail.com");
		ticket.setBookingDate("5/20/2018");
		ticket.setTicketId(1);
		return ticket;
	}
	@Test
	public void testGetTicketById(){
		Ticket ticket = new Ticket();
		ticket.setPassengerName("Martin Bingel");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Delhi");
		ticket.setBookingDate("23/6/2019");
		ticket.setEmail("martin.s2017@gmail.com");
		ticket.setTicketId(1);
		//Save ticket in DB
		Ticket ticketSavedInDb = entityManager.persist(ticket);
		
		//Get Ticket from DB
		Ticket ticketFromInDb = ticketBookingDao.findById(ticketSavedInDb.getTicketId()).get();
		assertThat(ticketSavedInDb).isEqualTo(ticketFromInDb);
	}
	
	@Test
	public void testGetAllBookedTickets(){
		Ticket ticket1 = new Ticket();
		ticket1.setPassengerName("Martin Bingel");
		ticket1.setSourceStation("Kolkata");
		ticket1.setDestStation("Delhi");
		ticket1.setBookingDate("23/6/2019");
		ticket1.setEmail("martin.s2017@gmail.com");
		ticket1.setTicketId(1);
		
		Ticket ticket2 = new Ticket();
		ticket2.setPassengerName("Sean Murphy");
		ticket2.setSourceStation("Kolkata");
		ticket2.setDestStation("Mumbai");
		ticket2.setBookingDate("23/7/2019");
		ticket2.setEmail("sean.s2017@gmail.com");
		ticket2.setTicketId(2);
		
		//Save both tickets in DB
		entityManager.persist(ticket1);
		entityManager.persist(ticket2);
		
		Iterable<Ticket> allTicketsFromDb = ticketBookingDao.findAll();
		List<Ticket> ticketList = new ArrayList<>();
		
		for (Ticket ticket : allTicketsFromDb) {
			ticketList.add(ticket);
		}
		assertThat(ticketList.size()).isEqualTo(2);
	}
	
	@Test
	public void testFindByEmail(){
		Ticket ticket = new Ticket();
		ticket.setPassengerName("Martin Bingel");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Delhi");
		ticket.setBookingDate("23/6/2019");
		ticket.setEmail("martin.s2017@gmail.com");
		ticket.setTicketId(1);
		//Ticket in DB
		entityManager.persist(ticket);
		
		//Get ticket info from DB for specified email
		Ticket getFromDb = ticketBookingDao.findByEmail("martin.s2017@gmail.com");
		assertThat(getFromDb.getPassengerName()).isEqualTo("Martin Bingel");
	}
	
	@Test
	public void testDeleteTicketById(){
		Ticket ticket1 = new Ticket();
		ticket1.setPassengerName("Martin Bingel");
		ticket1.setSourceStation("Kolkata");
		ticket1.setDestStation("Delhi");
		ticket1.setBookingDate("23/6/2019");
		ticket1.setEmail("martin.s2017@gmail.com");
		ticket1.setTicketId(1);
		
		Ticket ticket2 = new Ticket();
		ticket2.setPassengerName("Sean Murphy");
		ticket2.setSourceStation("Kolkata");
		ticket2.setDestStation("Mumbai");
		ticket2.setBookingDate("23/7/2019");
		ticket2.setEmail("sean.s2017@gmail.com");
		ticket2.setTicketId(2);
		
		//Save both tickets in DB
		Ticket persist = entityManager.persist(ticket1);
		entityManager.persist(ticket2);
		
		//delete one ticket DB
		entityManager.remove(persist);
		
		Iterable<Ticket> allTicketsFromDb = ticketBookingDao.findAll();
		List<Ticket> ticketList = new ArrayList<>();
		
		for (Ticket ticket : allTicketsFromDb) {
			ticketList.add(ticket);
		}
		assertThat(ticketList.size()).isEqualTo(1);
	}
	
	@Test
	public void testUpdateTicket(){
		Ticket ticket = new Ticket();
		ticket.setPassengerName("Martin Bingel");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Delhi");
		ticket.setBookingDate("23/6/2019");
		ticket.setEmail("martin.s2017@gmail.com");
		ticket.setTicketId(1);
		
		//save Ticket info in DB
		entityManager.persist(ticket);
		
		Ticket getFromDb = ticketBookingDao.findByEmail("martin.s2017@gmail.com");
		//update Email Address
		getFromDb.setEmail("martin.s2000@gmail.com");
		entityManager.persist(getFromDb);
		
		assertThat(getFromDb.getEmail()).isEqualTo("martin.s2000@gmail.com");
	}
}
