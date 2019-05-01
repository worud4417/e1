package jdbc;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.PoolableConnection;
import org.apache.tomcat.dbcp.dbcp2.PoolableConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.PoolingDriver;
import org.apache.tomcat.dbcp.pool2.impl.GenericObjectPool;
import org.apache.tomcat.dbcp.pool2.impl.GenericObjectPoolConfig;

public class DBCPInitListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String poolConfig = sce.getServletContext().getInitParameter("poolConfig");
		Properties prop = new Properties();
		
		try {
			prop.load(new StringReader(poolConfig));
		}
		catch(IOException e) {
			throw new RuntimeException("config load fail",e);
		}
		loadJDBCDriver(prop);
		initConnectionPool(prop);
	}
	
	private void loadJDBCDriver(Properties prop) {
		String driverClass = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driverClass);
		}
		catch(ClassNotFoundException e) {
			throw new RuntimeException("fail to load JDBC Driver",e);
		}
	}
	
	private void initConnectionPool(Properties prop) {
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3307/test1?characterEncoding=utf8&serverTimezone=UTC";
			String username = "test1";
			String pw = "test1";
			
			/*ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl,username,pw);
			
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory,null);
			String validationQuery = prop.getProperty("validationQuery");
			if(validationQuery != null&&!validationQuery.isEmpty()) {
				poolableConnFactory.setValidationQuery(validationQuery);
			}
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5L);
			poolConfig.setTestWhileIdle(true);
			int minIdle = this.getIntProperty(prop, "minIdle", 5);
			poolConfig.setMinIdle(minIdle);
			int maxTotal = this.getIntProperty(prop, "maxTotal", 50);
			poolConfig.setMaxTotal(maxTotal);
			
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory,poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.tomcat.dbcp.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			String poolName = prop.getProperty("poolName");
			driver.registerPool(poolName, connectionPool);*/
			
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private int getIntProperty(Properties prop, String propName,int defaultValue) {
		String value = prop.getProperty(propName);
		if(value == null)
			return defaultValue;
		return Integer.parseInt(value);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}
