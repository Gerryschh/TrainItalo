package com.DAO.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import com.DAO.TrainFactoryDAO;
import com.beans.TrainFactory;
import com.beans.User;

public class TrainFactoryDAOImpl extends BaseDAO implements TrainFactoryDAO {

	@Override
	public void create(TrainFactory tf) {
		super.create(tf);
	}

	@Override
	public TrainFactory get(String factoryName) {
		return (TrainFactory) super.get(TrainFactory.class, factoryName);
	}

	@Override
	public Collection<TrainFactory> getAll() {
		Collection<TrainFactory> ctf = new LinkedList <TrainFactory>();
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from train_factory");
		List<Object[]> factories = mq.list();

		for (Object[] o: factories) {
			TrainFactory tf = new TrainFactory();
			tf.setFactoryName((String) o[0]);
			tf.setPassengerSeats((Integer) o[1]);
			tf.setDisabledPassengerSeats((Integer) o[2]);
			tf.setTowableWeight((double) o[3]);
			tf.setHeadWeight((double) o[4]);
			tf.setPassengerWeight((double) o[5]);
			tf.setCargoWeight((double) o[6]);
			tf.setRestaurantWeight((double) o[7]);
			
			ctf.add(tf);
		}
		return ctf;
	}
}
