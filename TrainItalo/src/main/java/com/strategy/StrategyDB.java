package com.strategy;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.beans.Alias;
import com.beans.Country;
import com.beans.TrainFactory;
import com.beans.Train;
import com.beans.User;
import com.DAO.AliasDAO;
import com.DAO.CountryDAO;
import com.DAO.TrainDAO;
import com.DAO.TrainFactoryDAO;
import com.DAO.UserDAO;
import com.DAO.impl.AliasDAOImpl;
import com.DAO.impl.CountryDAOImpl;
import com.DAO.impl.TrainDAOImpl;
import com.DAO.impl.TrainFactoryDAOImpl;
import com.DAO.impl.UserDAOImpl;

public class StrategyDB implements Strategy{
	
	private AliasDAO aliasDAO = new AliasDAOImpl();
	private UserDAO userDAO = new UserDAOImpl();
	private TrainDAO trainDAO = new TrainDAOImpl();
	private TrainFactoryDAO trainFactoryDAO = new TrainFactoryDAOImpl();
	private CountryDAO countryDAO = new CountryDAOImpl();
	private Map<String,List<String>> dataMap;
	
	/*
	 * METODI ADD
	 */

	@Override
	public void addUser(String userMail, String userPassword, String userName, String userSurname) {
		User u = new User();
		u.setUserMail(userMail);
		u.setUserPassword(userPassword);
		u.setUserName(userName);
		u.setAdmin(false);
		userDAO.create(u);
	}

	@Override
	public void addTrain(String matTrain, String factoryName, String departure, String arrival,  Date departureDatetime, Date arrivalDatetime) {
		Train t = new Train();
		t.setMatTrain(matTrain);
		TrainFactory tf = trainFactoryDAO.get(factoryName);
		t.setDeparture(departure);
		t.setArrival(arrival);
		t.setDepartureDatetime(departureDatetime);
		t.setArrivalDatetime(arrivalDatetime);
		t.setTrainFactory(tf);
		trainDAO.create(t);
	}	
	
	@Override
	public void addCountry(String countryName, String alpha2code) {
		Country c = new Country();
		c.setCountryName(countryName);
		c.setAlpha2code(alpha2code);
		countryDAO.create(c);
	}

	@Override
	public void addAlias(String countryAlias, String countryName, String algorithm, 
			double thresholdValue, boolean isFound) {
		Alias a = new Alias();
		a.setCountryAlias(countryAlias);
		Country c = new Country();
		countryDAO.get(countryName);
		a.setCountry(c);
		a.setApproved(false);
		a.setAlgorithm(algorithm);
		a.setThresholdValue(thresholdValue);
		a.setFound(isFound);
		aliasDAO.create(a);
	}
	
	@Override
	public void addTrainFactory(String factoryName, int passengerSeats, int disabledPassengerSeats,
			double towableWeight, double headWeight, double passengerWeight, double cargoWeight,
			double restaurantWeight) {
		TrainFactory tf = new TrainFactory();
		tf.setFactoryName(factoryName);
		tf.setPassengerSeats(passengerSeats);
		tf.setDisabledPassengerSeats(disabledPassengerSeats);
		tf.setTowableWeight(towableWeight);
		tf.setHeadWeight(headWeight);
		tf.setPassengerWeight(passengerWeight);
		tf.setCargoWeight(cargoWeight);
		tf.getRestaurantWeight();
		trainFactoryDAO.create(tf);
	}

	/*
	 * METODI GET
	 */

	public Map<String,List<String>> dataMap() {
		return aliasDAO.getMap(countryDAO.getNames());
	}

	@Override
	public Collection<Country> getAllCountries() {
		return countryDAO.getAll();
	}

	@Override
	public Collection<Alias> getAllUnapprovedAliases() {
		return aliasDAO.getAllUnapproved();
	}

	@Override
	public User getUserByMail(String userMail) {
		return userDAO.get(userMail);
	}

	@Override
	public Collection<Train> getAllTrains() {
		return trainDAO.getAll();
	}

	@Override
	public Collection<User> getAllNormalUsers() {
		return userDAO.getAllNormal();
	}

	@Override
	public User getUserByMailAndPsw(String userEmail, String userPassword) {
		return userDAO.getByMailAndPsw(userEmail, userPassword);
	}
	
	public Collection<TrainFactory> getAllFactories(){
		return trainFactoryDAO.getAll();
	}
	
	public String getCountryNameByAlias(String input) {
		return countryDAO.getNameByAlias(input);
	}	

	/*
	 * METODI SET
	 */

	@Override
	public void approveAlias(String[] list) {
		aliasDAO.approveAlias(list);
	}
}