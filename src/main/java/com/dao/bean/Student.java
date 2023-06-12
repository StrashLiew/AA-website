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
@Table(name="student")

public class Student {

	//declare variables
		
		private int student_id;
				
		private int user_id;
		
		private String student_name;
			
		private String student_email;
			
		private int student_programme_id;		
		
		private float student_CGPA;
				
		private int student_totalcredit;
		
		private String student_intake;
		
		private Set<CourseStudent> courseStudent = new HashSet<CourseStudent>();
		
		private Set<SemesterStudent> semesterStudent = new HashSet<SemesterStudent>();
		public Student() {
		}

		public Student(int user_id, String student_name, String student_email, int student_programme_id,
				float student_CGPA, int student_totalcredit, String intake) {
			super();
			this.user_id = user_id;
			this.student_name = student_name;
			this.student_email = student_email;
			this.student_programme_id = student_programme_id;
			this.student_CGPA = student_CGPA;
			this.student_totalcredit = student_totalcredit;
			this.student_intake = intake;
		}

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="student_id")
		public int getStudent_id() {
			return student_id;
		}

		public void setStudent_id(int student_id) {
			this.student_id = student_id;
		}

		@Column(name="user_id")
		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		@Column(name="student_name")
		public String getStudent_name() {
			return student_name;
		}

		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}

		@Column(name="student_email")
		public String getStudent_email() {
			return student_email;
		}

		public void setStudent_email(String student_email) {
			this.student_email = student_email;
		}

		@Column(name="student_programme_id")
		public int getStudent_programme_id() {
			return student_programme_id;
		}

		public void setStudent_programme_id(int student_programme_id) {
			this.student_programme_id = student_programme_id;
		}

		@Column(name="student_CGPA")
		public float getStudent_CGPA() {
			return student_CGPA;
		}

		public void setStudent_CGPA(float student_CGPA) {
			this.student_CGPA = student_CGPA;
		}

		@Column(name="student_totalcredit")
		public int getStudent_totalcredit() {
			return student_totalcredit;
		}

		public void setStudent_totalcredit(int student_totalcredit) {
			this.student_totalcredit = student_totalcredit;
		}
		
		@Column(name="student_intake")
		public String getStudent_intake() {
			return student_intake;
		}

		public void setStudent_intake(String student_intake) {
			this.student_intake = student_intake;
		}

		@OneToMany(mappedBy = "primaryKey.student", cascade = CascadeType.ALL)
		public Set<CourseStudent> getCourseStudent() {
			return courseStudent;
		}
		
		public void setCourseStudent(Set<CourseStudent> courseStudent) {
			this.courseStudent = courseStudent;
		}

		public void addCourseStudent(CourseStudent courseStudent) {
			this.courseStudent.add(courseStudent);
		}
		
		@OneToMany(mappedBy = "primaryKeyss.student", cascade = CascadeType.ALL)
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
			return "Student [student_id=" + student_id + ", user_id=" + user_id + ", student_name=" + student_name
					+ ", student_email=" + student_email + ", student_programme_id=" + student_programme_id
					+ ", student_CGPA=" + student_CGPA + ", student_totalcredit=" + student_totalcredit + "]";
		}

}
