package com.DAO;

import java.util.Collection;

import com.beans.TrainFactory;

public interface TrainFactoryDAO {

	public void create(TrainFactory tf);
	public TrainFactory get(String factoryName);
	public Collection<TrainFactory> getAll(); //Get all train's factory
}
