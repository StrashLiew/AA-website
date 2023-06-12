<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.List, com.dao.UserDAO, com.dao.bean.User, com.dao.bean.CourseStudent, com.dao.CourseStudentDAO, com.dao.bean.CourseStudentID, com.dao.StudentDAO, com.dao.LecturerDAO, com.dao.bean.Lecturer, com.dao.bean.Student, com.dao.bean.Course, com.dao.CourseDAO, com.dao.bean.Period, com.dao.CoursePeriodDAO, com.dao.bean.CourseStudent, com.dao.CourseStudentDAO, com.dao.CourseLecturerDAO" %>
<%


	HttpSession httpSession = request.getSession();
	int user_id = (int) httpSession.getAttribute("user_id");
	Lecturer currentLecturer = LecturerDAO.getLecturerByUserID(user_id);
	
	String name = currentLecturer.getLec_name();
	int id = currentLecturer.getLec_id();
	int course_id = Integer.parseInt(request.getParameter("courseID"));
	Course thisCourse = CourseDAO.getCourseByID(course_id);

	
	int stuID = Integer.parseInt(request.getParameter("studentid"));
	Student thisStudent = StudentDAO.getStudentByID(stuID);
	
	float testMarks = Float.parseFloat(request.getParameter("mark"));
	
	int marks = (int)testMarks;
	
	if(marks < 0 || marks > 100){
		response.sendRedirect("stddetails.jsp?courseID=" + course_id); 
		return;
	}
	
	
	CourseStudentID csID = new CourseStudentID( thisStudent , thisCourse);
	CourseStudent courseStudent = new CourseStudent(csID, marks, id);
	int i = CourseStudentDAO.UpdateCourseStudent(courseStudent);
	response.sendRedirect("stddetails.jsp?courseID=" + course_id);
	
%>
</body>
</html>