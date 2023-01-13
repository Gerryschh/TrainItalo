package com.DAO;

import java.util.Collection;
import java.util.List;

import com.beans.Country;

public interface CountryDAO {
	
	public void create(Country c);
	public Country get(String countryName);
	public String getNameByAlias(String alias); //Get a country by an Alias name
	public Collection<Country> getAll(); //Get all countries
}
