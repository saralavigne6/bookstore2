package com.oracle.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.oracle.entity.employee;

public class hibernate {
	private SessionFactory factory;
	public SessionFactory getFactory() {
		
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Transaction getTx() {
		return tx;
	}
	public void setTx(Transaction tx) {
		this.tx = tx;
	}
	private Session session;
	private Transaction tx;
	public void CreateLink(){
		factory = new AnnotationConfiguration().configure().addAnnotatedClass(employee.class).buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
	}
}
