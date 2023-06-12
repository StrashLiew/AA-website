<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*, com.dao.StudentDAO" %>
<%
int studentid = Integer.parseInt(request.getParameter("id"));
%>

<%
	int i= StudentDAO.delete(studentid);
	
	response.sendRedirect("viewstudent.jsp");
	
%>
</body>
</html>