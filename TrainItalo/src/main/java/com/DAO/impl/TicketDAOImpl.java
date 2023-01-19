package com.DAO.impl;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.query.NativeQuery;

import com.DAO.TicketDAO;
import com.beans.Country;
import com.beans.Ticket;
import com.beans.Train;
import com.beans.User;

public class TicketDAOImpl extends BaseDAO implements TicketDAO {
	
	public void create(Ticket t) {
		super.create(t);
	}

	@Override
	public Ticket get(int idTrain) {
		return (Ticket) super.get(Ticket.class, idTrain);
	}
	
	@Override
	public Collection<Ticket> getAll() {
		Collection<Ticket> ct = new LinkedList <Ticket>();
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from ticket");
		List<Object[]> tickets = mq.list();

		for (Object[] o: tickets) {
			Ticket t = new Ticket();
			t.setIdTicket((Integer) o[0]);
			User u = new User();
			u.setUserMail((String) o[1]);
			t.setUserMail(u);
			Train train = new Train();
			train.setIdTrain((Integer) o[2]);
			t.setIdTrain(train);
			t.setPurchaseDate((Timestamp) o[3]);
			ct.add(t);
		}
		return ct;
	}

	@Override
	public Collection<Ticket> getAllByUserMail(String userMail) {
		Collection<Ticket> ct = new LinkedList <Ticket>();
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("SELECT tt.id_ticket, tt.user_mail, t.id_train,  t.departure, t.departure_datetime, t.arrival, t.arrival_datetime, tt.purchase_date"
				+ " FROM ticket tt"
				+ " JOIN train t ON tt.id_train = t.id_train"
				+ " WHERE"
				+ " tt.user_mail='" + userMail + "'");
		List<Object[]> tickets = mq.list();

		for (Object[] o: tickets) {
			Ticket t = new Ticket();
			t.setIdTicket((Integer) o[0]);
			User u = new User();
			u.setUserMail((String) o[1]);
			t.setUserMail(u);
			Train train = new Train();
			train.setIdTrain((Integer) o[2]);
			Country departure = new Country();
			departure.setCountryName((String) o[3]);
			train.setDeparture(departure);
			train.setDepartureDatetime((Timestamp) o[4]);
			Country arrival = new Country();
			arrival.setCountryName((String) o[5]);
			train.setArrival(arrival);
			train.setArrivalDatetime((Timestamp) o[6]);
			t.setIdTrain(train);
			t.setPurchaseDate((Timestamp) o[7]);
			ct.add(t);
		}
		return ct;
	}
	
	public Ticket getTicketByEmailIdTrain(String userEmail, int idTrain) {
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from ticket WHERE user_mail='"+ userEmail + "' AND id_train='" + idTrain + "'" );
		try {
			Object [] ticket = mq.getSingleResult();
			Ticket t = new Ticket();
			t.setIdTicket((Integer) ticket[0]);
			
			User u = new User();
			u.setUserMail((String) ticket[1]);
			t.setUserMail(u);
			
			Train train = new Train();
			train.setIdTrain((Integer) ticket[2]);
			t.setIdTrain(train);
			t.setPurchaseDate((Timestamp) ticket[3]);
			System.out.println(train.toString());
			return t;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	

}
