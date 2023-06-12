package com.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")

public class Admin{

	//declare variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id")
	private int admin_id;
	
	@Column(name="user_id")
	private int user_id;

	@Column(name="admin_name")
	private String admin_name;

	public Admin(int user_id, String admin_name) {
		super();
		this.user_id = user_id;
		this.admin_name = admin_name;
	}

	public Admin() {
		
	}
	
	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", user_id=" + user_id + ", admin_name=" + admin_name + "]";
	}
	
}
