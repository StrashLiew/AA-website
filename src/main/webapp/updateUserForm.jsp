<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
<link href="resources/add.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>

<%@ page import="java.util.*, com.dao.bean.User, com.dao.UserDAO, com.dao.bean.Admin, com.dao.AdminDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String id = request.getParameter("id");
	User u = UserDAO.getUserByID(Integer.parseInt(id));
%>
<input type="hidden" value="<%=u.getRole_id()%>" id="roleID">

<div class="navbar">
	<ul>
		<li style="z-index: 8;"><a href="admin.jsp">Profile<span><i class="fa-solid fa-address-card"></i></span></a></li>
		<li style="z-index: 7;"><a href="userList.jsp">UserList<span><i class="fa-solid fa-address-book"></i></span></a></li>
		<li style="z-index: 6;"><a href="viewstudent.jsp">StudentList<span><i class="fa-solid fa-address-book"></i></span></a></li>
		<li style="z-index: 5;"><a href="viewlecturer.jsp">LecturerList<span><i class="fa-solid fa-address-book"></i></span></a></li>
		<li style="z-index: 4;"><a href="timet.jsp">Timetable<span><i class="fa-solid fa-table-cells"></i></span></a></li>
		<li style="z-index: 3;"><a href="admincourse.jsp">Course List<span><i class="fa-solid fa-rectangle-list"></i></span></a></li>
		<li style="z-index: 2;"><a href="adminC.jsp">Calendar<span><i class="fa-solid fa-calendar"></i></span></a></li>
		<li style="z-index: 1;"><a href="login.html">Logout<span><i class="fa-solid fa-arrow-right-from-bracket"></i></span></a></li>
	</ul>
</div>

<div class="header1">
	<img src="resources/images/Cat_uni.png" alt="CAT University Academic Affairs Online System">
	<p class = "subtitle">CAT University</p>
</div>

<div>
<h2>UPDATE USER</h2>
</div>

<h3>User ID: <%= u.getUser_id() %></h3>
<form action="updateUser.jsp" method="post">
<input type="hidden" value="<%=u.getUser_id() %>" name="userID">
<table width=25% align="center">
	<tr>
	<td>Username:</td>
	<td><input type ="text" name="username" value="<%=u.getUser_name()%>"></td>
	</tr>
	
	<tr>
	<td>Password:</td>
	<td><input type ="text" name="password" value="<%=u.getPassword()%>"></td>
	</tr>
	
	<tr>
	<td>Role Id:</td>
	<td><select name="roleIDSelect" id="roleSelect">
		<option value="1">Student</option>
		<option value="2">Lecturer</option>
		<option value="3">Admin</option>	
		</select></td>
	</tr>
	
</table>
<div class="panel blue">
 	<button>Update User</button>
</div>

</form>

<form action="userList.jsp">
<div class="panel blue">
 	<button>Cancel</button>
</div>
</form>


<footer class="page-footer1">
	<div class="gif"><img src="https://www.animatedimages.org/data/media/209/animated-cat-image-0421.gif"></div>
	<div class="footer1-copyright text-center">Copyright @ CAT University All Rights Reserved</div>
</footer>

<!-- set default value of the dropdown list -->
<script>
	var temp = document.getElementById('roleID');
	var mySelect = document.getElementById('roleSelect');	
	switch(temp.value){
	case "1":
		mySelect.value = "1";
		break;
	case "2":	
		mySelect.value = "2";
		break;
	case "3":
		mySelect.value = "3";
		break;
	}	
</script>
</body>

</html>

