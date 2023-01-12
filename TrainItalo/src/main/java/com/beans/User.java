package com.beans;

import java.util.Date;

public class User implements Bean {
	private String userMail;
	private String userPassword;
	private String userName;
	private String userSurname;
	private Date userBirthdate;
	private boolean isAdmin;
	private int trainGameScore;
	
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public Date getUserBirthdate() {
		return userBirthdate;
	}
	public void setUserBirthdate(Date userBirthdate) {
		this.userBirthdate = userBirthdate;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getTrainGameScore() {
		return trainGameScore;
	}
	public void setTrainGameScore(int trainGameScore) {
		this.trainGameScore = trainGameScore;
	}
}
