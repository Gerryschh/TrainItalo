package com.manager;

import java.util.Collection;

import com.DAO.AliasDAO;
import com.DAO.impl.AliasDAOImpl;
import com.beans.Alias;

public class AliasManager {
	AliasDAO aliasDAO = new AliasDAOImpl();
	
	public void addAlias(Alias a) {
		aliasDAO.create(a);
	}
	
	public Alias getAlias(String countryAlias) {
		return aliasDAO.get(countryAlias);
	}
	
	//Get all unapproved Aliases
	public Collection<Alias> getAllUnapprovedAliases() {
		return aliasDAO.getAllUnapproved();
	}
	
	//Approve an Alias setting the "approved" field on "true"
	public void approveAlias(String[] aliases) {
		aliasDAO.approveAlias(aliases);
	}
		
}
