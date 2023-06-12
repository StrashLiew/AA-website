package com.dao.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CourseLecturerID implements Serializable {
	private Course course;
	private Lecturer lecturer;
	public CourseLecturerID(Course course, Lecturer lecturer) {
		super();
		this.course = course;
		this.lecturer = lecturer;
	}
	
	public CourseLecturerID() {
		
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
	
}
