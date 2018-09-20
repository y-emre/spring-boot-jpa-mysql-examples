package com.examples.crud.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id			
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	private String surname;
	
	private int age;
	
//--------------------------------------
	@Embedded
	private Car car;
//--------------------------------------
	
	public Person() {

	}

	public Person(String name, String surname, int age, Car car) {
		this.name=name;
		this.surname=name;
		this.age=age;
		this.car=car;
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", car=" + car + "]";
	}
	
}
