package com.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//1. Map class to database table
//2. Map field to database column
@Entity
@Table(name="user")

public class User {

	//declare variables
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="user_id")
		private int user_id;
		
		@Column(name="user_name")
		private String user_name;

		@Column(name="password")
		private String password;
		
		@Column(name="role_id")
		private int role_id;
		
		@Column(name="profile_image")
		private String profile_image;

		public User(String user_name, String password, int role_id, String profile_image) {
			super();
			this.user_name = user_name;
			this.password = password;
			this.role_id = role_id;
			this.profile_image = profile_image;
		}


		public User() {
			
		}


		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getRole_id() {
			return role_id;
		}

		public void setRole_id(int role_id) {
			this.role_id = role_id;
		}

		public String getProfile_image() {
			return profile_image;
		}

		public void setProfile_image(String profile_image) {
			this.profile_image = profile_image;
		}

		@Override
		public String toString() {
			return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", role_id="
					+ role_id + ", profile_image=" + profile_image + "]";
		}
	
}
