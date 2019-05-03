package ex1;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Service {
	private Map<String,CommandHandler> commandHandlerMap = new HashMap<>();

	public Service() {
		Properties prop = new Properties();
		try(FileReader fis = new FileReader("C:\\Users\\Àç°æ\\Desktop\\e1\\ex1\\src\\ex1\\CommandProperties.properties")){
			prop.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Iterator keyIter = prop.keySet().iterator();
		
		while(keyIter.hasNext()) {
			String keyName = (String) keyIter.next();
			String handerClassName = prop.getProperty(keyName);
			
			Class<?> handlerClass = null;
			try {
				handlerClass = Class.forName(handerClassName);
				System.out.println(handlerClass);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				CommandHandler InstanceHandlerClass = (CommandHandler) handlerClass.newInstance();
				commandHandlerMap.put(keyName, InstanceHandlerClass);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void process() {
		CommandHandler handler = commandHandlerMap.get("Hello");
		handler.process();
		commandHandlerMap.get("Bye").process();
	}
}
