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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")

public class Course{
	
	private int course_id;
	
	
	private String course_name;
	
	
	private int course_credit;
	
	
	private int num_of_student;
	
	private Set<CourseStudent> courseStudent = new HashSet<CourseStudent>();
	
	private Set<CoursePeriod> coursePeriod = new HashSet<CoursePeriod>();
	
	private Set<CourseLecturer> courseLecturer = new HashSet<CourseLecturer>();
	
	private Set<ProgrammeCourse> programmeCourse = new HashSet<ProgrammeCourse>();

	public Course() {
	}

	public Course(String course_name, int course_credit, int num_of_student) {
		super();
		this.course_name = course_name;
		this.course_credit = course_credit;
		this.num_of_student = num_of_student;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	@Column(name="course_name")
	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	@Column(name="course_credit")
	public int getCourse_credit() {
		return course_credit;
	}

	public void setCourse_credit(int course_credit) {
		this.course_credit = course_credit;
	}

	@Column(name="num_of_student")
	public int getNum_of_student() {
		return num_of_student;
	}

	public void setNum_of_student(int num_of_student) {
		this.num_of_student = num_of_student;
	}

	@OneToMany(mappedBy = "primaryKey.course", cascade=CascadeType.ALL)
	public Set<CourseStudent> getCourseStudent() {
		return courseStudent;
	}

	public void setCourseStudent(Set<CourseStudent> courseStudent) {
		this.courseStudent = courseStudent;
	}

	public void addCourseStudent(CourseStudent courseStudent) {
		this.courseStudent.add(courseStudent);
	}
	
	@OneToMany(mappedBy = "primaryKeycp.course", cascade=CascadeType.ALL)
	public Set<CoursePeriod> getCoursePeriod() {
		return coursePeriod;
	}

	public void setCoursePeriod(Set<CoursePeriod> coursePeriod) {
		this.coursePeriod = coursePeriod;
	}
	public void addCoursePeriod(CoursePeriod coursePeriod) {
		this.coursePeriod.add(coursePeriod);
	}
	
	@OneToMany(mappedBy = "primaryKeycl.course", cascade=CascadeType.ALL)
	public Set<CourseLecturer> getCourseLecturer() {
		return courseLecturer;
	}

	public void setCourseLecturer(Set<CourseLecturer> courseLecturer) {
		this.courseLecturer = courseLecturer;
	}

	public void addCourseLecturer(CourseLecturer courseLecturer) {
		this.courseLecturer.add(courseLecturer);
	}
	
	/*
	 * @OneToMany(mappedBy = "primaryKeypc.course", cascade = CascadeType.ALL)
	 * public Set<ProgrammeCourse> getProgrammeCourse() { return programmeCourse; }
	 * 
	 * public void setProgrammeCourse(Set<ProgrammeCourse> programmeCourse) {
	 * this.programmeCourse = programmeCourse; }
	 * 
	 * public void addProgrammeCourse(ProgrammeCourse programmeCourse) {
	 * this.programmeCourse.add(programmeCourse); }
	 */
	
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_credit=" + course_credit
				+ ", num_of_student=" + num_of_student + "]";
	}
	
}
