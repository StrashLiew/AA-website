<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lecturer Profile</title>
<link href="Bootstrap/bootstrap-5.1.3-dist/css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<link href="resources/profile.css" rel="stylesheet" type="text/css">
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ page import="com.dao.UserDAO, com.dao.bean.User, com.dao.LecturerDAO, com.dao.bean.Lecturer, com.dao.DepartmentDAO" %>

<%
	HttpSession httpSession = request.getSession();
	int user_id = (int) httpSession.getAttribute("user_id");
	Lecturer currentLecturer = LecturerDAO.getLecturerByUserID(user_id);
	
	String name = currentLecturer.getLec_name();
	int id = currentLecturer.getLec_id();
	String email = currentLecturer.getLec_email();
	int department_id = currentLecturer.getLec_department_id();
	String intake = currentLecturer.getLec_intake();
	String department = DepartmentDAO.getDepartmentByID(department_id).getDepartment_name();
	
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
		<li style="z-index: 2;"><a href="leccalendar.jsp">Calendar<span><i class="fa-solid fa-calendar"></i></span></a></li>
		<li style="z-index: 1;"><a href="login.html">Logout<span><i class="fa-solid fa-arrow-right-from-bracket"></i></span></a></li>
	</ul>
</div>

<div>
<h2>LECTURER PROFILE</h2>
</div>

<div class="student-profile py-4">
  <div class="container">
    <div class="row">
      <div class="col-lg-4">
        <div class="card shadow-sm">
          <div class="card-header bg-transparent text-center">
            <img class="profile_img" src="https://placeimg.com/640/480/arch/any" alt="">
            <h2><%= currentLecturer.getLec_name() %></h2>
          </div>
          <div class="card-body">
            <p class="mb-0"><strong class="pr-1">Lecturer ID: </strong><%= name %></p>
            <p class="mb-0"><strong class="pr-1">Department: </strong><%= department %></p>
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
                <th width="40%">Work from</th>
                <td width="2%">:</td>
                <td><%= intake %></td>
              </tr>
              <tr>
                <th width="40%">Email</th>
                <td width="2%">:</td>
                <td><%= email %></td>
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
