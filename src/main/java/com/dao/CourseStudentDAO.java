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

public class CourseStudentDAO {

	public static int save(int student_id, int course_id, int lecturer_id) {

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
			
			  Student student = (Student) session.get(Student.class, student_id);
			  Course course =  (Course) session.get(Course.class, course_id);
			  
			  CourseStudent courseStudent = new CourseStudent();
			  courseStudent.setCourse(course);
			  courseStudent.setStudent(student);
			  courseStudent.setLecturer_id(lecturer_id);
			  
			  session.save(courseStudent);
			 
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

	public static List<Course> getCourseListByStudent(int student_id) {

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
			Student student =  (Student)session.get(Student.class, student_id);
			
			Set<CourseStudent> courseStudentSet = student.getCourseStudent();
			for(CourseStudent eachSet: courseStudentSet) {
				allCourses.add(eachSet.getCourse());
				
			}
			
			session.getTransaction().commit();
			return allCourses;

		} catch (Exception ex) {

			System.out.println(ex);
			return null;

		} finally {

			session.close();
			factory.close();

		}

		

	}
	
	public static List<Student> getStudentListByCourse(int course_id) {

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
		List<Student> allStudents = new ArrayList<Student>();

		try {

			session.beginTransaction();
			
			
			Course course =  (Course) session.get(Course.class, course_id);
			
			Set<CourseStudent> courseStudentSet = course.getCourseStudent();
			for(CourseStudent eachSet: courseStudentSet) {
				allStudents.add(eachSet.getStudent());
				
			}
			//System.out.println(allStudents);
			session.getTransaction().commit();
			return allStudents;

		} catch (Exception ex) {

			System.out.println(ex);
			return null;

		} finally {

			session.close();
			factory.close();

		}

		

	}
	
	public static int UpdateCourseStudent(CourseStudent courseStudent) {
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
			
			Student student = (Student) session.get(Student.class, courseStudent.getStudent().getStudent_id());
			Course course =  (Course) session.get(Course.class, courseStudent.getCourse().getCourse_id());
			  
			CourseStudentID courseStudentID = new CourseStudentID(student, course);
			
			CourseStudent thisCourseStudent = (CourseStudent)session.get(CourseStudent.class, courseStudentID);
			thisCourseStudent.setStudent_marks(courseStudent.getStudent_marks());
			thisCourseStudent.setLecturer_id(courseStudent.getLecturer_id());
			session.saveOrUpdate(thisCourseStudent);
			 
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
	
	public static int deleteCourseStudent(int student_id, int course_id) {
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(CourseStudent.class)
				.addAnnotatedClass(CourseStudentID.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Student student = (Student) session.get(Student.class, student_id);
			Course course =  (Course) session.get(Course.class, course_id);
			  
			CourseStudentID courseStudentID = new CourseStudentID(student,course);			  
			CourseStudent thisCourseStudent = (CourseStudent)session.get(CourseStudent.class, courseStudentID);
			session.delete(thisCourseStudent);
			 
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

	public static int getMarksByCourseStudent(int course_id, int student_id) {

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
			Student student = (Student) session.get(Student.class, student_id);
			CourseStudentID courseStudentID = new CourseStudentID( student, course);
			CourseStudent thisCourseStudent = (CourseStudent) session.get(CourseStudent.class, courseStudentID);
			
			session.getTransaction().commit();
			return thisCourseStudent.getStudent_marks();
			
		} catch (Exception ex) {

			System.out.println(ex);
			return -1;

		} finally {

			session.close();
			factory.close();

		}
	}
	
	public static int getLecIDByCourseStudent(int course_id, int student_id) {

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
			Student student = (Student) session.get(Student.class, student_id);
			CourseStudentID courseStudentID = new CourseStudentID( student, course);
			CourseStudent thisCourseStudent = (CourseStudent) session.get(CourseStudent.class, courseStudentID);
			
			session.getTransaction().commit();
			return thisCourseStudent.getLecturer_id();
			
		} catch (Exception ex) {

			System.out.println(ex);
			return -1;

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
