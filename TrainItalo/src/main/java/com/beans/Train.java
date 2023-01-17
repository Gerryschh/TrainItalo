package com.beans;

import java.sql.Timestamp;

public class Train implements Bean {
	private int idTrain;
	private String matTrain;
	private TrainFactory factory;
	private Country departure;
	private Country arrival;
	private Timestamp departureDatetime;
	private Timestamp arrivalDatetime;
	
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
	public Country getDeparture() {
		return departure;
	}
	public void setDeparture(Country departure) {
		this.departure = departure;
	}
	public Country getArrival() {
		return arrival;
	}
	public void setArrival(Country arrival) {
		this.arrival = arrival;
	}
	public Timestamp getDepartureDatetime() {
		return departureDatetime;
	}
	public void setDepartureDatetime(Timestamp departureDatetime) {
		this.departureDatetime = departureDatetime;
	}
	public Timestamp getArrivalDatetime() {
		return arrivalDatetime;
	}
	public void setArrivalDatetime(Timestamp arrivalDatetime) {
		this.arrivalDatetime = arrivalDatetime;
	}
	
	@Override
	public String toString() {
		return "Train [idTrain=" + idTrain + ", matTrain=" + matTrain + ", factory=" + factory + ", departure="
				+ departure + ", arrival=" + arrival + ", departureDatetime=" + departureDatetime + ", arrivalDatetime="
				+ arrivalDatetime + "]";
	}
}
