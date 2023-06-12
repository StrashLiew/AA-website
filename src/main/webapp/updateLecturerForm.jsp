<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lecturer Form</title>
<link href="resources/add.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ page import="java.util.*, com.dao.bean.Lecturer, com.dao.LecturerDAO, com.dao.bean.Department, com.dao.DepartmentDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String id = request.getParameter("id");
	Lecturer l = LecturerDAO.getLecturerByID(Integer.parseInt(id));
	List<Department> departmentList = DepartmentDAO.getAllDepartment();
 	request.setAttribute("departmentList", departmentList);
%>
<input type="hidden" value="<%=l.getLec_department_id()%>" id="departmentID">
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
<h2>UPDATE LECTURER</h2>
</div>

<h3>Lecturer ID: <%= l.getLec_id() %></h3>
<form action="updateLecturer.jsp" method="post">
<input type="hidden" value="<%=l.getLec_id() %>" name="lecturerID">
<table width=28% align="center">
	<tr>
	<td>Lecturer Name:</td>
	<td><input type ="text" name="name" value="<%=l.getLec_name() %>" ></td>
	</tr>
	
	<tr>
	<td>User ID:</td>
	<td><input type ="text" name="userid" value="<%=l.getUser_id() %>"></td>
	</tr>
	
	<tr>
	<td>Email:</td>
	<td><input type ="email" name="email" value="<%=l.getLec_email() %>"></td>
	</tr>
	
	<tr>
	<td>Department:</td>
	<td><select name="department" id = "departmentSelect">
    <c:forEach items="${departmentList}" var="department">
        <option value="${department.getDepartment_id()}">${department.getDepartment_name()}</option>
    </c:forEach>
	</select></td>
	</tr>
	
	<tr>
	<td>Lecturer Intake:</td>
	<td><input type ="text" name="intake" value="<%=l.getLec_intake() %>"></td>
	</tr>
	
</table>

<div class="panel blue">
  <button>Update Lecturer</button>
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

<!-- set default value of the dropdown list 
<tr>
		<td>Country:</td>
		<td>
		<select name ="country" style="width:300px">
		<option>Malaysia</option>
		<option>Singapore</option>
		<option>China</option>
		<option>Indonesia</option>
		</select>
		</td>
</tr>-->

<script>
	var temp = document.getElementById('departmentID');
	var mySelect = document.getElementById('departmentSelect');	
	
	mySelect.value = temp.value;
	
</script>

</body>
</html>