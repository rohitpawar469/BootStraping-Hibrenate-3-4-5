package com.bs4c.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import javax.sql.ConnectionPoolDataSource;

import org.hibernate.MappingException;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.ConditionalParenthesisFunction;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import org.hibernate.service.Service;
import org.hibernate.service.spi.Configurable;
import org.hibernate.service.spi.Startable;
import org.hibernate.service.spi.Stoppable;
import org.hibernate.type.Type;

public class JDBCConnectionProviderImpl implements ConnectionProvider,Startable,Configurable,Stoppable
{
	String driverClass;
	String url;
	String username;
	String password;
	Connection con;
	
	
	@Override
	public boolean isUnwrappableAs(Class arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void start() 
	{
	
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection(Connection con) throws SQLException {
		System.out.println("Closeing the Connection");		
	}

	@Override
	public Connection getConnection() throws SQLException 
	{
		 con=DriverManager.getConnection(url,username,password);
		  
		return con;
	}

	@Override
	public boolean supportsAggressiveRelease() {
		
		return true;
	}

	@Override
	public void configure(Map configMap) 
	{
		driverClass=(String)configMap.get("connection.driver_class");
		System.out.println(driverClass);		
	
		url=(String)configMap.get("connection.url");
		System.out.println(url);
		
		username=(String)configMap.get("connection.username");
		System.out.println(username);
	
		password=(String)configMap.get("connection.password");
		System.out.println(password);
	}

	@Override
	public void stop() {
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	

}
