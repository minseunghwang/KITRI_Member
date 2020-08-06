<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<%@ page import="dao.JoinDaoImpl"%>
<%@ page import="model.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	JoinDaoImpl service = new JoinDaoImpl();
	Member m = service.select((String)session.getAttribute("id"));
%>

<h3>정보수정</h3>
<form action="<%=request.getContextPath() %>/SearchController" method="post">
	id: <input type="text" name="updid" value=<%=session.getAttribute("id")%>><br />
	pwd: <input type="text" name="updpwd" value=<%=m.getPwd()%>><br />
	name: <input type="text" name="updname" value=<%=m.getName()%>><br />
	email: <input type="text" name="updemail" value=<%=m.getEmail()%>><br />
	<input type="submit" value="정보수정"><br />
</form>
<a href="<%=request.getContextPath() %>/member/result.jsp">메인</a>

</body>
</html>