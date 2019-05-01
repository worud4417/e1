package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import jdbc.connection.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class DeleteArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao articleContentDao= new ArticleContentDao();
	
	public void delete(int no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			articleDao.delete(conn, no);
			articleContentDao.delete(conn, no);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(conn);
		}
	}
}
