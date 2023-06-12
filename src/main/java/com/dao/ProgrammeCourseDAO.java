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

public class ProgrammeCourseDAO {

	public static int save(int programme_id, int course_id, int lecturer_id) {

		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Programme.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(ProgrammeCourse.class)
				.addAnnotatedClass(ProgrammeCourseID.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Programme programme = (Programme) session.get(Programme.class, programme_id);
			Course course =  (Course) session.get(Course.class, course_id);
			
			ProgrammeCourseID programmeCourseID = new ProgrammeCourseID(programme, course);
			ProgrammeCourse programmeCourse = new ProgrammeCourse(programmeCourseID);
			
			session.save(programmeCourse);
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

	public static List<Course> getCourseListByProgramme(int programme_id) {

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
			Programme programme =  (Programme)session.get(Programme.class, programme_id);
			
			Set<ProgrammeCourse> programmeCourseSet = programme.getProgrammeCourse();
			for(ProgrammeCourse eachSet: programmeCourseSet) {
				allCourses.add(eachSet.getCourse());	
			}
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
	
	/* no update, admin can just delete and add new
	public static int UpdateProgrammeCourse(ProgrammeCourse programmeCourse) {
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Programme.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(ProgrammeCourse.class)
				.addAnnotatedClass(ProgrammeCourseID.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Programme programme = (Programme) session.get(Programme.class, programmeCourse.getProgramme().getProgramme_id());
			Course course =  (Course) session.get(Course.class, programmeCourse.getCourse().getCourse_id());
			  
			ProgrammeCourseID programmeCourseID = new ProgrammeCourseID(programme, course);
			
			ProgrammeCourse thisProgrammeCourse = (ProgrammeCourse)session.get(ProgrammeCourse.class, programmeCourseID);
			session.saveOrUpdate(thisProgrammeCourse);
			 
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
	*/
	
	public static int deleteProgrammeCourse(int programme_id, int course_id) {
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Programme.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(ProgrammeCourse.class)
				.addAnnotatedClass(ProgrammeCourseID.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Programme programme = (Programme) session.get(Programme.class, programme_id);
			Course course =  (Course) session.get(Course.class, course_id);
			  
			ProgrammeCourseID programmeCourseID = new ProgrammeCourseID(programme, course);			  
			ProgrammeCourse thisProgrammeCourse = (ProgrammeCourse)session.get(ProgrammeCourse.class, programmeCourseID);
			session.delete(thisProgrammeCourse);
			 
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
