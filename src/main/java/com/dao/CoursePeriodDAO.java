package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.bean.Course;
import com.dao.bean.CourseLecturer;
import com.dao.bean.CourseLecturerID;
import com.dao.bean.CoursePeriod;
import com.dao.bean.CoursePeriodID;
import com.dao.bean.CourseStudent;
import com.dao.bean.CourseStudentID;
import com.dao.bean.Lecturer;
import com.dao.bean.Period;
import com.dao.bean.Programme;
import com.dao.bean.ProgrammeCourse;
import com.dao.bean.ProgrammeCourseID;
import com.dao.bean.Semester;
import com.dao.bean.SemesterStudent;
import com.dao.bean.SemesterStudentID;
import com.dao.bean.Student;
import com.dao.bean.User;

public class CoursePeriodDAO {

	public static int save(int course_id, int period_id, String location) {

		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(CourseStudent.class)
				.addAnnotatedClass(CourseStudentID.class)
				.addAnnotatedClass(CoursePeriod.class)
				.addAnnotatedClass(Period.class)
				.addAnnotatedClass(CoursePeriodID.class)
				.addAnnotatedClass(CourseLecturer.class)
				.addAnnotatedClass(CourseLecturerID.class)
				.addAnnotatedClass(Lecturer.class)
				.addAnnotatedClass(Programme.class)
				.addAnnotatedClass(ProgrammeCourse.class)
				.addAnnotatedClass(ProgrammeCourseID.class)
				.addAnnotatedClass(Semester.class)
				.addAnnotatedClass(SemesterStudent.class)
				.addAnnotatedClass(SemesterStudentID.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			  Period period = (Period) session.get(Period.class, period_id);
			  Course course = (Course) session.get(Course.class, course_id);
			  
			  CoursePeriodID coursePeriodID = new CoursePeriodID(course, period);
			  CoursePeriod coursePeriod = new CoursePeriod(coursePeriodID, location);
			  
			  session.save(coursePeriod);
			 
			session.getTransaction().commit();
			return 1;

		} catch (Exception ex) {

			System.out.println(ex);
			return 0;

		} finally {

			session.close();
			factory.close();

		}
	}

	public static Period getPeriodByCourse(int course_id) {

		SessionFactory factory = (SessionFactory) new Configuration()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(CourseStudent.class)
				.addAnnotatedClass(CourseStudentID.class)
				.addAnnotatedClass(CoursePeriod.class)
				.addAnnotatedClass(Period.class)
				.addAnnotatedClass(CoursePeriodID.class)
				.addAnnotatedClass(CourseLecturer.class)
				.addAnnotatedClass(CourseLecturerID.class)
				.addAnnotatedClass(Lecturer.class)
				.addAnnotatedClass(Programme.class)
				.addAnnotatedClass(ProgrammeCourse.class)
				.addAnnotatedClass(ProgrammeCourseID.class)
				.addAnnotatedClass(Semester.class)
				.addAnnotatedClass(SemesterStudent.class)
				.addAnnotatedClass(SemesterStudentID.class)
				.configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			Course course =  (Course)session.get(Course.class, course_id);
			List<Period> allPeriods = new ArrayList<Period>();
			Set<CoursePeriod> courseStudentSet = course.getCoursePeriod();
			for(CoursePeriod eachSet: courseStudentSet) {
				allPeriods.add(eachSet.getPeriod());				
			}
			
			session.getTransaction().commit();
			return allPeriods.get(0);

		} catch (Exception ex) {

			System.out.println(ex);
			return null;

		} finally {

			session.close();
			factory.close();

		}

	}
	
	public static String getLocationByCoursePeriod(int course_id, int period_id) {

		SessionFactory factory = (SessionFactory) new Configuration()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(CourseStudent.class)
				.addAnnotatedClass(CourseStudentID.class)
				.addAnnotatedClass(CoursePeriod.class)
				.addAnnotatedClass(Period.class)
				.addAnnotatedClass(CoursePeriodID.class)
				.addAnnotatedClass(CourseLecturer.class)
				.addAnnotatedClass(CourseLecturerID.class)
				.addAnnotatedClass(Lecturer.class)
				.addAnnotatedClass(Programme.class)
				.addAnnotatedClass(ProgrammeCourse.class)
				.addAnnotatedClass(ProgrammeCourseID.class)
				.addAnnotatedClass(Semester.class)
				.addAnnotatedClass(SemesterStudent.class)
				.addAnnotatedClass(SemesterStudentID.class)
				.configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Course course = (Course) session.get(Course.class, course_id);
			Period period = (Period) session.get(Period.class, period_id);
			CoursePeriodID coursePeriodID = new CoursePeriodID(course, period);
			CoursePeriod thisCoursePeriod = (CoursePeriod) session.get(CoursePeriod.class, coursePeriodID);
			
			session.getTransaction().commit();
			return thisCoursePeriod.getCp_location();
			
		} catch (Exception ex) {

			System.out.println(ex);
			return "TBC";

		} finally {

			session.close();
			factory.close();

		}
	}
	
