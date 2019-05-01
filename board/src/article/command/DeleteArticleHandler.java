package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.DeleteArticleService;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler{
	private DeleteArticleService deleteArticleService = new DeleteArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		deleteArticleService.delete(no);
		
		return "WEB-INF/view/DeleteSuccess.jsp";
	}
	
	
}
