package com.beans;

public class Alias implements Bean {
	private String countryAlias;
	private Country countryName;
	private boolean approved;
	private String algorithm;
	private double thresholdValue;
	private boolean isFound;
	
	public String getCountryAlias() {
		return countryAlias;
	}
	public void setCountryAlias(String countryAlias) {
		this.countryAlias = countryAlias;
	}
	public Country getCountryName() {
		return countryName;
	}
	public void setCountryName(Country countryName) {
		this.countryName = countryName;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public double getThresholdValue() {
		return thresholdValue;
	}
	public void setThresholdValue(double thresholdValue) {
		this.thresholdValue = thresholdValue;
	}
	public boolean isFound() {
		return isFound;
	}
	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}
}
