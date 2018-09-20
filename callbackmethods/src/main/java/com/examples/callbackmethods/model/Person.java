package com.examples.callbackmethods.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;

	private String surname;
	
	private int age;
	
	public Person() {

	}
	
	public Person(String name, String surname, int age) {
		this.name=name;
		this.surname=surname;
		this.age=age;
	}
						//CALLBACK METHODS
	@PostLoad	//
	public void postLoad() {
		System.err.println("Person object has been gotten.");
	}
					
	@PrePersist
	public void prePersist() {
		System.err.println("Person object is being created.");
	}
	
	@PostPersist
	public void postPersist() {
		System.err.println("Person object has been created.");
	}
	
	@PreRemove
	public void preRemove() {
		System.err.println("Person object is being deleted.");
	}
	
	@PostRemove
	public void postRemove() {
		System.err.println("Person object has been deleted.");
	}
	
	@PreUpdate
	public void preUpdate() {
		System.err.println("Perrson object is being updating.");
	}
	
	@PostUpdate
	public void postUpdate() {
		System.err.println("Person object has been updated.");
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
	
}
