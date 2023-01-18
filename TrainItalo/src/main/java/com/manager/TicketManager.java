package com.manager;

import java.util.Collection;

import com.DAO.TicketDAO;
import com.DAO.impl.TicketDAOImpl;
import com.beans.Ticket;

public class TicketManager {
	TicketDAO ticketDAO = new TicketDAOImpl();
	
	public void addTicket(Ticket t) {
		ticketDAO.create(t);
	}
	
	public Ticket get(int idTrain) {
		return ticketDAO.get(idTrain);
	}
	
	public Collection<Ticket> getAllTickets() {
		return ticketDAO.getAll();
	}
	
	public Collection<Ticket> getAllTicketsByMail(String userMail) {
		return ticketDAO.getAllByUserMail(userMail);
	}
	
	public Ticket getTicketByEmailIdTrain(String userEmail, int idTrain) {
	return ticketDAO.getTicketByEmailIdTrain(userEmail, idTrain);
	
	}
	

}
