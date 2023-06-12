<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
<%@page import="java.util.*, com.dao.UserDAO, com.dao.bean.User" %>
<%
	int userid = Integer.parseInt(request.getParameter("userID"));
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	int roleid = Integer.parseInt(request.getParameter("roleIDSelect"));
	String profileImage = request.getParameter("profileImage");
	User newUser = new User(username, password, roleid, profileImage);
	
	int i = UserDAO.update(userid, newUser);
	System.out.println(i);
	response.sendRedirect("userList.jsp");
%>


</body>
</html>