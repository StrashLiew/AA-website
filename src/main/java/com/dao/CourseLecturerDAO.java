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

public class CourseLecturerDAO {

	public static int save(int course_id, int lecturer_id) {

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
			
			  Lecturer lecturer = (Lecturer) session.get(Lecturer.class, lecturer_id);
			  Course course =  (Course) session.get(Course.class, course_id);
			  
			  CourseLecturerID courseLecturerID = new CourseLecturerID(course, lecturer);
			  CourseLecturer newCourseLecturer = new CourseLecturer(courseLecturerID);
			  
			  session.save(newCourseLecturer);
			 
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

	public static List<Course> getCourseListByLecturer(int lecturer_id) {

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
		List<Course> allCourses = new ArrayList<Course>();

		try {

			session.beginTransaction();
			Lecturer lecturer =  (Lecturer)session.get(Lecturer.class, lecturer_id);
			
			Set<CourseLecturer> courseLecturerSet = lecturer.getCourseLecturer();
			for(CourseLecturer eachSet: courseLecturerSet) {
				allCourses.add(eachSet.getCourse());
				
			}
			//System.out.println(allCourses);
			session.getTransaction().commit();

		} catch (Exception ex) {

			System.out.println(ex);
			return null;

		} finally {

			session.close();
			factory.close();

		}

		return allCourses;

	}
	
	public static Lecturer getLecturerByCourse(int course_id) {

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

		Lecturer lecturer = null;
		
		try {

			session.beginTransaction();
			
			
			Course course =  (Course) session.get(Course.class, course_id);
			List<Lecturer> allLecturers = new ArrayList<Lecturer>();
			Set<CourseLecturer> courseLecturerSet = course.getCourseLecturer();
			for(CourseLecturer eachSet: courseLecturerSet) {
				allLecturers.add(eachSet.getLecturer());
				
			}
			//System.out.println(allStudents);
			session.getTransaction().commit();
			return allLecturers.get(0);

		} catch (Exception ex) {

			System.out.println(ex);
			return null;

		} finally {

			session.close();
			factory.close();

		}

		

	}
	
	/*
	 * public static int UpdateCourseLecturer(int course_id, int lecturer_id, int
	 * newlecturer_id) { SessionFactory factory = (SessionFactory) new
	 * Configuration() .configure("hibernate.cfg.xml")
	 * .addAnnotatedClass(Student.class) .addAnnotatedClass(Course.class)
	 * .addAnnotatedClass(CourseStudent.class)
	 * .addAnnotatedClass(CourseStudentID.class)
	 * .addAnnotatedClass(CoursePeriod.class) .addAnnotatedClass(Period.class)
	 * .addAnnotatedClass(CoursePeriodID.class)
	 * .addAnnotatedClass(CourseLecturer.class)
	 * .addAnnotatedClass(CourseLecturerID.class) .addAnnotatedClass(Lecturer.class)
	 * .addAnnotatedClass(Programme.class) .addAnnotatedClass(ProgrammeCourse.class)
	 * .addAnnotatedClass(ProgrammeCourseID.class)
	 * .addAnnotatedClass(Semester.class) .addAnnotatedClass(SemesterStudent.class)
	 * .addAnnotatedClass(SemesterStudentID.class) .buildSessionFactory();
	 * 
	 * Session session = factory.getCurrentSession();
	 * 
	 * try {
	 * 
	 * session.beginTransaction();
	 * 
	 * Lecturer lecturer = (Lecturer) session.get(Lecturer.class, lecturer_id);
	 * System.out.println(lecturer); Lecturer newlecturer = (Lecturer)
	 * session.get(Lecturer.class, newlecturer_id); System.out.println(newlecturer);
	 * Course course = (Course) session.get(Course.class, course_id);
	 * CourseLecturerID courseLecturerID = new CourseLecturerID(course, lecturer);
	 * CourseLecturer thisCourseLecturer =
	 * (CourseLecturer)session.get(CourseLecturer.class, courseLecturerID);
	 * System.out.println(thisCourseLecturer);
	 * 
	 * session.evict(thisCourseLecturer);
	 * thisCourseLecturer.setLecturer(newlecturer);
	 * System.out.println(thisCourseLecturer);
	 * 
	 * CourseLecturer mergedCL = (CourseLecturer) session.merge(thisCourseLecturer);
	 * 
	 * session.getTransaction().commit(); return 1;
	 * 
	 * } catch (Exception ex) {
	 * 
	 * System.out.println(ex); return 0;
	 * 
	 * } finally {
	 * 
	 * session.close(); factory.close();
	 * 
	 * }
	 * 
	 * }
	 */
	
	
	public static int deleteCourseLecturer(int lecturer_id, int course_id) {
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
			
			Lecturer lecturer = (Lecturer) session.get(Lecturer.class, lecturer_id);
			Course course =  (Course) session.get(Course.class, course_id);
			  
			CourseLecturerID courseLecturerID = new CourseLecturerID(course, lecturer);			  
			CourseLecturer thisCourseLecturer = (CourseLecturer)session.get(CourseLecturer.class, courseLecturerID);
			session.delete(thisCourseLecturer);
			 
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

	public static void UpdateCourseLecturer(int course_id, int lecturer_id, int newlecturer_id) {
		deleteCourseLecturer(lecturer_id, course_id);
		save(course_id, newlecturer_id);
	}
	
	public static void main(String args[]) {
	
		UpdateCourseLecturer(2,1,4);
		
	}
}
