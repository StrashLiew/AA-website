<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*, com.dao.CourseDAO" %>
<%
int courseid = Integer.parseInt(request.getParameter("courseID"));
%>

<%
	
	int i= CourseDAO.delete(courseid);
	
	response.sendRedirect("admincourse.jsp");
	
%>
</body>
</html>