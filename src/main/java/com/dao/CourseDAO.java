package com.dao;

import java.util.List;

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
import com.fasterxml.classmate.AnnotationConfiguration;

public class CourseDAO {

	public static int create(Course course) {

		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
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
			session.save(course);
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
	
	public static Course getCourseByID(int course_id) {
		
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
			Course course = session.get(Course.class, course_id);
			session.getTransaction().commit();
			return course;
		
		} catch (Exception ex) {
		
			System.out.println(ex);
			return null;
		
		} finally {
			
			session.close();
			factory.close();
		
		}

	}
	
	public static int update(int idToBeModified, Course toCourse) {
		
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			Course courseToBeModified = session.get(Course.class, idToBeModified);
			courseToBeModified.setCourse_id(toCourse.getCourse_id());
			courseToBeModified.setCourse_name(toCourse.getCourse_name());
			courseToBeModified.setCourse_credit(toCourse.getCourse_credit());
			courseToBeModified.setNum_of_student(toCourse.getNum_of_student());
			session.saveOrUpdate(courseToBeModified);
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
	
	public static int delete(int idToBeDeleted) {
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
			System.out.println(idToBeDeleted);
			Course course = session.load(Course.class, idToBeDeleted);
			System.out.println(course);
			session.delete((Course) session.load(Course.class, idToBeDeleted));
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
	
	public static List<Course> getAllCourse() {

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
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		List<Course> allCourses = null;
		
		try {
			
			session.beginTransaction();
			allCourses = session.createQuery("from Course").list();
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
	
}
