package com.examples.crud.model;

import java.util.List;
import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
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
	
//---------------------------------------------------
	@ElementCollection(fetch=FetchType.EAGER)	//EAGER FETCHING
	@CollectionTable(name="person_phones", joinColumns=@JoinColumn(name="person_id"))
	@Column(name="phone")
	List<String> phones;
//---------------------------------------------------

//---------------------------------------------------	
	@ElementCollection
	@CollectionTable(name="person_cars", joinColumns=@JoinColumn(name="person_id"))
	@MapKeyColumn(name="car_number_plate")
	@AttributeOverrides({
		@AttributeOverride(name="brand", column=@Column(name="car_brand")),
		@AttributeOverride(name="model", column=@Column(name="car_model")),
		@AttributeOverride(name="color", column=@Column(name="car_color"))
	})
	private Map<String, Car> cars;
//---------------------------------------------------	

	public Person() {

	}

	public Person(String name, String surname, int age, List<String> phones, Map<String, Car> cars) {
		this.name=name;
		this.surname=name;
		this.age=age;
		this.phones=phones;
		this.cars=cars;
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

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public Map<String, Car> getCars() {
		return cars;
	}

	public void setCars(Map<String, Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", phones=" + phones
				+ "]";
	}
	
}
