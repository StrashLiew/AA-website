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
<%@ page import="java.util.*, com.dao.bean.Lecturer, com.dao.LecturerDAO, com.dao.bean.Course, com.dao.CourseDAO, com.dao.CourseLecturerDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int id = Integer.parseInt(request.getParameter("courseID"));
	Course c = CourseDAO.getCourseByID(id);
	Lecturer defaultLec = CourseLecturerDAO.getLecturerByCourse(id);
	int lecID = 0;
	if(defaultLec != null){
		lecID = defaultLec.getLec_id();
	}
	
	
	List<Lecturer> lecturerList = LecturerDAO.getAllLecturer();
 	request.setAttribute("lecturerList", lecturerList);
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
<h2>REASSIGN LECTURER TO COURSE</h2>
</div>

<h3>Course Name: <%= c.getCourse_name() %></h3>
<form action="ReassignLec" method="post">
<input type="hidden" value="<%= lecID%>" id="lecturerID" name = "defaultLecID"> 
 <input type="hidden" value="<%=id %>" name="courseID"> 
<table width=25% align="center">
	
	<tr>
	<td>Lecturer:</td>
	<td><select name="lecturer" id = "lecturerSelect">
	<option value="0">Unassigned</option>
    <c:forEach items="${lecturerList}" var="lecturer">
        <option value="${lecturer.getLec_id()}">${lecturer.getLec_name()}</option>
    </c:forEach>
	</select></td>
	</tr>
	
</table>
<div class="panel blue">
	<button>Assign Lecturer</button>
</div>

</form>

<form action="admincourse.jsp">
<div class="panel blue">
  <button>Cancel</button>
</div>
</form>


<footer class="page-footer1">
	<div class="gif"><img src="https://www.animatedimages.org/data/media/209/animated-cat-image-0421.gif" alt="Under Maintenance"></div>
	<div class="footer1-copyright text-center">Copyright @ CAT University All Rights Reserved</div>
</footer>

<!-- set default value of the dropdown list -->
<script>
	var temp = document.getElementById('lecturerID');
	var mySelect = document.getElementById('lecturerSelect');	
	
	mySelect.value = temp.value;
	
</script>

</body>
</html>