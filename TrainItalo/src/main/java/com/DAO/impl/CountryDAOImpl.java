package com.DAO.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import com.DAO.CountryDAO;
import com.beans.Country;

public class CountryDAOImpl extends BaseDAO implements CountryDAO {
	public void create(Country c) {
		super.create(c);
	}

	@Override
	public Country get(String countryName) {
		return (Country) super.get(Country.class, countryName);
	}

	@Override
	public String getNameByAlias(String alias) {
		String query = "select nome_paese from alias where alias_paese = " + alias;
		NativeQuery<String> q = super.getSession().createSQLQuery(query);
		return q.getSingleResult();
	}

	@Override
	public Collection<Country> getAll() {
		Collection<Country> cc = new LinkedList <Country>();
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from country");
		List<Object[]> countries = mq.list();

		for (Object[] o: countries) {
			Country c = new Country();
			c.setCountryName((String) o[0]);
			c.setAlpha2code((String) o[1]);
			cc.add(c);
		}
		return cc;
	}
}
