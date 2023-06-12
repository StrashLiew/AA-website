<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lecture Course List</title>
<link href="Bootstrap/bootstrap-5.1.3-dist/css" rel="stylesheet" type="text/css">
<link href="resources/add.css" rel="stylesheet" type="text/css">
<link href="resources/courseList.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ page import="java.util.List, com.dao.UserDAO, com.dao.bean.User, com.dao.LecturerDAO, com.dao.bean.Lecturer, com.dao.bean.Course, com.dao.bean.Period, com.dao.CoursePeriodDAO, com.dao.bean.CourseStudent, com.dao.CourseStudentDAO, com.dao.CourseLecturerDAO" %>

<%
	int id = Integer.parseInt(request.getParameter("id"));

	
	Lecturer currentLecturer = LecturerDAO.getLecturerByID(id);	
	String name = currentLecturer.getLec_name();
	List<Course> courseList = CourseLecturerDAO.getCourseListByLecturer(id);	
	
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
<h2>LECTURER'S COURSE LIST</h2>
</div>
<p class="mb-0"><strong class="pr-1">Lecturer Name: </strong><%= name %></p>
<h4>Course Total: <%= courseList.size() %></h4>
<div class="coursetable">
<table border=3 align="center">

	<tr style="color: #fff; background: #433F2A; font-size: 17px; font-family: Georgia, serif;">
	<th>No.</th>
	<th>Course Name</th>
	<th>Course ID</th>
	<th>Credit</th>
	<th>Student No.</th>
	<th>Period</th>
	<th>Venue</th>
	</tr>
	<%
		for(int i = 0; i < courseList.size(); i++) {
			Course thisCourse = courseList.get(i);
			out.print("<tr>");
				out.print("<td>");
				out.print(i + 1);
				out.print("</td>");
				out.print("<td>");
				out.print(thisCourse.getCourse_name());
				out.print("</td>");
				out.print("<td>");
				out.print(thisCourse.getCourse_id());
				out.print("</td>");
				out.print("<td>");
				out.print(thisCourse.getCourse_credit());
				out.print("</td>");
			
				out.print("<td>");
				out.print("<a href='stddetailAdmin.jsp?courseID=" + thisCourse.getCourse_id() + "'>");
				out.print(CourseStudentDAO.getStudentListByCourse(thisCourse.getCourse_id()).size());
				
				out.print("</a>");
				out.print("</td>");
				
				Period thisPeriod = CoursePeriodDAO.getPeriodByCourse(thisCourse.getCourse_id());
				
				out.print("<td>");
				if(thisPeriod != null) {
					out.print(thisPeriod);
				} else {
					out.print("TBC");
				}
				
				out.print("</td>");
				out.print("<td>");
				if(thisPeriod != null){
					out.print(CoursePeriodDAO.getLocationByCoursePeriod(thisCourse.getCourse_id(), thisPeriod.getPeriod_id()));
				}else {
					out.print("TBC");
				}
				out.print("</td>");
			out.print("</tr>");
		}
	%>
</table>
</div>

<br/>

<form action="viewlecturer.jsp">
<div class="panel blue">
 	<button>Back</button>
</div>
</form>


<footer class="page-footer1">
	<div class="gif"><img src="https://www.animatedimages.org/data/media/209/animated-cat-image-0421.gif"></div>
	<div class="footer1-copyright text-center">Copyright @ CAT University All Rights Reserved</div>
</footer>

</body>
</html>