package com.examples.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.examples.crud.model.Department;
import com.examples.crud.model.Person;
import com.examples.crud.repository.DepartmentRepository;
import com.examples.crud.repository.PersonRepository;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PersonRepository personRepository, DepartmentRepository departmentRepository){
		return args -> {

			//save
			Department d = new Department();
			d.setDepartmentName("IT");
			
			Person p1 = new Person("Emre");
			Person p2 = new Person("Yunus");
			
			departmentRepository.save(d);
			
			p1.setDepartment(d);
			p2.setDepartment(d);
			
			personRepository.save(p1);
			personRepository.save(p2);
			
			System.err.println(departmentRepository.findById(1L).get().getPersons());
			
		};
	}
}
