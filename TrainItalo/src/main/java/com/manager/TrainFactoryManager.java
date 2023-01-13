package com.manager;

import java.util.Collection;

import com.DAO.TrainFactoryDAO;
import com.DAO.impl.TrainFactoryDAOImpl;
import com.beans.TrainFactory;

public class TrainFactoryManager {
	TrainFactoryDAO trainFactoryDAO = new TrainFactoryDAOImpl();
	
	public void addTrainFactory(TrainFactory tf) {
		trainFactoryDAO.create(tf);
	}
	
	public TrainFactory getTrainFactory(String factoryName) {
		return trainFactoryDAO.get(factoryName);
	}
	
	//Get all train's factories
	public Collection<TrainFactory> getAllFactories(){
		return trainFactoryDAO.getAll();
	}

}
