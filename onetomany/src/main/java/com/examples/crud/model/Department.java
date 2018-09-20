package com.examples.crud.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
	@OneToMany(mappedBy="department", fetch=FetchType.EAGER)	//default lazy
	@OrderBy("name DESC")
	private Set<Person> persons = new HashSet<>();
//--------------------------------------------------
	
	public Department() {

	}

	public Department(String departmentName, Set<Person> persons) {
		this.departmentName=departmentName;
		this.persons=persons;
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

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + "]";
	}
	
}
