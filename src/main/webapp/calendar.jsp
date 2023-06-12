<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calendar</title>
<link href="resources/calendar.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>

<%@ page import="java.util.*, com.dao.bean.User, com.dao.StudentDAO, com.dao.bean.Student, com.dao.LecturerDAO, com.dao.bean.Lecturer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	HttpSession httpSession = request.getSession();
	int user_id = (int) httpSession.getAttribute("user_id");
	Student currentStudent = StudentDAO.getStudentByUserID(user_id);
	
	String name = currentStudent.getStudent_name();

%>
<div class="header">
	<img src="resources/images/Cat_uni.png" alt="CAT University Academic Affairs Online System">
	<p class="subtitle">Welcome! <%= name %></p>
</div>

<div class="navbar">
	<ul>
		<li style="z-index: 5;"><a href="student.jsp">Profile<span><i class="fa-solid fa-address-card"></i></span></a></li>
		<li style="z-index: 4;"><a href="timetable.jsp">Timetable<span><i class="fa-solid fa-table-cells"></i></span></a></li>
		<li style="z-index: 3;"><a href="stdcourse.jsp">Course List<span><i class="fa-solid fa-rectangle-list"></i></span></a></li>
		<li style="z-index: 2;"><a href="calendar.jsp">Calendar<span><i class="fa-solid fa-calendar"></i></span></a></li>
		<li style="z-index: 1;"><a href="login.html">Logout<span><i class="fa-solid fa-arrow-right-from-bracket"></i></span></a></li>
	</ul>
</div>

<div class="overlay"></div>

<div>
<h2>ACADEMIC CALENDAR</h2>
</div>

<div class="calendar-content">
 <nav class="stroke">
    <ul>
      <li><a href="#foundation">FOUNDATION</a></li>
      <li><a href="#undergrad">UNDERGRADUATE</a></li>
      <li><a href="#mba">MBA</a></li>
    </ul>
 </nav>

<section id="foundation">
	<h3>Foundation Calendar</h3>
	<img src="resources/images/fCalendar.jpg">
</section>

<section id="undergrad">
	<br><br><br><h3>Undergraduate Calendar</h3>
	<img src="resources/images/calendar.png">
</section>

<section id="mba">
	<br><br><br><h3>MBA Calendar</h3>
	<img src="resources/images/MBA_calendar.png">
</section>
</div>


<footer class="page-footer">
	<div class="gif"><img src="https://www.animatedimages.org/data/media/209/animated-cat-image-0421.gif"></div>
	<div class="footer-copyright text-center">Copyright @ CAT University All Rights Reserved</div>
</footer>

</body>
</html>