package com.beans;

import java.sql.Timestamp;

public class Ticket implements Bean {

	private int idTicket;
	private User userMail;
	private Train idTrain;
	private Timestamp purchaseDate;
	
	public int getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}
	public User getUserMail() {
		return userMail;
	}
	public void setUserMail(User userMail) {
		this.userMail = userMail;
	}
	public Train getIdTrain() {
		return idTrain;
	}
	public void setIdTrain(Train idTrain) {
		this.idTrain = idTrain;
	}
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
