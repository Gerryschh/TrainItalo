package com.beans;

import java.util.Date;

public class Train implements Bean {
	private int idTrain;
	private String matTrain;
	private TrainFactory factory;
	private String departure;
	private String arrival;
	private Date departureDatetime;
	private Date arrivalDatetime;
	
	public int getIdTrain() {
		return idTrain;
	}
	public void setIdTrain(int idTrain) {
		this.idTrain = idTrain;
	}
	public String getMatTrain() {
		return matTrain;
	}
	public void setMatTrain(String matTrain) {
		this.matTrain = matTrain;
	}
	public TrainFactory getFactory() {
		return factory;
	}
	public void setFactory(TrainFactory factory) {
		this.factory = factory;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public Date getDepartureDatetime() {
		return departureDatetime;
	}
	public void setDepartureDatetime(Date departureDatetime) {
		this.departureDatetime = departureDatetime;
	}
	public Date getArrivalDatetime() {
		return arrivalDatetime;
	}
	public void setArrivalDatetime(Date arrivalDatetime) {
		this.arrivalDatetime = arrivalDatetime;
	}
}
