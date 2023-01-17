package com.manager;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.DAO.TrainDAO;
import com.DAO.impl.CountryDAOImpl;
import com.DAO.impl.TrainDAOImpl;
import com.DAO.impl.TrainFactoryDAOImpl;
import com.beans.Country;
import com.beans.Train;
import com.beans.TrainFactory;
import com.creatingTrain.builder.ConcreteBuilder;
import com.creatingTrain.builder.TrenoBuilder;
import com.creatingTrain.exceptions.ExceedException;
import com.creatingTrain.exceptions.FactoryException;
import com.creatingTrain.exceptions.TooShortStringException;
import com.creatingTrain.exceptions.WrongCombinationException;
import com.creatingTrain.exceptions.wrongLocomotive.MissingHeadLocomotiveException;
import com.creatingTrain.factory.FRFactory;
import com.creatingTrain.factory.ITFactory;
import com.creatingTrain.factory.TNFactory;
import com.creatingTrain.factory.VagoneFactory;
import com.creatingTrain.treno.Treno;

public class TrainManager {
	TrainDAO trainDAO = new TrainDAOImpl();
	TrainFactoryManager tfm = new TrainFactoryManager();
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
	CountryManager cm = new CountryManager();
	CountryDAOImpl countryDAO = new CountryDAOImpl();
	TrainFactoryDAOImpl trainFactoryDAO = new TrainFactoryDAOImpl();

	public Collection<Train> getAllTrains() {
		return trainDAO.getAll();
	}

	public Collection<Train> getTrainsWithParameter(String factoryName, String departure, String arrival){
		return trainDAO.getTrainsWithParameter(factoryName, departure, arrival);
	}

	public void checkAndAddTrain (String inputMatricolaTreno,String trainFactoryName, 
			String inputDeparture, String inputArrival, String inputDepartureHour,
			String inputArrivalHour) throws FactoryException, ParseException, TooShortStringException, MissingHeadLocomotiveException, ExceedException, WrongCombinationException
	{
		VagoneFactory vf;
		TrenoBuilder tb;
		Treno train;
		TrainFactory trainfactoryBean = new TrainFactory();

		vf = getFactory(trainFactoryName);

		tb = new ConcreteBuilder(vf);
		train = tb.buildTreno(inputMatricolaTreno.toUpperCase());
		Train trainBean = new Train();
		trainBean.setMatTrain(inputMatricolaTreno.toUpperCase());
		trainBean.setDeparture(countryDAO.getSession().get(Country.class, inputDeparture));
		trainBean.setArrival(countryDAO.getSession().get(Country.class, inputArrival));
		trainfactoryBean = trainFactoryDAO.getSession().get(TrainFactory.class, trainFactoryName);
		trainBean.setFactory(trainfactoryBean);
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date dateStart = null;
		Date dateEnd = null;
		dateStart = isoFormat.parse(inputDepartureHour);
		dateEnd = isoFormat.parse(inputArrivalHour);
		Timestamp timeStart = new Timestamp(dateStart.getTime());
		Timestamp timeEnd = new Timestamp(dateEnd.getTime());
		trainBean.setDepartureDatetime(timeStart);
		trainBean.setArrivalDatetime(timeEnd);
		trainDAO.create(trainBean);
	}

	private VagoneFactory getFactory(String trainFactoryName) throws FactoryException {
		if(trainFactoryName != null && trainFactoryName.equals("FrecciaRossa"))
		{
			return new FRFactory();
		}
		else if (trainFactoryName != null && trainFactoryName.equals("TreNord"))
		{
			return new TNFactory();
		}
		else if (trainFactoryName != null && trainFactoryName.equals("Italo"))
		{
			return new ITFactory();
		}
		else throw new FactoryException(trainFactoryName,"Factory non consentita!");
	}
}

