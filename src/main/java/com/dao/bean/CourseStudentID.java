package com.dao.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CourseStudentID implements Serializable{
	private Student student;
	private Course course;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public CourseStudentID(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
	}
	
	public CourseStudentID() {
		
	}
	
	
}
