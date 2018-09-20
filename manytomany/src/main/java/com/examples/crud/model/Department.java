package com.examples.crud.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity							//department_id	| department_name
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_id")
	private long id;
	
	@Column(name="department_name")
	private String departmentName;
	
//--------------------------------------------------
	@ManyToMany(mappedBy="departments")
	private Set<Firm> firms = new HashSet<>();
//--------------------------------------------------
	
	public Department() {

	}

	public Department(String departmentName) {
		this.departmentName=departmentName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Firm> getFirms() {
		return firms;
	}

	public void setFirms(Set<Firm> firms) {
		this.firms = firms;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + "]";
	}
	
}
