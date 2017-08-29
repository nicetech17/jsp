package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TestServlet extends HttpServlet {
	
		private static final long serialVersionUID = 1L;
		
		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String id  = request.getParameter("id");
			System.out.println(id);
			String name = request.getParameter("name");
			System.out.println(name);
			String age = request.getParameter("age");
			System.out.println(age);
			String address = request.getParameter("address");
			System.out.println(address);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.println("입력하신 ID : " + id + "<br/>"); 
			pw.println("입력하신 이름 : " + name + "<br/>");
			pw.println("입력하신 나이 : " + age + "<br/>");
			pw.println("입력하신 주소 : " + address + "<br/>");
			
		}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String id  = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String result ="";
			if (id.equals("redfila") || id.equals("red") || id.equals("blue") || id.equals("black")) {	// 서버에서 null.equals로읽혀 에러
				if(pwd.equals("red")) {
				HttpSession session = request.getSession(); // 서버에게 request요청 세션 생성
				session.setAttribute("id", id); // 세션을 id로 저장
				result = "정상적으로 로그인 되었습니다.";
				} else {
					result = "비밀번호가 틀렸습니다.";
				}
			} else {
				result = "없는 아이디 입니다.";
			}
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.println("입력하신 ID : " + id + "<br/>"); 
			pw.println("입력하신 비밀번호 : " + pwd + "<br/>");
			pw.println(result);
	}

	
}