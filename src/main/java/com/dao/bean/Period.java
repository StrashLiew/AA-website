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
@Table(name="period")

public class Period {
	
	
	private int period_id;
	
	
	private String period_startTime;

	
	private String period_endTime;
	
	
	private String period_day;

	private Set<CoursePeriod> coursePeriod = new HashSet<CoursePeriod>();
	
	public Period(String period_startTime, String period_endTime, String period_day) {
		super();
		this.period_startTime = period_startTime;
		this.period_endTime = period_endTime;
		this.period_day = period_day;
	}
	
	public Period() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="period_id")
	public int getPeriod_id() {
		return period_id;
	}

	public void setPeriod_id(int period_id) {
		this.period_id = period_id;
	}

	@Column(name="period_startTime")
	public String getPeriod_startTime() {
		return period_startTime;
	}

	public void setPeriod_startTime(String period_startTime) {
		this.period_startTime = period_startTime;
	}

	@Column(name="period_endTime")
	public String getPeriod_endTime() {
		return period_endTime;
	}

	public void setPeriod_endTime(String period_endTime) {
		this.period_endTime = period_endTime;
	}

	@Column(name="period_day")
	public String getPeriod_day() {
		return period_day;
	}

	public void setPeriod_day(String period_day) {
		this.period_day = period_day;
	}

	@OneToMany(mappedBy = "primaryKeycp.period", cascade = CascadeType.ALL)
	public Set<CoursePeriod> getCoursePeriod() {
		return coursePeriod;
	}

	public void setCoursePeriod(Set<CoursePeriod> coursePeriod) {
		this.coursePeriod = coursePeriod;
	}
	public void addCoursePeriod(CoursePeriod coursePeriod) {
		this.coursePeriod.add(coursePeriod);
	}
	@Override
	public String toString() {
		return period_day + ": " + period_startTime.substring(0, 5) + "-" + period_endTime.substring(0, 5);
	}

}
