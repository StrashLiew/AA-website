<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Lecturer</title>
<link href="resources/add.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>

<%@ page import="java.util.*, com.dao.bean.User, com.dao.DepartmentDAO, com.dao.bean.Department, com.dao.LecturerDAO, com.dao.bean.Lecturer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	List<Department> departmentList = DepartmentDAO.getAllDepartment();
 	request.setAttribute("departmentList", departmentList);
%>

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
<h2>ADD LECTURER</h2>
</div>

<form action="AddLecturer" method="post">

<table width=30% align="center">
	<tr>
	<td>Lecturer Name:</td>
	<td><input type ="text" name="name"></td>
	</tr>
	
	<tr>
	<td>User ID:</td>
	<td><input type ="text" name="userid"></td>
	</tr>
	
	<tr>
	<td>Email:</td>
	<td><input type ="email" name="email"></td>
	</tr>
	
	<tr>
	<td>Department:</td>
	<td><select name="department">
    <c:forEach items="${departmentList}" var="department">
        <option value="${department.getDepartment_id()}">${department.getDepartment_name()}</option>
    </c:forEach>
	</select></td>
	</tr>
	
	<tr>
	<td>Lecturer Intake:</td>
	<td><input type ="text" name="intake"></td>
	</tr>
	
</table>
<div class="panel blue">
  	<button>Add Lecturer</button>
</div>
</form>

<form action="viewlecturer.jsp">
<div class="panel blue">
  	<button>Cancel</button>
</div>
</form>

<footer class="page-footer1">
	<div class="gif"><img src="https://www.animatedimages.org/data/media/209/animated-cat-image-0421.gif"></div>
	<div class="footer1-copyright text-center">Copyright @ CAT University All Rights Reserved</div>
</footer>

</body>
</html>