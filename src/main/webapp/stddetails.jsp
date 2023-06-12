<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
<link href="Bootstrap/bootstrap-5.1.3-dist/css" rel="stylesheet" type="text/css">
<link href="resources/courseList.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ page import="java.util.List, com.dao.UserDAO, com.dao.bean.User, com.dao.LecturerDAO, com.dao.bean.Lecturer, com.dao.bean.Student, com.dao.bean.Course, com.dao.CourseDAO, com.dao.bean.Period, com.dao.CoursePeriodDAO, com.dao.bean.CourseStudent, com.dao.CourseStudentDAO, com.dao.CourseLecturerDAO" %>

<%
	HttpSession httpSession = request.getSession();
	int user_id = (int) httpSession.getAttribute("user_id");
	Lecturer currentLecturer = LecturerDAO.getLecturerByUserID(user_id);
	
	String name = currentLecturer.getLec_name();
	int id = currentLecturer.getLec_id();
	int course_id = Integer.parseInt(request.getParameter("courseID"));
	Course thisCourse = CourseDAO.getCourseByID(course_id);
	String course_name = thisCourse.getCourse_name();
	List<Student> studentList = CourseStudentDAO.getStudentListByCourse(course_id);
	List<Course> courseList = CourseLecturerDAO.getCourseListByLecturer(id);	
	
%>
<div class="header">
	<img src="resources/images/Cat_uni.png" alt="CAT University Academic Affairs Online System">
	<p class="subtitle">Welcome! <%= name %></p>
</div>

<div class="navbar">
	<ul>
		<li style="z-index: 5;"><a href="lecturer.jsp">Profile<span><i class="fa-solid fa-address-card"></i></span></a></li>
		<li style="z-index: 4;"><a href="lectimetable.jsp">Timetable<span><i class="fa-solid fa-table-cells"></i></span></a></li>
		<li style="z-index: 3;"><a href="leccourse.jsp">Course List<span><i class="fa-solid fa-rectangle-list"></i></span></a></li>
		<li style="z-index: 2;"><a href="calendar.jsp">Calendar<span><i class="fa-solid fa-calendar"></i></span></a></li>
		<li style="z-index: 1;"><a href="login.html">Logout<span><i class="fa-solid fa-arrow-right-from-bracket"></i></span></a></li>
	</ul>
</div>

<div>
<h2>STUDENT LIST</h2>
</div>

<p class="mb-0"><strong class="pr-1">Course: </strong><%= course_name %></p>

<div class="coursetable">
<table border=3 align="center">

	<tr style="color: #fff; background: #433F2A; font-size: 17px; font-family: Georgia, serif;">
	<th>No.</th>
	<th>Student Name</th>
	<th>Student ID</th>
	<th>Student Email</th>
	<th>Assign marks</th>
	</tr>
	
	<%
		for(int i = 0; i < studentList.size(); i++) {
			Student thisStudent = studentList.get(i);
			out.print("<tr>");
				out.print("<td>");
					out.print(i + 1);
				out.print("</td>");
				out.print("<td>");
					out.print(thisStudent.getStudent_name());
				out.print("</td>");
				out.print("<td>");
					out.print(thisStudent.getStudent_id());
				out.print("</td>");
				out.print("<td>");
					out.print(thisStudent.getStudent_email());
				out.print("</td>");
				out.print("<td>");
					out.print("<form action='lecAssignMarks.jsp?courseID=" + course_id + "' method='post'><input type='hidden' value='" + thisStudent.getStudent_id() + "' name = 'studentid'> <input name='mark' value='" + CourseStudentDAO.getMarksByCourseStudent(thisCourse.getCourse_id(), thisStudent.getStudent_id()) +
							"'></input><button type='submit'>Confirm</button></form>");
				out.print("</td>");
			out.print("</tr>");
		}
	%>
	
</table>
</div>

<h4>Student Total: <%= studentList.size() %></h4>

<footer class="page-footer">
	<div class="gif"><img src="https://www.animatedimages.org/data/media/209/animated-cat-image-0421.gif"></div>
	<div class="footer-copyright text-center">Copyright @ CAT University All Rights Reserved</div>
</footer>

</body>
</html>