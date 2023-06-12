package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.bean.User;
import com.dao.bean.Admin;
import com.dao.bean.Lecturer;
import com.dao.bean.Student;

public class UserDAO {

	public static int create(User user) {

		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				                                                     .addAnnotatedClass(User.class)
				                                                     .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			session.save(user);
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
	
	public static User getUserByID(int id) {
		
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			User user = session.get(User.class, id);
			session.getTransaction().commit();
			return user;
		
		} catch (Exception ex) {
		
			System.out.println(ex);
			return null;
		
		} finally {
			
			session.close();
			factory.close();
		
		}

	}
	
	public static int update(int idToBeModified, User toUser) {
		
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			User userToBeModified = session.get(User.class, idToBeModified);	
			userToBeModified.setUser_name(toUser.getUser_name());
			userToBeModified.setPassword(toUser.getPassword());
			userToBeModified.setRole_id(toUser.getRole_id());
			userToBeModified.setProfile_image(toUser.getProfile_image());
			session.saveOrUpdate(userToBeModified);
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
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			User userToBeDeleted = session.load(User.class, idToBeDeleted);
			switch(userToBeDeleted.getRole_id()) {
				case 1: //Student
					Student studentToBeDeleted = StudentDAO.getStudentByUserID(idToBeDeleted);
					StudentDAO.delete(studentToBeDeleted.getStudent_id());
					break;
				case 2: //Lecturer
					Lecturer lecturerToBeDeleted = LecturerDAO.getLecturerByUserID(idToBeDeleted);
					LecturerDAO.delete(lecturerToBeDeleted.getLec_id());
					break;
			}
					
			session.delete(userToBeDeleted);
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
	
	public static List<User> getAllUser() {

		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				                                                     .addAnnotatedClass(User.class)
				                                                     .buildSessionFactory();

		Session session = factory.getCurrentSession();
		List<User> allUsers = null;
		
		try {
			
			session.beginTransaction();
			allUsers = session.createQuery("from User").list();
			session.getTransaction().commit();
	
		} catch (Exception ex) {
			
			System.out.println(ex);
			return null;
			
		} finally {
			
			session.close();
			factory.close();
			
		}
		
		return allUsers;
	}
	
	// return id, -1 means no matching username and password
	public static int verifyPassword(String username, String password) {
		
			List<User> allUsers = getAllUser();
			for(User eachUser: allUsers){
				if(eachUser.getUser_name().equals(username) && eachUser.getPassword().equals(password)) {
					return eachUser.getUser_id();
				}
			}
			return -1;
		
	}
	

}
