<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
test.jsp파일입니다.
<%	// jsp 태그 시작
response.sendRedirect("/test/test2.jsp"); /* 프로젝트가 켜져있는 절대경로 프로젝트가 웹컨텐트에 맵핑되어있음 */
%> 	<! -// jsp 태그 끝 > 
</body>
</html>