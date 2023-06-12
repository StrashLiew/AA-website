<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*, com.dao.LecturerDAO" %>
<%
int lecturerid = Integer.parseInt(request.getParameter("id"));
%>

<%
	int i= LecturerDAO.delete(lecturerid);
	
	response.sendRedirect("viewlecturer.jsp");
	
%>
</body>
</html>