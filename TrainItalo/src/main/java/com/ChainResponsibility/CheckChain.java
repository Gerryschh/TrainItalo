package com.ChainResponsibility;

import com.DAO.impl.AliasDAOImpl;
import com.DAO.impl.CountryDAOImpl;
import com.DAO.AliasDAO;
import com.DAO.CountryDAO;
import com.beans.Alias;
import com.strategy.Strategy;

public abstract class CheckChain {
	private CheckChain nextChain;
	private static Strategy strategy;
	private AliasDAO aliasDAO = new AliasDAOImpl();
	private CountryDAO countryDAO = new CountryDAOImpl();	
	
	public void setNextChain(CheckChain nextChain) {
		this.nextChain=nextChain;
	}
	public final String check(String input) {
		String result = checkInternal(input);
		if(result != null) {
			Alias a = new Alias();
			a.setCountryAlias(input);
			a.setCountryName(countryDAO.get(result));
			a.setApproved(false);
			a.setAlgorithm(this.getClass().getSimpleName());
			a.setFound(true);
			aliasDAO.create(a);
			System.out.println("Il risultato è "+result);
			return result;
		}
		//non ho trovato la soluzione, procedo col successivo se c'è
		if (nextChain!= null)
			return this.nextChain.check(input);
		else {
			strategy.addAlias(input, null, null, 0, false);
        	return null;
			}
		}
	
	protected abstract String checkInternal(String input);
	
	
	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		CheckChain.strategy = strategy;
	}
	
}
