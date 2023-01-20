package com.DAO;

import java.util.Collection;

import com.beans.Alias;

public interface AliasDAO {
	
	public void create(Alias a);
	public Alias get(String countryAlias);
	public Collection<Alias> getAllUnapproved(); //Get all unapproved Aliases
	public Collection<Alias> getAllAlias(); //Get all Aliases
	public void approveAlias(String[] aliases); //Approve an Alias setting the "approved" field on "true"
	public void removeAlias(String aliasRemove);
}
