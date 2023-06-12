package com.dao.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ProgrammeCourseID implements Serializable{
	private Programme programme;
	private Course course;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public ProgrammeCourseID(Programme programme, Course course) {
		super();
		this.programme = programme;
		this.course = course;
	}
	
	public ProgrammeCourseID() {
		
	}
	
	
	
}
