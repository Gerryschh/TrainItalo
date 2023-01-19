package com.ChainResponsibility;

import com.beans.Alias;
import com.manager.AliasManager;
import com.manager.CountryManager;
import com.strategy.Strategy;

public abstract class CheckChain {
	private CheckChain nextChain;
	private static Strategy strategy;
	private AliasManager aliasManager = new AliasManager();
	private CountryManager countryManager = new CountryManager();
	private double soglia = 0;
	
	public void setNextChain(CheckChain nextChain) {
		this.nextChain=nextChain;
	}
	public final String check(String input) {
		String result = checkInternal(input);
		if(result != null) {
			Alias a = new Alias();
			a.setCountryAlias(input);
			a.setCountryName(countryManager.getCountry(result));
			a.setApproved(false);
			a.setAlgorithm(this.getClass().getSimpleName());
			a.setThresholdValue(getSoglia());
			a.setFound(true);
			aliasManager.addAlias(a);
			System.out.println("Il risultato è "+result);
			return result;
		}
		//non ho trovato la soluzione, procedo col successivo se è presente
		if (nextChain!= null)
			return this.nextChain.check(input);
		else {
			Alias a = new Alias();
			a.setCountryAlias(input);
			a.setCountryName(null);
			a.setAlgorithm(null);
			a.setThresholdValue(0);
			a.setFound(false);
			aliasManager.addAlias(a);
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
	
	public double getSoglia() {
		return soglia;
	}

	public void setSoglia(double soglia) {
		this.soglia = soglia;
	}
	
}
