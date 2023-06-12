<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Profile</title>
<link href="Bootstrap/bootstrap-5.1.3-dist/css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<link href="resources/profile.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ page import="com.dao.UserDAO, com.dao.bean.User, com.dao.StudentDAO, com.dao.bean.Student, com.dao.ProgrammeDAO" %>

<%
	HttpSession httpSession = request.getSession();
	int user_id = (int) httpSession.getAttribute("user_id");
	Student currentStudent = StudentDAO.getStudentByUserID(user_id);
	
	String name = currentStudent.getStudent_name();
	int id = currentStudent.getStudent_id();
	String email = currentStudent.getStudent_email();
	int programme_id = currentStudent.getStudent_programme_id();
	String intake = currentStudent.getStudent_intake();
	float CGPA = currentStudent.getStudent_CGPA();
	int credit = currentStudent.getStudent_totalcredit();
	String programme = ProgrammeDAO.getProgrammeByID(programme_id).getProgramme_name();
	
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
<h2>STUDENT PROFILE</h2>
</div>

<div class="student-profile py-4">
  <div class="container">
    <div class="row">
      <div class="col-lg-4">
        <div class="card shadow-sm">
          <div class="card-header bg-transparent text-center">
            <img class="profile_img" src="https://placeimg.com/640/480/arch/any" alt="">
            <h2><%= name %></h2>
          </div>
          <div class="card-body">
            <p class="mb-0"><strong class="pr-1">Student ID: </strong><%= id %></p>
            <p class="mb-0"><strong class="pr-1">Programme: </strong><%= programme %></p>
          </div>
        </div>
      </div>
      <div class="col-lg-8">
        <div class="card shadow-sm">
          <div class="card-header bg-transparent border-0">
            <h3 class="mb-0"><i class="far fa-clone pr-1"></i>General Information</h3>
          </div>
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr>
                <th width="30%">Intake</th>
                <td width="2%">:</td>
                <td><%= intake %></td>
              </tr>
              <tr>
                <th width="30%">Email</th>
                <td width="2%">:</td>
                <td><%= email %></td>
              </tr>
              <tr>
                <th width="30%">CGPA</th>
                <td width="2%">:</td>
                <td><%= CGPA %></td>
              </tr>
              <tr>
                <th width="30%">Total Credit</th>
                <td width="2%">:</td>
                <td><%= credit %></td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>



<footer class="page-footer">
	<div class="gif"><img src="https://www.animatedimages.org/data/media/209/animated-cat-image-0421.gif"></div>
	<div class="footer-copyright text-center">Copyright @ CAT University All Rights Reserved</div>
</footer>

</body>
</html>
