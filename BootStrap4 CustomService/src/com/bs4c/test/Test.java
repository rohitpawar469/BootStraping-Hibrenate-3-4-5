package com.bs4c.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bs4c.entities.Address;
import com.bs4c.helper.JDBCConnectionProviderInitiator;

public class Test {

	public static void main(String[] args) 
	{
		
		Configuration configuration=new Configuration().configure();
		
		StandardServiceRegistryBuilder standardServiceRegistryBuilder=new StandardServiceRegistryBuilder();
		
		standardServiceRegistryBuilder.applySettings(configuration.getProperties());
		standardServiceRegistryBuilder.addInitiator(new JDBCConnectionProviderInitiator());
		
		StandardServiceRegistry standardServiceRegistry=standardServiceRegistryBuilder.build();
		
		SessionFactory sessionFactory=configuration.buildSessionFactory(standardServiceRegistry);
		
		Session session=sessionFactory.openSession();
		
		Address address=(Address)session.get(Address.class, 1);
		System.out.println(address);
		
		
		
		
		
	}

}
