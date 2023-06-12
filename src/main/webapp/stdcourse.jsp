<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Course List</title>
<link href="Bootstrap/bootstrap-5.1.3-dist/css" rel="stylesheet" type="text/css">
<link href="resources/courseList.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ page import="java.util.List, com.dao.UserDAO, com.dao.bean.User, com.dao.StudentDAO, com.dao.bean.Student, com.dao.bean.Course, com.dao.bean.Period, com.dao.CoursePeriodDAO, com.dao.bean.CourseStudent, com.dao.CourseStudentDAO, com.dao.CourseLecturerDAO" %>

<%
	HttpSession httpSession = request.getSession();
	int user_id = (int) httpSession.getAttribute("user_id");
	Student currentStudent = StudentDAO.getStudentByUserID(user_id);
	
	String name = currentStudent.getStudent_name();
	int id = currentStudent.getStudent_id();
	
	List<Course> courseList = CourseStudentDAO.getCourseListByStudent(id);	
	int totalCredit = 0;
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

<div>
<h2>COURSE LIST</h2>
</div>

<p class="mb-0"><strong class="pr-1">Semester: </strong>2022/04</p>

<div class="coursetable">
<table border=3 align="center">

	<tr style="color: #fff; background: #433F2A; font-size: 17px; font-family: Georgia, serif;">
	<th>No.</th>
	<th>Course Name</th>
	<th>Course ID</th>
	<th>Credit</th>
	<th>Lecturer</th>
	<th>Period</th>
	<th>Venue</th>
	<th>Marks</th>
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
				int courseCredit = thisCourse.getCourse_credit();
				out.print(courseCredit);
				totalCredit += courseCredit;
				out.print("</td>");
				out.print("<td>");
				out.print(CourseLecturerDAO.getLecturerByCourse(thisCourse.getCourse_id()).getLec_name());
				out.print("</td>");
				
				Period thisPeriod = CoursePeriodDAO.getPeriodByCourse(thisCourse.getCourse_id());
				
				out.print("<td>");
				out.print(thisPeriod);
				out.print("</td>");
				out.print("<td>");
				out.print(CoursePeriodDAO.getLocationByCoursePeriod(thisCourse.getCourse_id(), thisPeriod.getPeriod_id()));
				out.print("</td>");
				out.print("<td>");
				out.print(CourseStudentDAO.getMarksByCourseStudent(thisCourse.getCourse_id(), id));
				out.print("</td>");
			out.print("</tr>");
		}
	%>

</table>
</div>

<h4>Total Credit: <%= totalCredit %></h4>

<footer class="page-footer">
	<div class="gif"><img src="https://www.animatedimages.org/data/media/209/animated-cat-image-0421.gif"></div>
	<div class="footer-copyright text-center">Copyright @ CAT University All Rights Reserved</div>
</footer>

</body>
</html>