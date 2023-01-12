package com.beans;

public class TrainFactory implements Bean {
	private String factoryName;
	private int passengerSeats;
	private int disabledPassengerSeats;
	private double towableWeight;
	private double headWeight;
	private double passengerWeight;
	private double cargoWeight;
	private double restaurantWeight;
	
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public int getPassengerSeats() {
		return passengerSeats;
	}
	public void setPassengerSeats(int passengerSeats) {
		this.passengerSeats = passengerSeats;
	}
	public int getDisabledPassengerSeats() {
		return disabledPassengerSeats;
	}
	public void setDisabledPassengerSeats(int disabledPassengerSeats) {
		this.disabledPassengerSeats = disabledPassengerSeats;
	}
	public double getTowableWeight() {
		return towableWeight;
	}
	public void setTowableWeight(double towableWeight) {
		this.towableWeight = towableWeight;
	}
	public double getHeadWeight() {
		return headWeight;
	}
	public void setHeadWeight(double headWeight) {
		this.headWeight = headWeight;
	}
	public double getPassengerWeight() {
		return passengerWeight;
	}
	public void setPassengerWeight(double passengerWeight) {
		this.passengerWeight = passengerWeight;
	}
	public double getCargoWeight() {
		return cargoWeight;
	}
	public void setCargoWeight(double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}
	public double getRestaurantWeight() {
		return restaurantWeight;
	}
	public void setRestaurantWeight(double restaurantWeight) {
		this.restaurantWeight = restaurantWeight;
	}
}
