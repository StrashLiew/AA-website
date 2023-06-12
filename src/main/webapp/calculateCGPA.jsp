<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate</title>
</head>
<body>
<%@page import="java.util.*, com.dao.StudentDAO, com.dao.bean.Student" %>
<%
	List<Student> studentList = StudentDAO.getAllStudent();
%>

<%
	for(int i=0;i<studentList.size();i++){
		Student thisStudent = studentList.get(i);	
		int id = thisStudent.getStudent_id();
		StudentDAO.updateCredit(id, StudentDAO.calculateTotalCredit(id));
		StudentDAO.updateCGPA(id, StudentDAO.calculateCGPA(id));
	}
	
	response.sendRedirect("viewstudent.jsp");
	
%>
</body>
</html>