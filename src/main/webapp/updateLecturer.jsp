<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lecturer</title>
</head>
<body>
<%@page import="java.util.*, com.dao.LecturerDAO, com.dao.bean.Lecturer" %>
<%
	int lecturerid = Integer.parseInt(request.getParameter("lecturerID"));
	
	String name = request.getParameter("name");
	int userid = Integer.parseInt(request.getParameter("userid"));
	String email = request.getParameter("email");
	int departmentid = Integer.parseInt(request.getParameter("department"));
	String intake = request.getParameter("intake");
	
	Lecturer newLecturer = new Lecturer(userid, name, email, departmentid, intake);	
	int i = LecturerDAO.update(lecturerid, newLecturer);
	System.out.println(i);
	response.sendRedirect("viewlecturer.jsp");
%>
</body>
</html>