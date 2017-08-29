<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%="이건 jsp파일입니다.<br/>" %> 
<%="전 System.out.println이랑 상당히 비슷한녀석이에요." %>
<br>jsp태그 시작해요
<%
out.println("저도 System.out.println이랑 비슷한녀석이에요");
int a = 1;
int b = 2;

int result = a + b;
out.println(a + " + " + b + " = " + result);
int[] arrNum = new int[5]; // 사이즈 지정해줘야 된다. 정해저있는 데이터 타입 건드릴수X 
for (int i = 0; i < arrNum.length; i++) {
	arrNum[i] = (i+1)*10;
}
%>
<br>jsp태그 종료했어요
<% 
for (int i = 0; i < arrNum.length; i++) {
	out.println("<br>" + arrNum[i]);
}
%>

</body>
</html>