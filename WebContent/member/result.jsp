<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>메뉴</h3>
	<%
		boolean flag = false;
		if(!session.isNew()){
			flag = (boolean) session.getAttribute("flag");
		}
		if(flag){
			String id = (String) session.getAttribute("id");
	%>
	<%= id %>님 로그인
	<br>
	<a href="<%=request.getContextPath()%>/LogoutController">로그아웃</a><br>
	<a href="<%=request.getContextPath() %>/member/memberInfo.jsp">정보수정</a>
	<br>
	<%
		} else {
	%>
	<h3>로그인 실패</h3>
	<a href="<%=request.getContextPath()%>/member/loginForm.jsp">로그인 폼</a>
	<%
		}
	%>
</body>
</html>