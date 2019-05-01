package mvc.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
		try {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
