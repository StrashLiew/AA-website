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
@Table(name="programme")

public class Programme {
	
	private int programme_id;
	
	private String programme_name;
	
	private Set<ProgrammeCourse> programmeCourse = new HashSet<ProgrammeCourse>();

	public Programme(String programme_name) {
		super();
		this.programme_name = programme_name;
	}
	
	public Programme() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="programme_id")
	public int getProgramme_id() {
		return programme_id;
	}

	public void setProgramme_id(int programme_id) {
		this.programme_id = programme_id;
	}

	@Column(name="programme_name")
	public String getProgramme_name() {
		return programme_name;
	}

	public void setProgramme_name(String programme_name) {
		this.programme_name = programme_name;
	}

	@OneToMany(mappedBy = "primaryKeypc.programme", cascade = CascadeType.ALL)
	public Set<ProgrammeCourse> getProgrammeCourse() {
		return programmeCourse;
	}

	public void setProgrammeCourse(Set<ProgrammeCourse> programmeCourse) {
		this.programmeCourse = programmeCourse;
	}
	
	public void addProgrammeCourse(ProgrammeCourse programmeCourse) {
		this.programmeCourse.add(programmeCourse);
	}

	@Override
	public String toString() {
		return "Programme [programme_id=" + programme_id + ", programme_name=" + programme_name + "]";
	}

}
