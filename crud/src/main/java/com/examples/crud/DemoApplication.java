package com.examples.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.examples.crud.model.Person;
import com.examples.crud.repository.PersonRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PersonRepository personRepository){
		return args -> {
			//save
			personRepository.save(new Person("Yunus", "Emre", 24));
			personRepository.save(new Person("Yusuf", "Erkut", 23));

			//find all
			System.err.println("find all - " + personRepository.findAll());
			
			//find by id
			System.err.println("find by id - " + personRepository.findById(1L));
			
			//find by name
			System.err.println("find by name - " + personRepository.findByName("Yunus"));
			
			//find by age
			System.err.println("find by age - " + personRepository.findByAge(24));
			
			//update
			Person person = personRepository.findById(1L).get();
			person.setName("Ahmet");
			personRepository.save(person);
			System.err.println("find by name - " + personRepository.findByName("Ahmet"));
			
			//find all
			System.err.println(personRepository.findAll());
			
			//delete by id
			personRepository.deleteById(1L);
			System.err.println(personRepository.findAll());
			
			//delete by object
			person = personRepository.findById(2L).get();
			personRepository.delete(person);
			System.err.println(personRepository.findAll());
			
		};
	}
}
