package com.examples.entitylistener.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.examples.entitylistener.model.Person;

public class PersonListener {
				//LISTENER CLASS WITH CALLBACK METHODS 
	@PostLoad
	public void postLoad(Person person) {
		System.err.println("Person object is being getting.\nObject : "+ person);
	}
	
	@PrePersist
	public void prePersist(Person person) {
		System.err.println("Person object is being created.\nObject : " + person);
	}
	
	@PostPersist
	public void postPersist(Person person) {
		System.err.println("Person object has been created.\nObject : " + person);
	}
	
	@PreRemove
	public void preRemove(Person person) {
		System.err.println("Person object is being deleted.\nObject : " + person);
	}
	
	@PostRemove
	public void postRemove(Person person) {
		System.err.println("Person object has been deleted.\nObject : " + person);
	}
	
	@PreUpdate
	public void preUpdate(Person person) {
		System.err.println("Perrson object is being updating.\nObject : " + person);
	}
	
	@PostUpdate
	public void postUpdate(Person person) {
		System.err.println("Person object has been updated.\nObject : " + person);
	}

}
