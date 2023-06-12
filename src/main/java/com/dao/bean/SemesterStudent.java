package com.dao.bean;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="semester_student")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKeyss.student", 
				joinColumns = @JoinColumn(name="ss_student_id")),
	@AssociationOverride(name = "primaryKeyss.semester",
				joinColumns = @JoinColumn(name="ss_semester_id"))
})
public class SemesterStudent {
	private SemesterStudentID primaryKeyss = new SemesterStudentID();
	
	private int student_GPA;

	public SemesterStudent(SemesterStudentID primaryKeyss, int student_GPA) {
		super();
		this.primaryKeyss = primaryKeyss;
		this.student_GPA = student_GPA;
	}

	public SemesterStudent() {
		
	}

	@EmbeddedId
	public SemesterStudentID getPrimaryKeyss() {
		return primaryKeyss;
	}

	public void setPrimaryKeyss(SemesterStudentID primaryKeyss) {
		this.primaryKeyss = primaryKeyss;
	}
	
	@Transient
	public Student getStudent() {
		return getPrimaryKeyss().getStudent();
	}
	
	public void setStudent(Student student) {
		getPrimaryKeyss().setStudent(student);
	}
	
	@Transient
	public Semester getSemester() {
		return getPrimaryKeyss().getSemester();
	}
	
	public void setSemester(Semester semester) {
		getPrimaryKeyss().setSemester(semester);
	}

	@Column(name="student_GPA")
	public int getStudent_GPA() {
		return student_GPA;
	}

	public void setStudent_GPA(int student_GPA) {
		this.student_GPA = student_GPA;
	}

	@Override
	public String toString() {
		return "SemesterStudent [ss_semester_id =" + getSemester().getSemester_id() + "ss_student_id =" + getStudent().getStudent_id() +", student_GPA=" + student_GPA + "]";
	}
	
	
	
}
