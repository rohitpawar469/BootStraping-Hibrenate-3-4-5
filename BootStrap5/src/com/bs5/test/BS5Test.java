package com.bs5.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.bs5.entities.Address;

public class BS5Test
{
	public static void main(String[] args) 
	{
		StandardServiceRegistryBuilder standardServiceRegistryBuilder=new StandardServiceRegistryBuilder().configure();
		
		StandardServiceRegistry standardServiceRegistry=standardServiceRegistryBuilder.build();
		
		
		MetadataSources metadataSources=new MetadataSources(standardServiceRegistry);
		MetadataBuilder metadataBuilder=metadataSources.getMetadataBuilder();
		Metadata metadata=metadataBuilder.build();
		
		SessionFactoryBuilder sessionFactoryBuilder=metadata.getSessionFactoryBuilder();
		SessionFactory sessionFactory=sessionFactoryBuilder.build();
		
		Session session=sessionFactory.openSession();
		//Address address=session.get(Address.class,1);
		//System.out.println(address);
		
		Address address=session.load(Address.class, 1);
		System.out.println(address);
		
		
		
		
		
	}
}
