package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import common.DBCon;

public class UserServiceImpl implements UserService {

	@Override
	public Map<String, String> getUserLogin(String id, String pwd) {
		Connection con;
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			String sql = "select * from user where id=?";  /*use where name='" + name + "'"; // 보안에 warning 걸림*/	
			PreparedStatement ps = con.prepareStatement(sql);	// heidisql의 흰색 화면에 'select * from user' 입력 . 실행x
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery(); // ctrl + shift + f9 실행 결과값을 rs에 저장
			while(rs.next()) {	// .next()-> 데이터 있음,없음boolean true,false로 변환 meta data(user_no), row data(1,2..)의 중간 역할
				if(pwd.equals(rs.getString("pwd"))) {
					Map<String, String> hm = new HashMap<String, String>();
					hm.put("id", id);
					hm.put("user_no", rs.getString("user_no"));
					hm.put("name", rs.getString("name"));
					hm.put("hobby", rs.getString("hobby"));
					hm.put("admin", rs.getString("admin"));
					return hm;
				}
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertUser(Map<String, String> hm) {
		String sql = "insert into user(id,pwd,name,hobby,admin)";
		sql +="values(?,?,?,?,?)";
		Connection con;
		String result = "회원 가입이 실패하였습니다.";
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);	// heidisql의 흰색 화면에 'select * from user' 입력 . 실행x
			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("pwd"));
			ps.setString(3, hm.get("name"));
			ps.setString(4, hm.get("hobby"));
			ps.setString(5, hm.get("admin"));
			int rCnt = ps.executeUpdate();
			return rCnt;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUser(Map<String, String> hm) {
		String sql = "update user" +
				" set id=?" +
				", pwd=?" +
				", name=?" +
				", hobby=?" +
				" where user_no=?";
		Connection con;
		String result = "회원 가입이 실패하였습니다.";
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);	// heidisql의 흰색 화면에 'select * from user' 입력 . 실행x
			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("pwd"));
			ps.setString(3, hm.get("name"));
			ps.setString(4, hm.get("hobby"));
			ps.setString(5, hm.get("user_no"));
			int rCnt = ps.executeUpdate();
			return rCnt;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(Map<String, String> hm) {
		String sql = "delete from user where user_no=?";
		Connection con;
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);	// heidisql의 흰색 화면에 'select * from user' 입력 . 실행x
			ps.setString(1, hm.get("user_no"));
			int rCnt = ps.executeUpdate();
			return rCnt;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Map<String, String>> getUserList(Map<String, String> hm) {
		Connection con;
		List<Map<String, String>> userList = new ArrayList <Map<String, String>>();
		try {
			DBCon db = new DBCon();
			con = db.getCon();
			String sql = "select * from user where 1=1";  /*use where name='" + name + "'"; // 보안에 warning 걸림*/	
			if(hm.get("name")!=null) {
				sql += " and name like concat('%',?,'%')";
			}
			PreparedStatement ps = con.prepareStatement(sql);// heidisql의 흰색 화면에 'select * from user' 입력 . 실행x
			if(hm.get("name")!=null) {
				ps.setString(1, hm.get("name"));
			}
			ResultSet rs = ps.executeQuery(); // ctrl + shift + f9 실행 결과값을 rs에 저장
			while(rs.next()) {	// .next()-> 데이터 있음,없음 boolean true,false로 변환 meta data(user_no), row data(1,2..)의 중간 역할
				Map<String, String> rHm = new HashMap<String, String>();
				rHm.put("id", rs.getString("id"));
				rHm.put("user_no", rs.getString("user_no"));
				rHm.put("name", rs.getString("name"));
				rHm.put("hobby", rs.getString("hobby"));
				rHm.put("admin", rs.getString("admin"));
				userList.add(rHm);
				}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public static void main(String[] args) {
		List<Map<String, String>> userList = new ArrayList <Map<String, String>>();
		Map<String, String> rHm = new HashMap<String, String>();
		userList.add(rHm);
		rHm.put("id", "1");
		rHm.put("user_no", "2");
		System.out.println(rHm);
		
		for(Map<String, String> h : userList) {
			h.put("user_no", "asdfasdf");
			System.out.println(h);
		}
		System.out.println(rHm);
	}
}
