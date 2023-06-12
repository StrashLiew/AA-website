package com.dao.bean;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="programme_course")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKeypc.programme", 
				joinColumns = @JoinColumn(name="pc_programme_id")),
	@AssociationOverride(name = "primarypc.course",
				joinColumns = @JoinColumn(name="pc_course_id"))
})
public class ProgrammeCourse {
	
	private ProgrammeCourseID primaryKeypc = new ProgrammeCourseID();

	public ProgrammeCourse(ProgrammeCourseID primaryKeypc) {
		super();
		this.primaryKeypc = primaryKeypc;
	}
	
	public ProgrammeCourse() {
		
	}
	
	@EmbeddedId
	public ProgrammeCourseID getPrimaryKeypc() {
		return primaryKeypc;
	}

	public void setPrimaryKeypc(ProgrammeCourseID primaryKeypc) {
		this.primaryKeypc = primaryKeypc;
	}
	
	@Transient
	public Course getCourse() {
		return getPrimaryKeypc().getCourse();
	}
	
	public void setCourse(Course course) {
		getPrimaryKeypc().setCourse(course);
	}
	
	@Transient
	public Programme getProgramme() {
		return getPrimaryKeypc().getProgramme();
	}
	
	public void setProgramme(Programme programme) {
		getPrimaryKeypc().setProgramme(programme);
	}

	@Override
	public String toString() {
		return "ProgrammeCourse [pc_programme_id =" + getProgramme().getProgramme_id() + ", pc_course_id =" + getCourse().getCourse_id() + "]";
	}
	
	

}
