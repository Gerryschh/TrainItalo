package com.DAO.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.beans.Bean;

public abstract class BaseDAO {
	private Session session;
	
	public BaseDAO() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		this.session = factory.openSession();  
	}
	
	public Session getSession() {
		return this.session;
	}
	
	public Transaction getTransaction() {
		return this.session.beginTransaction();
	}
	
	protected void create(Bean b) {
		this.session.beginTransaction();
		this.session.save(b);
		this.session.getTransaction().commit();
		//this.session.close();
	}

	protected Bean get(Class<? extends Bean> class1, String id) {
		this.session.beginTransaction();
		Bean b = this.session.get(class1, id);
		this.session.getTransaction().commit();
		//this.session.close();
		return b;
	}
	
	protected Bean get(Class<? extends Bean> class1, int id) {
		this.session.beginTransaction();
		Bean b = this.session.get(class1, id);
		this.session.getTransaction().commit();
		//this.session.close();
		return b;
	}
}
