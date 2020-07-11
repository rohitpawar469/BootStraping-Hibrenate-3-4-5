package com.bs4.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bs4.entities.Address;

public class BS4Test 
{
	public static void main(String[] args) 
	{
		Configuration configuration=new Configuration().configure();
		
		BootstrapServiceRegistryBuilder bootstrapServiceRegistryBuilder=new BootstrapServiceRegistryBuilder();
		BootstrapServiceRegistry bootstrapServiceRegistry=bootstrapServiceRegistryBuilder.build();
		
		
		StandardServiceRegistryBuilder standardServiceRegistryBuilder=new StandardServiceRegistryBuilder();
		StandardServiceRegistry standardServiceRegistry=standardServiceRegistryBuilder.applySettings(configuration.getProperties()).build();
		
		SessionFactory sessionFactory=configuration.buildSessionFactory(standardServiceRegistry);
		Session session=sessionFactory.openSession();
		Address address=(Address)session.get(Address.class, 1);
		System.out.println(address);
		
	}
}
