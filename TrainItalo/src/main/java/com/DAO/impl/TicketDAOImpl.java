package com.DAO.impl;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import com.DAO.TicketDAO;
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
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("SELECT t.id_train, t.mat_train, t.departure, t.arrival, t.departure_datetime, t.arrival_datetime"
				+ "	FROM train t"
				+ " JOIN ticket tt ON t.id_train = tt.id_train"
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
			t.setIdTrain(train);
			t.setPurchaseDate((Timestamp) o[3]);
			ct.add(t);
		}
		return ct;
	}

}
