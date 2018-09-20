package com.examples.crud.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity						//firm_id | name
@Table(name="firm")
public class Firm {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="firm_id")
	private long id;
	
	private String name;

//--------------------------------------------------
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)	//default lazy
	@JoinTable(name="firms_departments", joinColumns=@JoinColumn(name="firm_id"), inverseJoinColumns=@JoinColumn(name="department_id"))
	Set<Department> departments = new HashSet<>();
//--------------------------------------------------
	
	public Firm() {

	}

	public Firm(String name) {
		this.name=name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Firm [id=" + id + ", name=" + name + ", departments=" + departments + "]";
	}
	
}
