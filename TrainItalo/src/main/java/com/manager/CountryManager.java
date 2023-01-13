package com.manager;

import java.util.Collection;

import com.DAO.CountryDAO;
import com.DAO.impl.CountryDAOImpl;
import com.beans.Country;

public class CountryManager {
	CountryDAO countryDAO = new CountryDAOImpl();
	
	public void addCountry(Country c) {
		countryDAO.create(c);
	}
	
	public Country getCountry(String countryName) {
		return countryDAO.get(countryName);
	}
	
	public String getCountryNameByAlias(String input) {
		return countryDAO.getNameByAlias(input);
	}
	
	public Collection<Country> getAllCountries() {
		return countryDAO.getAll();
	}
}
