package com.DAO;

import java.util.Collection;

import com.beans.Alias;

public interface AliasDAO {
	
	public void create(Alias a);
	public Alias get(String countryAlias);
	public Collection<Alias> getAllUnapproved(); //Get all unapproved Aliases
	public void approveAlias(String[] list); //Approve an Alias setting the "approved" field on "true"
}
