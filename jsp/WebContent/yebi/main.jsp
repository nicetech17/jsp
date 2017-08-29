<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
application.setAttribute("server", "redfila1"); // 단 1개 왠만하면 건드리지 말고 
String id = (String)session.getAttribute("id"); /* 리턴타입Object -> String 로그아웃하지 않는한 이 명령어로 계속 부름*/
String server = (String)application.getAttribute("server");
%> 
<%=server %>에 접속하셨습니다. <br>
<%=id %>님 환영합니다.
<%
try{ 
	out.println(request.getParameter("name").toUpperCase());
 // <%=request.getParameter("name").toUpperCase() > <! Null에 대문자변환>
} catch(Exception e){
	out.println("뭔지는 모르겠지만 에러가 났을겁니다.");
} %> <! jsp최대 단점 겁나 지저분해!~>
</body>
</html> 