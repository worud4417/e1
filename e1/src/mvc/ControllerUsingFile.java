package mvc;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.CommandHandler;

public class ControllerUsingFile extends HttpServlet{
	
	private Map<String,CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		process(req,resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		String configFilePath = this.getServletContext().getRealPath(configFile);
		try(FileReader fis = new FileReader(configFilePath)){
			prop.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		Iterator keyItem = prop.keySet().iterator();
		while(keyItem.hasNext()) {
			String keyname = (String) keyItem.next();
			String commandValue = prop.getProperty(keyname);
			
			try {
				Class<?> handlerClass = Class.forName(commandValue);
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				commandHandlerMap.put(keyname, handlerInstance);
			}
			catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}
	
	private void process(HttpServletRequest req,HttpServletResponse res) throws ServletException{
		String command = req.getRequestURI();
		System.out.println(command);
		String frontURI = req.getContextPath();
		System.out.println(frontURI);
		
		command = command.substring(frontURI.length());
		System.out.println(command);
		CommandHandler commandHandler = commandHandlerMap.get(command);
		try {
			commandHandler.process(req, res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
