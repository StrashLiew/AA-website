package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.bean.Admin;
import com.dao.bean.Student;

public class AdminDAO {

	public static int create(Admin admin) {

		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				                                                     .addAnnotatedClass(Admin.class)
				                                                     .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			session.save(admin);
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
	
	public static Admin getAdminByID(int user_id) {
		
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Admin.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			String hql = "FROM Admin A WHERE A.user_id = " + user_id;
			Admin admin = (Admin) session.createQuery(hql).list().get(0);
			session.getTransaction().commit();
			return admin;
		
		} catch (Exception ex) {
		
			System.out.println(ex);
			return null;
		
		} finally {
			
			session.close();
			factory.close();
		
		}

	}
	
	public static int update(int idToBeModified, Admin toAdmin) {
		
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Admin.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			Admin adminToBeModified = session.get(Admin.class, idToBeModified);
			adminToBeModified.setAdmin_id(toAdmin.getAdmin_id());
			adminToBeModified.setUser_id(toAdmin.getUser_id());
			adminToBeModified.setAdmin_name(toAdmin.getAdmin_name());
			session.saveOrUpdate(adminToBeModified);
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
                .addAnnotatedClass(Admin.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			session.delete((Admin) session.load(Admin.class, idToBeDeleted));
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
	
	public static List<Admin> getAllAdmin() {

		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Admin.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		List<Admin> allAdmins = null;
		
		try {
			
			session.beginTransaction();
			allAdmins = session.createQuery("from Admin").list();
			session.getTransaction().commit();
	
		} catch (Exception ex) {
			
			System.out.println(ex);
			return null;
			
		} finally {
			
			session.close();
			factory.close();
			
		}
		
		return allAdmins;
	}

}
