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
@Table(name="role")

public class Role {

	//declare variables
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="role_id")
		private int role_id;
		
		@Column(name="role_name")
		private String role_name;

		public Role(String role_name) {
			super();
			this.role_name = role_name;
		}

		public Role() {
			
		}

		public int getRole_id() {
			return role_id;
		}

		public void setRole_id(int role_id) {
			this.role_id = role_id;
		}

		public String getRole_name() {
			return role_name;
		}

		public void setRole_name(String role_name) {
			this.role_name = role_name;
		}

		@Override
		public String toString() {
			return "Role [role_id=" + role_id + ", role_name=" + role_name + "]";
		}
		
}
