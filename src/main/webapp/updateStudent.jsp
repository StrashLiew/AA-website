<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>
<%@page import="java.util.*, com.dao.StudentDAO, com.dao.bean.Student" %>
<%
	int studentid = Integer.parseInt(request.getParameter("studentID"));
	float cgpa = Float.parseFloat(request.getParameter("cgpa"));
	String name = request.getParameter("name");
	int userid = Integer.parseInt(request.getParameter("userid"));
	String email = request.getParameter("email");
	int programmeid = Integer.parseInt(request.getParameter("programme"));
	int totalcredit = Integer.parseInt(request.getParameter("totalcredit"));
	String intake = request.getParameter("intake");
	
	Student newStudent = new Student(userid, name, email, programmeid, cgpa, totalcredit, intake );
	
	int i = StudentDAO.update(studentid, newStudent);
	System.out.println(i);
	response.sendRedirect("viewstudent.jsp");
%>
</body>
</html>