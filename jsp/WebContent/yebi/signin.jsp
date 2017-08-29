<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id"); //  id = 변수명
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");
String hobby = "";
String[] arrHobby = request.getParameterValues("hobby");
/*for (int i = 0; i < arrHobby.length; i++) {
	hobby += arrHobby[i] + ", ";
}*/
%>
입력하신 아이디 : <%= id %> <br>
입력하신 비밀번호 : <%= pwd %> <br>
입력하신 이름 : <%= name %> <br>
선택하신 취미 : <%= hobby %> <br>
<!- <%
Map<String, String[]> map = request.getParameterMap();
out.println("Map에서 가져온 아이디 : " + map.get("id")[0]);
%> ->
</body>
</html>