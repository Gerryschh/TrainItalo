package com.DAO;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.beans.Alias;

public interface AliasDAO {
	
	public void create(Alias a);
	public Alias get(String countryAlias);
	public Collection<Alias> getAllUnapproved(); //Get all unapproved Aliases
	public void approveAlias(String[] list); //Approve an Alias setting the "approved" field on "true"
	public Map<String,List<String>> getMap(List<String> countries); //Get a map where Aliases are referenced with countries
}
