package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.bean.Semester;

public class SemesterDAO {

	public static int create(Semester semester) {

		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				                                                     .addAnnotatedClass(Semester.class)
				                                                     .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			session.save(semester);
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
	
	public static Semester getSemesterByID(int semester_id) {
		
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Semester.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			Semester semester = session.get(Semester.class, semester_id);
			session.getTransaction().commit();
			return semester;
		
		} catch (Exception ex) {
		
			System.out.println(ex);
			return null;
		
		} finally {
			
			session.close();
			factory.close();
		
		}

	}
	
	public static int update(int idToBeModified, Semester toSemester) {
		
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Semester.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			Semester semesterdToBeModified = session.get(Semester.class, idToBeModified);
			semesterdToBeModified.setSemester_num(toSemester.getSemester_num());
			semesterdToBeModified.setSemester_year(toSemester.getSemester_year());
			session.saveOrUpdate(semesterdToBeModified);
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
                .addAnnotatedClass(Semester.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			session.delete((Semester) session.load(Semester.class, idToBeDeleted));
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
	
	public static List<Semester> getAllSemester() {

		SessionFactory factory = (SessionFactory) new Configuration()			
				.addAnnotatedClass(Semester.class)
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		List<Semester> allSemesters = null;
		
		try {
			
			session.beginTransaction();
			allSemesters = session.createQuery("from Semester").list();
			session.getTransaction().commit();
	
		} catch (Exception ex) {
			
			System.out.println(ex);
			return null;
			
		} finally {
			
			session.close();
			factory.close();
			
		}
		
		return allSemesters;
	}
	
	
	
}
