package com.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.connectionDB.ConnectionToDB;

public class StrategyDB implements Strategy{
	
	private Session session = ConnectionToDB.getSession();
	
	//Get a map where Aliases are referenced with countries
	public Map<String,List<String>> dataMap() {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		NativeQuery<String> q = session.createSQLQuery("Select country_name From country");
		
		for (String s: q.getResultList()) {
			map.put(s.toLowerCase(), new ArrayList<String>());
		}
		NativeQuery<Object []> mq = session.createSQLQuery("Select alias_country, country_name from alias");
		List<Object[]>  l =mq.list();
		System.out.println(l.size());
		for(Object[] o: l) { 
			List<String> temp = map.get(((String)o[1]).toLowerCase());
			temp.add((String) o[0]);
			map.put((String) o[1], temp);            
		}
		Map<String,List<String>> dataMap = map;
		return map;
	}
}