package com.dao.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CoursePeriodID implements Serializable{
	private Course course;
	private Period period;
	@ManyToOne(cascade = CascadeType.ALL)
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	public CoursePeriodID(Course course, Period period) {
		super();
		this.course = course;
		this.period = period;
	}
	
	public CoursePeriodID() {
		
	}
}
