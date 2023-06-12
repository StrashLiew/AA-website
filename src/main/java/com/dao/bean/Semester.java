package com.dao.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="semester")

public class Semester {

	private int semester_id;
	
	private int semester_num;
		
	private String semester_year;
	
	private Set<SemesterStudent> semesterStudent = new HashSet<SemesterStudent>();

	public Semester(int semester_num, String semester_year) {
		super();
		this.semester_num = semester_num;
		this.semester_year = semester_year;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="semester_id")
	public int getSemester_id() {
		return semester_id;
	}

	public void setSemester_id(int semester_id) {
		this.semester_id = semester_id;
	}

	@Column(name="semester_num")
	public int getSemester_num() {
		return semester_num;
	}

	public void setSemester_num(int semester_num) {
		this.semester_num = semester_num;
	}

	@Column(name="semester_year")
	public String getSemester_year() {
		return semester_year;
	}

	public void setSemester_year(String semester_year) {
		this.semester_year = semester_year;
	}

	@OneToMany(mappedBy = "primaryKeyss.semester", cascade = CascadeType.ALL)
	public Set<SemesterStudent> getSemesterStudent() {
		return semesterStudent;
	}

	public void setSemesterStudent(Set<SemesterStudent> semesterStudent) {
		this.semesterStudent = semesterStudent;
	}
	public void addSemesterStudent(SemesterStudent semesterStudent){
		this.semesterStudent.add(semesterStudent);
	}
	
	@Override
	public String toString() {
		return "Semester [semester_id=" + semester_id + ", semester_num=" + semester_num + ", semester_year="
				+ semester_year + "]";
	}
	
}
