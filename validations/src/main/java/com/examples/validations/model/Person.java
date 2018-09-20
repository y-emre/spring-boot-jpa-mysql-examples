package com.examples.validations.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.NonNull;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_id")
	private long id;
	
	@NonNull
	@Length(min=3, max=15, message="Nonvalid length")
	private String name;
	
	@NonNull
	@Length(min=3, max=15, message="Nonvalid length")
	private String surname;
	
	@Past(message="Nonvalid date")
	@NonNull
	private Date birthday;
	
	@Pattern(regexp="(\\d){3,3}-\\d{3,3}-\\d{4,4}", message="Nonvalid format")
	private String phone;
	
	@Email(message="Nonvalid email")
	private String mail;
	
	@URL(message="Nonvalid url")
	private String webAddress;
	
	public Person() {

	}

	public Person(String name, String surname, Date birthday, String phone, String mail, String webAddress) {
		this.name=name;
		this.surname=surname;
		this.birthday=birthday;
		this.phone=phone;
		this.mail=mail;
		this.webAddress=webAddress;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", phone="
				+ phone + ", mail=" + mail + ", webAddress=" + webAddress + "]";
	}
	
}
