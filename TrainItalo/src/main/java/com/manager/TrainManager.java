package com.manager;

import java.util.Collection;

import com.DAO.TrainDAO;
import com.DAO.impl.TrainDAOImpl;
import com.beans.Train;

public class TrainManager {
	TrainDAO trainDAO = new TrainDAOImpl();
	
	public void addTrain(Train t) {
		trainDAO.create(t);
	}
	
	public Collection<Train> getAllTrains() {
		return trainDAO.getAll();
	}
}
