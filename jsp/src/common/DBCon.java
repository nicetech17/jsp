package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private Connection con;
	
	public DBCon() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/jsp";	// http:// mysql(mariadb) localhost(ip주소) / jsp(user jsp) 전화번호
		String id = "root";	// 아이디, 비밀번호 맞춰야 연결 
		String pwd = "1234";
		Class.forName("org.mariadb.jdbc.Driver");
		con = DriverManager.getConnection(url, id, pwd);
	}
	
	public Connection getCon() {
		return con;
	}
}
