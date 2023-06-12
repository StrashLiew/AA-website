package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.bean.Course;
import com.dao.bean.CourseStudent;
import com.dao.bean.CourseStudentID;
import com.dao.bean.Department;
import com.dao.bean.Student;
import com.fasterxml.classmate.AnnotationConfiguration;

public class DepartmentDAO {

	public static int create(Department department) {

		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				                                                     .addAnnotatedClass(Department.class)
				                                                     .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			session.save(department);
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
	
	public static Department getDepartmentByID(int department_id) {
		
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			Department department = session.get(Department.class, department_id);
			session.getTransaction().commit();
			return department;
		
		} catch (Exception ex) {
		
			System.out.println(ex);
			return null;
		
		} finally {
			
			session.close();
			factory.close();
		
		}

	}
	
	public static int update(int idToBeModified, Department toDepartment) {
		
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			Department departmentToBeModified = session.get(Department.class, idToBeModified);
			departmentToBeModified.setDepartment_id(toDepartment.getDepartment_id());
			departmentToBeModified.setDepartment_name(toDepartment.getDepartment_name());
			session.saveOrUpdate(departmentToBeModified);
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
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			session.delete((Department) session.load(Department.class, idToBeDeleted));
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
	
	public static List<Department> getAllDepartment() {

		SessionFactory factory = (SessionFactory) new Configuration()			
				.addAnnotatedClass(Department.class)
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		List<Department> allDepartments = null;
		
		try {
			
			session.beginTransaction();
			allDepartments = session.createQuery("from Department").list();
			session.getTransaction().commit();
	
		} catch (Exception ex) {
			
			System.out.println(ex);
			return null;
			
		} finally {
			
			session.close();
			factory.close();
			
		}
		
		return allDepartments;
	}
	
	public static void main(String args[]) {
		
	}
	
}
