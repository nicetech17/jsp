package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConTest {
	
	public static void main(String[] args) {
		/*String url = "jdbc:mysql://localhost:3306/jsp";	// http:// mysql(mariadb) localhost(ip주소) / jsp(user jsp) 전화번호
		String id = "root";	// 아이디, 비밀번호 맞춰야 연결 
		String pwd = "1234"; ->DBCon.java*/
		Connection con;	
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			/*Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd); // con 한테 전화기 기능 전달*/			
			System.out.println("연결 성공");	// 데이터베이스 연결
			String name = "홍길동";
			String sql = "select * from user where id=?";  /*use where name='" + name + "'"; // 보안에 warning 걸림*/	
			PreparedStatement ps = con.prepareStatement(sql);	// heidisql의 흰색 화면에 'select * from user' 입력 . 실행x
			ResultSet rs = ps.executeQuery(); // ctrl + shift + f9 실행 결과값을 rs에 저장
			while(rs.next()) {	// .next()-> 데이터 있음,없음boolean true,false로 변환 meta data(user_no), row data(1,2..)의 중간 역할
				System.out.print(rs.getString("id") + ",");
				System.out.print(rs.getString("pwd") + ",");
				System.out.println(rs.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
