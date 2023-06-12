package com.dao.bean;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="course_student")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKey.student", 
				joinColumns = @JoinColumn(name="cs_student_id")),
	@AssociationOverride(name = "primaryKey.course",
				joinColumns = @JoinColumn(name="cs_course_id"))
})
public class CourseStudent {
	
	//declare variables
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.IDENTITY)
	 * 
	 * @Column(name="cs_student_id") private int cs_course_id;
	 * 
	 * @Column(name="cs_student_id") private int cs_student_id;
	 */

	//compositeKey
	private CourseStudentID primaryKey = new CourseStudentID();	
	
	private int student_marks;
	
	private int lecturer_id;

	public CourseStudent(CourseStudentID primaryKey, int student_marks, int lecturer_id) {
		super();
		this.primaryKey = primaryKey;
		this.student_marks = student_marks;
		this.lecturer_id = lecturer_id;
	}
	public CourseStudent() {
		
	}

	@EmbeddedId
	public CourseStudentID getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(CourseStudentID primaryKey) {
		this.primaryKey = primaryKey;
	}

	@Transient
	public Student getStudent() {
		return getPrimaryKey().getStudent();
	}
	
	public void setStudent(Student student) {
		getPrimaryKey().setStudent(student);
	}
	
	@Transient
	public Course getCourse() {
		return getPrimaryKey().getCourse();
	}
	
	public void setCourse(Course course) {
		getPrimaryKey().setCourse(course);
	}
	
	@Column(name="student_marks")
	public int getStudent_marks() {
		return student_marks;
	}

	public void setStudent_marks(int student_marks) {
		this.student_marks = student_marks;
	}

	@Column(name="lecturer_id")
	public int getLecturer_id() {
		return lecturer_id;
	}

	public void setLecturer_id(int lecturer_id) {
		this.lecturer_id = lecturer_id;
	}

	@Override
	public String toString() {
		/*
		 * return "CourseStudent [primaryKey=" + primaryKey + ", student_marks=" +
		 * student_marks + ", lecturer_id=" + lecturer_id + "]";
		 */
		return "CourseStudent [cs_student_id =" + getStudent().getStudent_id() + ", cs_course_id =" + getCourse().getCourse_id() + ", student_marks=" + student_marks + ", lecturer_id="
		+ lecturer_id + "]";
	}
	
	
	
	
}
