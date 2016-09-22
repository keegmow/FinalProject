package com.krho.finalproject;


import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;



public class DAO {
	
	private static SessionFactory factory;
	private static void setupFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) { ; }

		Configuration configuration = new Configuration();
		//modify these to match your XML files
		configuration.configure("hibernate.cfg.xml");
		configuration.addResource("activity.hbm.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static List <Activity> getActivities(String userQuery) {
		if (factory == null)
			setupFactory();
		
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		String hql = userQuery;
		Query query = hibernateSession.createQuery("FROM Activity " + hql);

		@SuppressWarnings("unchecked")
		List <Activity> activities = query.getResultList();
		hibernateSession.close();
		
		return activities;
	}
}
