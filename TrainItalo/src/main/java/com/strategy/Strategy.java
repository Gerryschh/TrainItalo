package com.strategy;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.beans.Alias;
import com.beans.Country;
import com.beans.Train;
import com.beans.TrainFactory;
import com.beans.User;

public interface Strategy {
	
	/*
	 * METODI ADD
	 */
	public void addUser(String userMail, String userPassword, String userName, String userSurname);
	public void addTrain(String matTrain, String factoryName, String departure, String arrival,  Date departureDatetime, Date arrivalDatetime);
	public void addCountry(String countryName, String alpha2code);
	public void addAlias(String countryAlias, String countryName, String algorithm, double thresholdValue, boolean isFound);
	public void addTrainFactory(String factoryName, int passengerSeats, int disabledPassengerSeats, 
			double towableWeight, double headWeight, double passengerWeight, double cargoWeight, double restaurantWeight);
	
	/*
	 * METODI GET
	 */
		
	//GET ALL
	public Map<String,List<String>> dataMap();
	public Collection<Country> getAllCountries();
	public Collection<Alias> getAllUnapprovedAliases();
	public Collection<Train> getAllTrains();
	public Collection<User> getAllNormalUsers();
	public Collection<TrainFactory> getAllFactories();
	
	//GET BY PARAMETERS
	public String getCountryNameByAlias(String alias);
	public User getUserByMail(String userMail);
	public User getUserByMailAndPsw(String userMail, String userPassword);
	
	/*
	 * METODI SET
	 */
	public void approveAlias(String[] aliases);
}