//	
//	public static List<Student> getStudentListByCourse(int course_id) {
//
//		SessionFactory factory = (SessionFactory) new Configuration()
//				.addAnnotatedClass(Student.class)
//				.addAnnotatedClass(Course.class)
//				.addAnnotatedClass(CourseStudent.class)
//				.addAnnotatedClass(CourseStudentID.class)
//				.addAnnotatedClass(CoursePeriod.class)
//				.addAnnotatedClass(Period.class)
//				.addAnnotatedClass(CoursePeriodID.class)
//				.addAnnotatedClass(CourseLecturer.class)
//				.addAnnotatedClass(CourseLecturerID.class)
//				.addAnnotatedClass(Lecturer.class)
//				.addAnnotatedClass(Programme.class)
//				.addAnnotatedClass(ProgrammeCourse.class)
//				.addAnnotatedClass(ProgrammeCourseID.class)
//				.addAnnotatedClass(Semester.class)
//				.addAnnotatedClass(SemesterStudent.class)
//				.addAnnotatedClass(SemesterStudentID.class)
//				.configure("hibernate.cfg.xml").buildSessionFactory();
//
//		Session session = factory.getCurrentSession();
//		List<Student> allStudents = new ArrayList<Student>();
//
//		try {
//
//			session.beginTransaction();
//			
//			
//			Course course =  (Course) session.get(Course.class, course_id);
//			
//			Set<CourseStudent> courseStudentSet = course.getCourseStudent();
//			for(CourseStudent eachSet: courseStudentSet) {
//				allStudents.add(eachSet.getStudent());
//				
//			}
//			//System.out.println(allStudents);
//			session.getTransaction().commit();
//			return allStudents;
//
//		} catch (Exception ex) {
//
//			System.out.println(ex);
//			return null;
//
//		} finally {
//
//			session.close();
//			factory.close();
//
//		}
//
//		
//
//	}
	
//	
	public static int updateCoursePeriod(CoursePeriod coursePeriod) {
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(CourseStudent.class)
				.addAnnotatedClass(CourseStudentID.class)
				.addAnnotatedClass(CoursePeriod.class)
				.addAnnotatedClass(Period.class)
				.addAnnotatedClass(CoursePeriodID.class)
				.addAnnotatedClass(CourseLecturer.class)
				.addAnnotatedClass(CourseLecturerID.class)
				.addAnnotatedClass(Lecturer.class)
				.addAnnotatedClass(Programme.class)
				.addAnnotatedClass(ProgrammeCourse.class)
				.addAnnotatedClass(ProgrammeCourseID.class)
				.addAnnotatedClass(Semester.class)
				.addAnnotatedClass(SemesterStudent.class)
				.addAnnotatedClass(SemesterStudentID.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Period period = (Period) session.get(Period.class, coursePeriod.getPeriod().getPeriod_id());
			Course course =  (Course) session.get(Course.class, coursePeriod.getCourse().getCourse_id());
			  
			CoursePeriodID coursePeriodID = new CoursePeriodID(course, period);
			
			CoursePeriod thisCoursePeriod = (CoursePeriod)session.get(CoursePeriod.class, coursePeriodID);
			thisCoursePeriod.setCp_location(coursePeriod.getCp_location());
			session.saveOrUpdate(thisCoursePeriod);
			 
			session.getTransaction().commit();
			return 1;

		} catch (Exception ex) {

			System.out.println(ex);
			return 0;

		} finally {

			session.close();
			factory.close();

		}

	}
	
	public static int deleteCoursePeriod(int period_id, int course_id) {
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(CourseStudent.class)
				.addAnnotatedClass(CourseStudentID.class)
				.addAnnotatedClass(CoursePeriod.class)
				.addAnnotatedClass(Period.class)
				.addAnnotatedClass(CoursePeriodID.class)
				.addAnnotatedClass(CourseLecturer.class)
				.addAnnotatedClass(CourseLecturerID.class)
				.addAnnotatedClass(Lecturer.class)
				.addAnnotatedClass(Programme.class)
				.addAnnotatedClass(ProgrammeCourse.class)
				.addAnnotatedClass(ProgrammeCourseID.class)
				.addAnnotatedClass(Semester.class)
				.addAnnotatedClass(SemesterStudent.class)
				.addAnnotatedClass(SemesterStudentID.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Period period = (Period) session.get(Period.class, period_id);
			Course course =  (Course) session.get(Course.class, course_id);
			  
			CoursePeriodID coursePeriodID = new CoursePeriodID(course, period);			  
			CoursePeriod thisCoursePeriod = (CoursePeriod)session.get(CoursePeriod.class, coursePeriodID);
			session.delete(thisCoursePeriod);
			 
			session.getTransaction().commit();
			return 1;

		} catch (Exception ex) {

			System.out.println(ex);
			return 0;

		} finally {

			session.close();
			factory.close();

		}

	}

	public static void main(String args[]) {
	//getStudentListByCourse(1);
	//deleteCourseStudent(3,1);
	//UpdateCourseStudent(new CourseStudent(new CourseStudentID(), int student_marks, int lecturer_id));
		//getCourseListByStudent(2);
	}
}
