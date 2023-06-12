package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.bean.Role;

public class RoleDAO {

	public static Role getRoleByID(int id) {
		
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Role.class)
                .buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			Role role = session.get(Role.class, id);
			session.getTransaction().commit();
			return role;
		
		} catch (Exception ex) {
		
			System.out.println(ex);
			return null;
		
		} finally {			
			session.close();
			factory.close();		
		}

	}
	
	public static void main(String[] args) {
		System.out.println(getRoleByID(1));
	}
}
