package com.DAO.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import com.DAO.AliasDAO;
import com.beans.Alias;
import com.beans.Country;

public class AliasDAOImpl extends BaseDAO implements AliasDAO {
	
	public void create(Alias a) {
		super.create(a);
	}

	@Override
	public Alias get(String countryAlias) {
		return (Alias) super.get(Alias.class, countryAlias);
	}

	@Override
	public Collection<Alias> getAllUnapproved() {
		Collection<Alias> ca = new LinkedList <Alias>();
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from alias where approved = 0");
		List<Object[]> aliases = mq.list();

		for (Object[] o: aliases) {
			Alias a = new Alias();
			a.setCountryAlias((String) o[0]);
			Country c = new Country();
			c.setCountryName((String) o[1]);
			a.setCountry(c);
			a.setApproved((Boolean) o[2]);
			a.setAlgorithm((String) o[3]);
			a.setThresholdValue((double) o[4]);
			a.setFound((Boolean) o[5]);
			ca.add(a);
		}
		return ca;
	}

	@Override
	public void approveAlias(String[] list) {
		for(String s : list) {
			Alias a = this.get(s);
			a.setApproved(true);
			super.getSession().beginTransaction();
			super.getSession().update(a);
			super.getSession().getTransaction().commit();
		}
		super.getSession().close();
	}
}
