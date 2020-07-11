package com.bs4c.helper;

import java.util.Map;

import org.hibernate.engine.jdbc.connections.internal.ConnectionProviderInitiator;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.spi.ServiceRegistryImplementor;

public class JDBCConnectionProviderInitiator  extends ConnectionProviderInitiator
{

	@Override
	public ConnectionProvider initiateService(Map configMap, ServiceRegistryImplementor register) {
		return new JDBCConnectionProviderImpl();
	}

}
