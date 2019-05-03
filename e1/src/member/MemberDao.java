package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.ConnectionProvider;

public class MemberDao {
	private Connection conn=null;
	
	public Member getMember(String id) {
		
		try {
			conn = ConnectionProvider.getConnection();
			String query = "select * from member where memberid=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
