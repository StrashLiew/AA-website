<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Timetable</title>
<link href="resources/navbar.css" rel="stylesheet" type="text/css">
<link href="resources/header.css" rel="stylesheet" type="text/css">
<link href="resources/timetable.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/a4ee3fc773.js" crossorigin="anonymous"></script>
</head>
<body>

<%@ page import="java.util.*, com.dao.UserDAO, com.dao.bean.User, com.dao.LecturerDAO, com.dao.bean.Lecturer, com.dao.bean.Course, com.dao.bean.Period, com.dao.CoursePeriodDAO, com.dao.bean.CourseStudent, com.dao.CourseStudentDAO, com.dao.CourseLecturerDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	HttpSession httpSession = request.getSession();
	int user_id = (int) httpSession.getAttribute("user_id");
	Lecturer currentLecturer = LecturerDAO.getLecturerByUserID(user_id);
	
	String name = currentLecturer.getLec_name();
	int id = currentLecturer.getLec_id();
	
	List<Course> courseList = CourseLecturerDAO.getCourseListByLecturer(id);	
	List<Period> periodList = new ArrayList<Period>();
	
	List<String> days = new ArrayList<String>();
	days.add("Sunday");
	days.add("Monday");
	days.add("Tuesday");
	days.add("Wednesday");
	days.add("Thursday");
	days.add("Friday");
	days.add("Saturday");	
	
	// Declare and initialize
	Course[][] timetable = new Course[14][7];
	int[][] rowSpan = new int[14][7];
	String[][] status = new String[14][7];
	for(int r = 0; r < 14; r++) {
		for(int c = 0; c < 7; c++) {
			timetable[r][c] = null;
			rowSpan[r][c] = 1;
			status[r][c] = "normal";
		}
	}
	
	// Loop for each course, get the period and store in timetable
	for(Course eachCourse: courseList) {
		Period period = CoursePeriodDAO.getPeriodByCourse(eachCourse.getCourse_id());
		periodList.add(period);
		String day = period.getPeriod_day();
		String startTime = period.getPeriod_startTime();
		int parsedStartTime = Integer.parseInt(startTime.substring(0, startTime.length()-6));
		String endTime = period.getPeriod_endTime();
		int parsedEndTime = Integer.parseInt(endTime.substring(0, endTime.length()-6));
		int column = days.indexOf(day);
		int row = parsedStartTime - 8;
		timetable[row][column] = eachCourse;
		rowSpan[row][column] = parsedEndTime - parsedStartTime;
		for(int occupy = 1; occupy < rowSpan[row][column]; occupy ++) {
			status[row + occupy][column] = "occupied";
		}
	}
	
	
	String[] times = {"8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM"};
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
<h2>TIMETABLE</h2>
</div>

<div class="content timetable-content">
	<div class="container">
  
  <div class="topHeader"> 
    <h1>Class Schedule</h1>
    
    <table class = "tableHeader">
    <tr>
      <th>Time</th>
      <th>Sunday</th>
      <th>Monday</th>
      <th>Tuesday</th>
      <th>Wednesday</th>
      <th>Thursday</th>
      <th>Friday</th>
      <th>Saturday</th>
    </tr> 
  </table>
  </div>
  
  <div class="scheduleArea">
      
    
  <table class="tableTimes">
   <%
    	for(int i = 0; i < 14; i++) { // for each hour (8am to 9pm)
    		out.print("<tr>");
    			out.print("<th class='time'>");
    			out.print(times[i]);
    			out.print("</th>");
    			for(int j = 0; j < 7; j++) { // for each day
    				if(status[i][j].equals("occupied")) {
    					continue;
    				} else if(timetable[i][j] == null) {
	    				out.print("<td class='" + days.get(j).toLowerCase() + "'></td>");
	    			} else {
	    				Course thisCourse = timetable[i][j];
	    				int thisCourseID = thisCourse.getCourse_id();
	    				String thisCourseName = thisCourse.getCourse_name();
	    				Period thisPeriod = CoursePeriodDAO.getPeriodByCourse(thisCourseID);
		    				
	    				out.print("<td class='" + days.get(j).toLowerCase() + "' ");
	    				out.print("rowspan='" + rowSpan[i][j] + "' style='background: #FCE6C9;'>");
		    				out.print(thisCourseID);
		    				out.print("<br>");
		    				out.print(thisCourseName);
		    				out.print("<br>");
		    				out.print(CoursePeriodDAO.getLocationByCoursePeriod(thisCourseID, thisPeriod.getPeriod_id()));
	        			out.print("</td>");
	    			}
    			}
    		out.print("</tr>");
    		    
    			
    	}
    
    %>

    
  </table>
  </div>
</div>
</div>

<footer class="page-footer">
	<div class="gif"><img src="https://www.animatedimages.org/data/media/209/animated-cat-image-0421.gif"></div>
	<div class="footer-copyright text-center">Copyright @ CAT University All Rights Reserved</div>
</footer>


</body>
</html>