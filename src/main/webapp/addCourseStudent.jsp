<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student to Course</title>
<link href="resources/add.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ page import="java.util.*, com.dao.bean.Lecturer, com.dao.LecturerDAO, com.dao.CourseLecturerDAO, com.dao.bean.Course, com.dao.CourseDAO, com.dao.CourseStudentDAO, com.dao.StudentDAO, com.dao.bean.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int id = Integer.parseInt(request.getParameter("courseID"));
	Course c = CourseDAO.getCourseByID(id);
	
	List<Student> studentList = StudentDAO.getAllStudent();
	List<Student> existingStudent = CourseStudentDAO.getStudentListByCourse(id);
	Lecturer l = CourseLecturerDAO.getLecturerByCourse(id);
 	request.setAttribute("studentList", studentList);
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
<h2>ADD STUDENT TO COURSE</h2>
</div>

<h3>Course Name: <%= c.getCourse_name() %></h3>
<form action="AddCourseStudent" method="post">
 <input type="hidden" value="<%=id %>" name="courseID"> 
 <input type="hidden" value="<%=l.getLec_id() %>" name="lecturerID"> 
<table width=20% align="center">
	
	<tr>
	<td>Student:</td>
	<td><select name="student" id = "studentSelect">
	<option value="0" selected>Unassigned</option>
    <c:forEach items="${studentList}" var="student">
        <option value="${student.getStudent_id()}">${student.getStudent_name()}</option>
    </c:forEach>
	</select></td>
	</tr>
	
</table>
<div class="panel blue">
  	<button>Add Student</button>
</div>
</form>

<form action="admincourse.jsp">
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