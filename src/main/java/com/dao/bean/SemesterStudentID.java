package com.dao.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class SemesterStudentID implements Serializable{
	private Semester semester;
	private Student student;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public SemesterStudentID(Semester semester, Student student) {
		super();
		this.semester = semester;
		this.student = student;
	}
	public SemesterStudentID() {
		
	}
	
	
	
}
