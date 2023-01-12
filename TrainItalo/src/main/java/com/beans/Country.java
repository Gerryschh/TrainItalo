package com.beans;

public class Country implements Bean {
	private String countryName;
	private String alpha2code;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getAlpha2code() {
		return alpha2code;
	}
	public void setAlpha2code(String alpha2code) {
		this.alpha2code = alpha2code;
	}	
}
