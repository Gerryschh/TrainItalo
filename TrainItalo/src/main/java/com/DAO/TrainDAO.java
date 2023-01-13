package com.DAO;

import java.util.Collection;

import com.beans.Train;

public interface TrainDAO {
	
	public void create(Train t);
	public Train get(int idTrain);
	public Collection<Train> getAll(); //Get all trains
	public Collection<Train> getTrainsWithParameter(int factory, String departure, String arrival);
}
