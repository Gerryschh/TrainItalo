package com.DAO.impl;

import com.beans.Train;
import com.beans.TrainFactory;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import com.DAO.TrainDAO;

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
			t.setTrainFactory(tf);
			t.setDeparture((String) o[3]);
			t.setArrival((String) o[4]);
			t.setDepartureDatetime((Date) o[5]);
			t.setArrivalDatetime((Date) o[6]);
			ct.add(t);
		}
		return ct;
	}
}
