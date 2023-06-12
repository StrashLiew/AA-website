package com.dao.bean;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="course_lecturer")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKeycl.lecturer", 
				joinColumns = @JoinColumn(name="cl_lecturer_id")),
	@AssociationOverride(name = "primaryKeycl.course",
				joinColumns = @JoinColumn(name="cl_course_id"))
})
public class CourseLecturer {
	
	private CourseLecturerID primaryKeycl = new CourseLecturerID();

	public CourseLecturer(CourseLecturerID primaryKeycl) {
		super();
		this.primaryKeycl = primaryKeycl;
	}
	
	public CourseLecturer() {
		
	}

	@EmbeddedId
	public CourseLecturerID getPrimaryKeycl() {
		return primaryKeycl;
	}

	public void setPrimaryKeycl(CourseLecturerID primaryKeycl) {
		this.primaryKeycl = primaryKeycl;
	}
	
	@Transient
	public Course getCourse() {
		return getPrimaryKeycl().getCourse();
	}
	
	public void setCourse(Course course) {
		getPrimaryKeycl().setCourse(course);
	}
	
	@Transient
	public Lecturer getLecturer() {
		return getPrimaryKeycl().getLecturer();
	}
	
	public void setLecturer(Lecturer lecturer) {
		getPrimaryKeycl().setLecturer(lecturer);
	}

	@Override
	public String toString() {
		return "CourseLecturer [cl_lecturer_id =" + getLecturer().getLec_id() + "cl_course_id =" + getCourse().getCourse_id() +"]";
	}
	
	
	
}
