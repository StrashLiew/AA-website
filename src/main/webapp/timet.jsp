<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Timetable</title>
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<link href="resources/timet.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>

<%@ page import="java.util.*, com.dao.bean.User, com.dao.StudentDAO, com.dao.bean.Student, com.dao.LecturerDAO, com.dao.bean.Lecturer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List,com.dao.UserDAO, com.dao.bean.User, com.dao.bean.Lecturer, com.dao.AdminDAO, com.dao.bean.Admin, com.dao.CourseDAO, com.dao.bean.Course, com.dao.bean.Period, com.dao.CoursePeriodDAO, com.dao.bean.CourseStudent, com.dao.CourseStudentDAO, com.dao.CourseLecturerDAO" %>

<%
	HttpSession httpSession = request.getSession();
	int user_id = (int) httpSession.getAttribute("user_id");
	Admin currentAdmin = AdminDAO.getAdminByID(user_id);
	 
	String name = currentAdmin.getAdmin_name(); 
	List<Course> courseList = CourseDAO.getAllCourse();
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
	<p class="subtitle">Welcome! <%=name %></p>
</div>
<div>
<h2>TIMETABLE</h2>
</div>
<br>
<br>

<div class="coursetable">
<table border=3 align="center">

	<tr style="color: #fff; background: #433F2A; font-size: 17px; font-family: Georgia, serif;">
	<th>No.</th>
	<th>Course Name</th>
	<th>Period</th>
	<th>Venue</th>
	<th>Assign</th>
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
				out.print("<td>");
				out.print("<a href='assignPeriod.jsp?courseID=" + thisCourse.getCourse_id() + "'>");
				out.print("Reassign</a>");	
				out.print("</td>");
			out.print("</tr>");
		}
	%>
</table>
</div>

<footer class="page-footer1">
	<div class="gif"><img src="https://www.animatedimages.org/data/media/209/animated-cat-image-0421.gif"></div>
	<div class="footer1-copyright text-center">Copyright @ CAT University All Rights Reserved</div>
</footer>




</body>
</html>