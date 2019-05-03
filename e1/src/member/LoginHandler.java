package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.CommandHandler;

public class LoginHandler implements CommandHandler{
	
	private LoginService loginService = new LoginService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("loginHandler");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		loginService.login(id,password);
		
		return null;
	}

}
