package com.connectionDB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public abstract class ConnectionToDB {
	public static Session getSession() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		
		return session;
	}
	
	public static Transaction getTransaction() {
		return getSession().beginTransaction();
	}
	
}
