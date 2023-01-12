package com.strategy;

import java.util.Collection;
import java.util.Date;

import com.beans.Alias;
import com.beans.Country;
import com.beans.Train;
import com.beans.TrainFactory;
import com.beans.User;

public class StrategyFile implements Strategy {
	
	@Override
	public void addUser(String userMail, String userPassword, String userName, String userSurname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrain(String matTrain, String factoryName, String departure, String arrival, Date departureDatetime,
			Date arrivalDatetime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCountry(String countryName, String alpha2code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAlias(String countryAlias, String countryName, String algorithm, double thresholdValue,
			boolean isFound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrainFactory(String factoryName, int passengerSeats, int disabledPassengerSeats,
			double towableWeight, double headWeight, double passengerWeight, double cargoWeight,
			double restaurantWeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Alias> getAllUnapprovedAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Train> getAllTrains() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> getAllNormalUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TrainFactory> getAllFactories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCountryNameByAlias(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByMail(String userMail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByMailAndPsw(String userMail, String userPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveAlias(String[] list) {
		// TODO Auto-generated method stub
		
	}
}
