package jdbc;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBCPInitListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
		
		String poolConfig = sce.getServletContext().getInitParameter("poolConfig");
		Properties prop = new Properties();
		
		try {
			prop.load(new StringReader(poolConfig));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		loadJDBCDriver();
	}
	
	private void loadJDBCDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("fail to load JDBCDriver");
			e.printStackTrace();
		}
	}

}
