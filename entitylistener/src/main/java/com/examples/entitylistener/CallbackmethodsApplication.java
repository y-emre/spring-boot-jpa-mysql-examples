package com.examples.entitylistener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.examples.entitylistener.model.Person;
import com.examples.entitylistener.repository.PersonRepository;

@SpringBootApplication
public class CallbackmethodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallbackmethodsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PersonRepository personRepository){
		return args -> {
			
			Person person = new Person("Yunus", "Emre", 24);
			
			//Persist
			personRepository.save(person);
		//---------------------------------------------------

			//Find
			person = personRepository.findById(1L).get();
		//---------------------------------------------------
			
			//Update
			person.setName("Emre");
			person.setSurname("Yunus");
			
			personRepository.save(person);
		//---------------------------------------------------
			
			//Delete
			personRepository.deleteById(1L);
		//---------------------------------------------------
			
		};
	}
}
