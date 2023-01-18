package com.DAO.impl;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import com.DAO.TrainDAO;
import com.beans.Country;
import com.beans.Train;
import com.beans.TrainFactory;

public class TrainDAOImpl extends BaseDAO implements TrainDAO {

	@Override
	public void create(Train t) {
		super.create(t);
	}

	@Override
	public Train get(int idTrain) {
		return (Train) super.get(Train.class, idTrain);
	}

	@Override
	public Collection<Train> getAll() {
		Collection<Train> ct = new LinkedList <Train>();
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from train");
		List<Object[]> trains = mq.list();

		for (Object[] o: trains) {
			Train t = new Train();
			t.setIdTrain((Integer) o[0]);
			t.setMatTrain((String) o[1]);
			TrainFactory tf = new TrainFactory();
			tf.setFactoryName((String) o[2]);
			t.setFactory(tf);
			Country departure = new Country();
			departure.setCountryName((String) o[3]);
			t.setDeparture(departure);
			Country arrival = new Country();
			arrival.setCountryName((String) o[4]);
			t.setArrival(arrival);
			t.setDepartureDatetime((Timestamp) o[5]);
			t.setArrivalDatetime((Timestamp) o[6]);
			ct.add(t);
		}
		return ct;
	}
	
	public Collection<Train> getTrainsWithParameter(String factoryName, String departure, String arrival) {
		Collection<Train> ct = new HashSet <Train>();
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from train where factory ='" + factoryName 
				+ "' AND departure = '" + departure + "' AND arrival = '"+ arrival + "'");
		List<Object[]> trains = mq.list();
		for (Object[] o: trains) {
			Train t = new Train();
			t.setIdTrain((Integer) o[0]);
			t.setMatTrain((String) o[1]);
			TrainFactory tf = new TrainFactory();
			tf.setFactoryName((String) o[2]);
			t.setFactory(tf);
			
			Country departureCountry = new Country();
			departureCountry.setCountryName((String) o[3]);
			
			Country arrivalCountry = new Country();
			arrivalCountry.setCountryName((String) o[4]);
			
			t.setDeparture(departureCountry);
			t.setArrival(arrivalCountry);
			t.setDepartureDatetime((Timestamp) o[5]);
			t.setArrivalDatetime((Timestamp) o[6]);
			ct.add(t);
		}
		return ct;
	}

	@Override
	public Collection<Train> getTrainsWithoutFactory(String departure, String arrival) {
		Collection<Train> ct = new HashSet <Train>();
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from train where departure = '" + departure + "' "
				+ "AND arrival = '"+ arrival + "'");
		List<Object[]> trains = mq.list();
		for (Object[] o: trains) {
			Train t = new Train();
			t.setIdTrain((Integer) o[0]);
			t.setMatTrain((String) o[1]);
			TrainFactory tf = new TrainFactory();
			tf.setFactoryName((String) o[2]);
			t.setFactory(tf);
			
			Country departureCountry = new Country();
			departureCountry.setCountryName((String) o[3]);
			
			Country arrivalCountry = new Country();
			arrivalCountry.setCountryName((String) o[4]);
			
			t.setDeparture(departureCountry);
			t.setArrival(arrivalCountry);
			t.setDepartureDatetime((Timestamp) o[5]);
			t.setArrivalDatetime((Timestamp) o[6]);
			ct.add(t);
		}
		return ct;
	}
}
