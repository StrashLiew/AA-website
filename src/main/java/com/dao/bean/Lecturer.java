package com.dao.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="lecturer")

public class Lecturer{

	//declare variables
			
			private int lec_id;
			
			private int user_id;

			private String lec_name;
					
			private String lec_email;
			
			private int lec_department_id;
			
			private String lec_intake;
			
			private Set<CourseLecturer> courseLecturer = new HashSet<CourseLecturer>();
			
			public Lecturer(int user_id, String lec_name, String lec_email, int lec_department_id, String lec_intake) {
				super();
				this.user_id = user_id;
				this.lec_name = lec_name;
				this.lec_email = lec_email;
				this.lec_department_id = lec_department_id;
				this.lec_intake = lec_intake;
			}

			public Lecturer() {
				
			}
			
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="lec_id")
			public int getLec_id() {
				return lec_id;
			}

			public void setLec_id(int lec_id) {
				this.lec_id = lec_id;
			}

			@Column(name="user_id")
			public int getUser_id() {
				return user_id;
			}

			public void setUser_id(int user_id) {
				this.user_id = user_id;
			}

			@Column(name="lec_name")
			public String getLec_name() {
				return lec_name;
			}

			public void setLec_name(String lec_name) {
				this.lec_name = lec_name;
			}

			@Column(name="lec_email")
			public String getLec_email() {
				return lec_email;
			}

			public void setLec_email(String lec_email) {
				this.lec_email = lec_email;
			}
			
			@Column(name="lec_department_id")
			public int getLec_department_id() {
				return lec_department_id;
			}

			public void setLec_department_id(int lec_department_id) {
				this.lec_department_id = lec_department_id;
			}
			
			@Column(name="lec_intake")
			public String getLec_intake() {
				return lec_intake;
			}

			public void setLec_intake(String lec_intake) {
				this.lec_intake = lec_intake;
			}

			@OneToMany(mappedBy = "primaryKeycl.lecturer", cascade=CascadeType.ALL)
			public Set<CourseLecturer> getCourseLecturer() {
				return courseLecturer;
			}

			public void setCourseLecturer(Set<CourseLecturer> courseLecturer) {
				this.courseLecturer = courseLecturer;
			}
			public void addCourseLecturer(CourseLecturer courseLecturer) {
				this.courseLecturer.add(courseLecturer);
			}
			@Override
			public String toString() {
				return "Lecturer [lec_id=" + lec_id + ", user_id=" + user_id + ", lec_name=" + lec_name + ", lec_email="
						+ lec_email + ", lec_department_id=" + lec_department_id + "]";
			}
			
	
	/*
	public Timetable getTimetable() {
		return timetable;
	}
	
	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}
	
	public ArrayList<ArrayList<Course>> getCourses() {
		return courses;
	}
	
	public void setCourses(ArrayList<ArrayList<Course>> courseList) {
		this.courses = courseList;
	}
	
	public void appendCourses(ArrayList<Course> courseList) {
		this.courses.add(courseList);
	}
	*/

}
