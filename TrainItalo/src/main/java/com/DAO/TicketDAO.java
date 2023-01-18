package com.DAO;

import java.util.Collection;

import com.beans.Ticket;

public interface TicketDAO {
	
	public void create(Ticket t);
	public Ticket get(int idTicket);
	public Collection<Ticket> getAll(); //Get all tickets
	public Collection<Ticket> getAllByUserMail(String userMail);

}
