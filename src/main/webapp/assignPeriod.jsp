<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Period To Course</title>
<link href="resources/add.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ page import="java.util.*, com.dao.bean.Period, com.dao.PeriodDAO, com.dao.bean.Course, com.dao.CourseDAO, com.dao.CoursePeriodDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int id = Integer.parseInt(request.getParameter("courseID"));
	Course c = CourseDAO.getCourseByID(id);
	Period defaultPeriod = CoursePeriodDAO.getPeriodByCourse(id);
	int periodID = 0;
	if(defaultPeriod != null){
		periodID = defaultPeriod.getPeriod_id();
	}
	String location = CoursePeriodDAO.getLocationByCoursePeriod(id, periodID);
	
	List<Period> periodList = PeriodDAO.getAllPeriod();
 	request.setAttribute("periodList", periodList);
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
<h2>ASSIGN PERIOD TO COURSE</h2>
</div>

<h3>Course Name: <%= c.getCourse_name() %></h3>
<form action="ReassignPeriod" method="post">
<input type="hidden" value="<%= periodID%>" id="periodID" name = "defaultPeriodID"> 
 <input type="hidden" value="<%=id %>" name="courseID"> 
<table width=27% align="center">
	
	<tr>
	<td>Period:</td>
	<td><select name="period" id = "periodSelect">
	<option value="0">Unassigned</option>
    <c:forEach items="${periodList}" var="period">
        <option value="${period.getPeriod_id()}">${period}</option>
    </c:forEach>
	</select></td>
	</tr>
	
	<tr>
	<td>Location: </td>
	<td><input type ="text" name="location" value="<%=location%>"></td>
	</tr>
	
</table>
<div class="panel blue">
	<button>Assign Period</button>
</div>

</form>

<form action="timet.jsp">
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
	var temp = document.getElementById('periodID');
	var mySelect = document.getElementById('periodSelect');	
	
	mySelect.value = temp.value;
	
</script>

</body>
</html>