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
@Table(name="course_period")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKeycp.period", 
				joinColumns = @JoinColumn(name="cp_period_id")),
	@AssociationOverride(name = "primaryKeycp.course",
				joinColumns = @JoinColumn(name="cp_course_id"))
})
public class CoursePeriod {
	
	private CoursePeriodID primaryKeycp = new CoursePeriodID();
	private String cp_location;
	public CoursePeriod(CoursePeriodID primaryKeycp, String cp_location) {
		super();
		this.primaryKeycp = primaryKeycp;
		this.cp_location = cp_location;
	}
	
	public CoursePeriod() {
	
	}

	@EmbeddedId
	public CoursePeriodID getPrimaryKeycp() {
		return primaryKeycp;
	}

	public void setPrimaryKeycp(CoursePeriodID primaryKeycp) {
		this.primaryKeycp = primaryKeycp;
	}

	@Column(name = "cp_location")
	public String getCp_location() {
		return cp_location;
	}

	public void setCp_location(String cp_location) {
		this.cp_location = cp_location;
	}
	
	@Transient
	public Course getCourse() {
		return getPrimaryKeycp().getCourse();
	}
	
	public void setCourse(Course course) {
		getPrimaryKeycp().setCourse(course);
	}
	
	@Transient
	public Period getPeriod() {
		return getPrimaryKeycp().getPeriod();
	}
	
	public void setPeriod(Period period) {
		getPrimaryKeycp().setPeriod(period);
	}

	@Override
	public String toString() {
		return "CoursePeriod [primaryKeycp=" + primaryKeycp + ", cp_location=" + cp_location + "]";
	}
	
	
}
